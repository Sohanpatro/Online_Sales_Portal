

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.scripts.JO;

public class BuyerFrame extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel(new Object[][]{},
            new String[]{
                "ID", "Photo", "Owner", "Price",}) {
        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 1:
                    return ImageIcon.class;
                default:
                    return String.class;
            }
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    transient Vector<Category> categories = new Vector<>();
    Buyer buyer;
    transient MainFrame parentobj;

    public BuyerFrame(Buyer information, MainFrame parentframe) throws SQLException {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");
        } catch (MalformedURLException ex) {
        }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 737, 432, back.getType()))));
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
            java.util.logging.Logger.getLogger(BuyerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
        DBConnection dbc = new DBConnection();
        Connection con = null;
        con = dbc.getConnnection();
        String query = "select * from categoryrecord";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = con.prepareStatement(query);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();

            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("category")));
            }
            categorylist.setCellRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> categorylist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    Component renderer = super.getListCellRendererComponent(categorylist, value, index, isSelected, cellHasFocus);
                    if (renderer instanceof JLabel && value instanceof Category) {
                        ((JLabel) renderer).setText(((Category) value).category);
                    }
                    return renderer;
                }
            });
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
        buyer = information;
        parentobj = parentframe;
        setTitle("ONLINE SALES PORTAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        categorylist = new JList(categories);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        editprofilebutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        contactmanagerbutton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemtable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        categorylist.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        categorylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categorylistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(categorylist);

        jButton1.setText("Item Queue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Messages");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Log Out");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        editprofilebutton.setText("Edit Profile");
        editprofilebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editprofilebuttonActionPerformed(evt);
            }
        });

        jLabel2.setText("Search Results / Items in the selected Category :");

        contactmanagerbutton.setText("Contact Manager");
        contactmanagerbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactmanagerbuttonActionPerformed(evt);
            }
        });

        jLabel3.setText("Search a Category :");

        itemtable.setModel(dtm);
        itemtable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemtable.setRowHeight(60);
        itemtable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemtableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(itemtable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(editprofilebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(contactmanagerbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(266, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contactmanagerbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editprofilebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editprofilebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editprofilebuttonActionPerformed
        this.setEnabled(false);
        EditDetailsFrame edf = new EditDetailsFrame(buyer, true, this);
    }//GEN-LAST:event_editprofilebuttonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void contactmanagerbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactmanagerbuttonActionPerformed
        EmailFrame ef = new EmailFrame(buyer.id, 0, -1, -1, this);
        this.setEnabled(false);
    }//GEN-LAST:event_contactmanagerbuttonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "select * from messagerecord where receiverid = ? AND receivertype = ?";
            PreparedStatement preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, buyer.id);
            preparedStmt.setInt(2, 0);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                MessageFrame msf = new MessageFrame(this, rs);
                this.setEnabled(false);
            } else {
                Component frame = null;
                JOptionPane.showMessageDialog(frame, " No messages to view ");
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void categorylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categorylistMouseClicked
        Object ob = (Object) categorylist.getSelectedValue();
        Category cat = (Category) ob;
        try {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "";
            query = "select a.id, a.photo, a.ownerid, a.price from itemrecord as a where not exists(select * from requestrecord as b where a.id = b.itemid and ? = b.buyerid) and a.category = ? and a.status = ?";
            PreparedStatement preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, buyer.id);
            preparedStmt.setInt(2, cat.id);
            preparedStmt.setBoolean(3, false);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();
            if (!rs.next()) {
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "No items are found for the choosen category");
            } else {
                int rowcount = dtm.getRowCount();
                while (rowcount > 0) {
                    dtm.removeRow(rowcount - 1);
                    rowcount--;
                }
                rs.beforeFirst();
                BufferedImage buff = null;
                while (rs.next()) {
                    byte[] img = rs.getBytes("photo");
                    try {
                        buff = ImageIO.read(new ByteArrayInputStream(img));
                        buff = MainFrame.resizeImage(buff, 50, 50, buff.getType());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Problem Loading the image of item :" + rs.getInt("id"));
                    }
                    ImageIcon image = new ImageIcon(buff);
                    dtm.addRow(new Object[]{rs.getInt("id"), image, "Seller" + rs.getInt("ownerid"), rs.getDouble("price")});

                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
    }//GEN-LAST:event_categorylistMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ItemQueueFrame iqf = new ItemQueueFrame(buyer, this);
            this.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void itemtableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemtableMousePressed
        if (evt.getClickCount() == 2) {
            int ri = itemtable.getSelectedRow();
            int nid = (int) (itemtable.getValueAt(ri, 0));
            try {
                ItemFrame itfr = new ItemFrame(nid, buyer, 0, this);
                dtm.removeRow(ri);
                this.setEnabled(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        }
    }//GEN-LAST:event_itemtableMousePressed

    /* Create and display the form */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> categorylist;
    private javax.swing.JButton contactmanagerbutton;
    private javax.swing.JButton editprofilebutton;
    private javax.swing.JTable itemtable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
