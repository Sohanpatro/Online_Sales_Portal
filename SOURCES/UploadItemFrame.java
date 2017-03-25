

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UploadItemFrame extends javax.swing.JFrame {

    transient Seller seller;
    transient SellerFrame parentobj;
    transient BufferedImage bi = null;

    public UploadItemFrame(Seller sellerinfo, SellerFrame parent) {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");        } catch (MalformedURLException ex) {
        }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 573, 528, back.getType()))));
        } catch (IOException ex) {
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
            java.util.logging.Logger.getLogger(UploadItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UploadItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UploadItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UploadItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
        try {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "select * from categoryrecord";
            PreparedStatement preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                categorylist.addItem(new Category(rs.getInt("id"), rs.getString("category")));
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }

        categorylist.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> categorylist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(categorylist, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Category) {
                    ((JLabel) renderer).setText(((Category) value).category);
                }
                return renderer;
            }
        });
        seller = sellerinfo;
        parentobj = parent;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cityfield = new javax.swing.JTextField();
        pricefield = new javax.swing.JTextField();
        submitdetails = new javax.swing.JButton();
        mfgcmpfield = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        photobutton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoarea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        agefield = new javax.swing.JTextField();
        newbox = new javax.swing.JCheckBox();
        heavybox = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        categorylist = new JComboBox();
        ivcitylbl = new javax.swing.JLabel();
        ivpricelbl = new javax.swing.JLabel();
        ivmnfclbl = new javax.swing.JLabel();
        ivinfolbl = new javax.swing.JLabel();
        ivagelbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Category         :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Photo             :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Price              :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("City                :");

        submitdetails.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        submitdetails.setText("Submit");
        submitdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitdetailsActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText(" Manufacturing Company     :");

        photobutton.setText("Browse");
        photobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photobuttonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("     Some Information  :");

        infoarea.setColumns(20);
        infoarea.setRows(5);
        jScrollPane1.setViewportView(infoarea);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Age (if not new) :");

        newbox.setText("New");
        newbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newboxActionPerformed(evt);
            }
        });

        heavybox.setText("Heavy");

        jLabel8.setText("(in years)");

        categorylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorylistActionPerformed(evt);
            }
        });

        ivcitylbl.setForeground(new java.awt.Color(255, 0, 0));

        ivpricelbl.setForeground(new java.awt.Color(255, 0, 0));

        ivmnfclbl.setForeground(new java.awt.Color(255, 0, 0));

        ivinfolbl.setForeground(new java.awt.Color(255, 0, 0));

        ivagelbl.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cityfield)
                            .addComponent(pricefield)
                            .addComponent(mfgcmpfield)
                            .addComponent(photobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categorylist, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ivcitylbl, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(ivpricelbl, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(ivmnfclbl, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ivinfolbl, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(agefield, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(newbox)
                                        .addGap(80, 80, 80)
                                        .addComponent(heavybox)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ivagelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categorylist, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cityfield)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ivcitylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(photobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pricefield)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ivpricelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mfgcmpfield, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ivmnfclbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(ivinfolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newbox)
                            .addComponent(heavybox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(agefield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ivagelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(submitdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitdetailsActionPerformed
        String company, info, city;
        double cost = 0, age = 0;
        boolean b = true;
        int catid = 0;
        company = mfgcmpfield.getText();
        if (company.trim().equals("")) {
            ivmnfclbl.setText("Invalid !");
            b = false;
        } else {
            ivmnfclbl.setText("");
        }
        try {
            cost = Double.parseDouble(pricefield.getText());
            ivpricelbl.setText("");
        } catch (NumberFormatException f) {
            ivpricelbl.setText("Invalid");
            b = false;
        }
        city = cityfield.getText();
        if (city.trim().equals("")) {
            ivcitylbl.setText("Invalid !");
            b = false;
        } else {
            ivcitylbl.setText("");
        }
        info = infoarea.getText();
        if (info.trim().equals("")) {
            ivinfolbl.setText("Invalid !");
            b = false;
        } else {
            ivinfolbl.setText("");
        }
        try {
            age = Double.parseDouble(agefield.getText());
            ivagelbl.setText("");
        } catch (NumberFormatException f) {
                ivagelbl.setText("Invalid ! [Decimals allowed]");
            b = false;
        }
        if (bi == null) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, " Photo of the item is not selected.");
            b = false;
        }
        if (categorylist.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Select a category !");
            b = false;
        } else {
            Category cat = (Category) categorylist.getSelectedItem();
            catid = cat.id;
        }
        if (b) {
            try {
                DBConnection dbc = new DBConnection();
                Connection con = dbc.getConnnection();
                String query = " insert into itemrecord (category, photo, price, isnew, age, mfgcomp, city, info, isheavy, ownerid, ispoor, status, delivered)"
                        + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                ByteArrayOutputStream baos = null;
                try {
                    baos = new ByteArrayOutputStream();
                    boolean write = ImageIO.write(bi, "png", baos);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "!!! Error \nProblem with the Image of item.");
                } finally {
                    try {
                        baos.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "!!! Error \nProblem with the Image of item.");
                    }
                }
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                int categoryid = 0;
                try {
                    preparedStmt.setInt(1, catid);
                    preparedStmt.setBlob(2, bais);
                    preparedStmt.setDouble(3, cost);
                    preparedStmt.setBoolean(4, newbox.isSelected());
                    preparedStmt.setDouble(5, age);
                    preparedStmt.setString(6, company);
                    preparedStmt.setString(7, city);
                    preparedStmt.setString(8, info);
                    preparedStmt.setBoolean(9, heavybox.isSelected());
                    preparedStmt.setInt(10, seller.id);
                    preparedStmt.setBoolean(11, false);
                    preparedStmt.setBoolean(12, false);
                    preparedStmt.setBoolean(13, false);
                    preparedStmt.execute();
                    Component frame = null;
                    JOptionPane.showMessageDialog(frame, " Item uploaded successfully.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                con.close();
                parentobj.setEnabled(true);
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        }
    }//GEN-LAST:event_submitdetailsActionPerformed

    private void newboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newboxActionPerformed
        if (newbox.isSelected() == true) {
            agefield.setEnabled(false);
            agefield.setText("0");
        } else {
            agefield.setEnabled(true);
        }
    }//GEN-LAST:event_newboxActionPerformed

    private void photobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photobuttonActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        fc.setDialogTitle("Choose a Picture to upload.");
        fc.setFileFilter(filter);
        int a = fc.showOpenDialog(this);
        if (a == JFileChooser.APPROVE_OPTION) {
            Component frame = null;
            try {
                bi = ImageIO.read(fc.getSelectedFile());
                bi = MainFrame.resizeImage(bi, 455, 367, bi.getType());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "!!! Error \nCould not transfrom it to a buffered image.");
            }
        }
    }//GEN-LAST:event_photobuttonActionPerformed

    private void categorylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorylistActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_categorylistActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agefield;
    private javax.swing.JComboBox<Category> categorylist;
    private javax.swing.JTextField cityfield;
    private javax.swing.JCheckBox heavybox;
    private javax.swing.JTextArea infoarea;
    private javax.swing.JLabel ivagelbl;
    private javax.swing.JLabel ivcitylbl;
    private javax.swing.JLabel ivinfolbl;
    private javax.swing.JLabel ivmnfclbl;
    private javax.swing.JLabel ivpricelbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mfgcmpfield;
    private javax.swing.JCheckBox newbox;
    private javax.swing.JButton photobutton;
    private javax.swing.JTextField pricefield;
    private javax.swing.JButton submitdetails;
    // End of variables declaration//GEN-END:variables
}
