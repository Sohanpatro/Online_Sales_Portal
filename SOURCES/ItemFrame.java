

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ItemFrame extends javax.swing.JFrame {

    transient Item item;
    transient Seller seller;
    transient Buyer buyer;
    transient int framenature;
    transient double price = 0;
    transient JFrame parentobj;
    transient String accept = "/-";

    public ItemFrame(int itemID, Buyer buyertmp, int frametype, JFrame parentframe) throws SQLException {
        buyer = buyertmp;
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");
        } catch (MalformedURLException ex) {
        }

        try {
            BufferedImage back = null;
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 785, 485, back.getType()))));
        } catch (IOException ex) {
        }
        framenature = frametype;
        try {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "select * from itemrecord where id = ?";
            PreparedStatement preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, itemID);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();
            rs.next();
            item = new Item();
            item.id = rs.getInt("id");
            item.categoryId = rs.getInt("category");
            item.price = rs.getDouble("price");
            price = item.price;
            item.ownerId = rs.getInt("ownerid");
            item.age = rs.getDouble("age");
            item.city = rs.getString("city");
            item.info = rs.getString("info");
            item.isHeavy = rs.getBoolean("isheavy");
            item.isNew = rs.getBoolean("isnew");
            item.mfgComp = rs.getString("mfgcomp");
            Blob blob = rs.getBlob("photo");
            int bloblength = (int) blob.length();
            byte[] blobbytes = blob.getBytes(1, bloblength);
            try {
                item.photo = ImageIO.read(new ByteArrayInputStream(blobbytes));
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            query = "select * from sellerrecord where id = ?";
            preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, item.ownerId);
            rs = preparedStmt.executeQuery();
            rs.next();
            BufferedImage tempimid = null;
            blob = rs.getBlob("imid");
            if (blob != null) {
                bloblength = (int) blob.length();
                blobbytes = blob.getBytes(1, bloblength);
                try {
                    tempimid = ImageIO.read(new ByteArrayInputStream(blobbytes));
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                tempimid = null;
            }
            seller = new Seller(item.ownerId, rs.getString("name"), rs.getString("city"), rs.getString("telephone"), rs.getString("email"), rs.getString("password"), tempimid);
            query = "select * from requestrecord where buyerid = ? and itemid = ?";
            preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, buyer.id);
            preparedStmt.setInt(2, item.id);
            rs = null;
            rs = preparedStmt.executeQuery();
            if (rs.next() && rs.getBoolean("status")) {
                price = rs.getInt("price");
                accept = "/- [accepted]";
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
        initComponents();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
        if (framenature == 1) {
            reqbtn.setEnabled(false);
            negotiatebutton.setEnabled(true);
        } else if (framenature == 2) {
            reqbtn.setEnabled(false);
            negotiatebutton.setEnabled(false);
            paybtn.setEnabled(false);
        }
        imagelabel.setIcon(new ImageIcon(item.photo));
        sellerfield.setText(seller.name);
        cityfield.setText(item.city);
        agefield.setText(Double.toString(item.age));
        pricefield.setText(Double.toString(item.price));
        infota.setText(item.info);
        jLabel6.setEditable(false);
        jLabel6.setLineWrap(true);
        if (item.isHeavy) {
            jLabel6.setText("* It is a heavy item.\n Can only be sold if the seller and  buyer cities are same.");
        } else {
            jLabel6.setText("*It is not a heavy item.");
        }
        if (item.isNew) {
            jLabel7.setText("The item is brand new");
        }
        if (!(buyer.city.equalsIgnoreCase(seller.city)) && item.isHeavy) {
            paybtn.setEnabled(false);
            reqbtn.setEnabled(false);
        }
        parentobj = parentframe;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent window) {
                parentobj.setEnabled(true);
            }
        });
        setTitle("ONLINE SALES PORTAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagelabel = new javax.swing.JLabel();
        sellerfield = new javax.swing.JTextField();
        cityfield = new javax.swing.JTextField();
        agefield = new javax.swing.JTextField();
        pricefield = new javax.swing.JTextField();
        reqbtn = new javax.swing.JButton();
        negotiatebutton = new javax.swing.JButton();
        paybtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        infota = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel6 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        sellerfield.setEditable(false);

        cityfield.setEditable(false);

        agefield.setEditable(false);

        pricefield.setEditable(false);

        reqbtn.setText("Raise Request");
        reqbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqbtnActionPerformed(evt);
            }
        });

        negotiatebutton.setText("negotiate");
        negotiatebutton.setToolTipText("You can negotiate with the seller after raising request and offering your desired price.");
        negotiatebutton.setEnabled(false);
        negotiatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negotiatebuttonActionPerformed(evt);
            }
        });

        paybtn.setText("Pay bill online");
        paybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paybtnActionPerformed(evt);
            }
        });

        infota.setEditable(false);
        infota.setColumns(20);
        infota.setLineWrap(true);
        infota.setRows(5);
        jScrollPane2.setViewportView(infota);

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel1.setText("Seller :");

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel2.setText("City :");

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel3.setText("Age :");

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel4.setText("Information :");

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel5.setText("Price :");

        jLabel6.setColumns(20);
        jLabel6.setRows(5);
        jScrollPane1.setViewportView(jLabel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reqbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(negotiatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(paybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cityfield, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(agefield)
                                    .addComponent(sellerfield)
                                    .addComponent(pricefield))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(20, 20, 20))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imagelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sellerfield, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agefield, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pricefield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(negotiatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(reqbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reqbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqbtnActionPerformed
        String strNewPrice = JOptionPane.showInputDialog("Offer your desired Price for the Item :");
        if (strNewPrice != null) {
            try {
                double newPrice = Double.parseDouble(strNewPrice);
                if (newPrice < 0) {
                    JOptionPane.showMessageDialog(null, "Price cannot be negative !", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        DBConnection dbc = new DBConnection();
                        Connection con = dbc.getConnnection();
                        String query = "insert into requestrecord(ownerid, buyerid, itemid, price, status)  values (?,?,?,?,?)";
                        PreparedStatement preparedStmt = null;
                        preparedStmt = con.prepareStatement(query);
                        preparedStmt.setInt(1, item.ownerId);
                        preparedStmt.setInt(2, buyer.id);
                        preparedStmt.setInt(3, item.id);
                        preparedStmt.setDouble(4, newPrice);
                        preparedStmt.setBoolean(5, false);
                        preparedStmt.execute();
                        JOptionPane.showMessageDialog(null, "Offer registered.\nYou are free to negotiate with the Owner.");
                        reqbtn.setEnabled(false);
                        negotiatebutton.setEnabled(true);
                        con.close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid price !", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_reqbtnActionPerformed

    private void paybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paybtnActionPerformed
        try {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "update itemrecord set status = ? where id = ? and status = ?";
            PreparedStatement preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setBoolean(1, true);
            preparedStmt.setInt(2, item.id);
            preparedStmt.setBoolean(3, false);
            if (preparedStmt.executeUpdate() > 0) {
                // the mysql insert statement
                query = "select * from requestrecord where buyerid = ? and itemid = ?";
                preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, buyer.id);
                preparedStmt.setInt(2, item.id);
                ResultSet rs = null;
                try {
                    rs = preparedStmt.executeQuery();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if (!rs.next()) {
                    query = "insert into requestrecord(ownerid, buyerid, itemid, price, status)  values (?,?,?,?,?)";
                    preparedStmt = null;
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, item.ownerId);
                    preparedStmt.setInt(2, buyer.id);
                    preparedStmt.setInt(3, item.id);
                    preparedStmt.setDouble(4, item.price);
                    preparedStmt.setBoolean(5, true);
                    preparedStmt.execute();
                    reqbtn.setEnabled(false);
                }
                query = "delete from requestrecord where itemid = ? and buyerid not in ( ? ) ";
                preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, item.id);
                preparedStmt.setInt(2, buyer.id);
                preparedStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Your item will be shipped within 10 days.\n You can return within 15 days after you receive the item with full refund", "Congratulations", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry For the inconvinience.\n The item is already purchased.");
            }
            con.close();
            parentobj.setEnabled(true);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
    }//GEN-LAST:event_paybtnActionPerformed

    private void negotiatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negotiatebuttonActionPerformed
        this.setEnabled(false);
        EmailFrame emailFrame = new EmailFrame(buyer.id, 0, item.ownerId, 1, this);
    }//GEN-LAST:event_negotiatebuttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agefield;
    private javax.swing.JTextField cityfield;
    private javax.swing.JLabel imagelabel;
    private javax.swing.JTextArea infota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextArea jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton negotiatebutton;
    private javax.swing.JButton paybtn;
    private javax.swing.JTextField pricefield;
    private javax.swing.JButton reqbtn;
    private javax.swing.JTextField sellerfield;
    // End of variables declaration//GEN-END:variables
}
