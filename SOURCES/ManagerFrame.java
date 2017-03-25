

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ManagerFrame extends javax.swing.JFrame {

    transient Manager manager;

    public ManagerFrame(Manager managerinfo) throws SQLException {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");
        } catch (MalformedURLException ex) {
        }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 715, 461, back.getType()))));
        } catch (IOException ex) {
        }
        initComponents();

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
                categorylist.addItem(new Category(rs.getInt("id"), rs.getString("category")));
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
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
        manager = managerinfo;
        setTitle("ONLINE SALES PORTAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reviewitem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        categorylist = new JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        categorytf = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        reviewitem.setText("Review Items");
        reviewitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewitemActionPerformed(evt);
            }
        });

        jButton1.setText("Perform Audit");
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

        jLabel1.setText("Categories to review Items : ");

        jButton4.setText("Remove selected Category");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Add Category");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Manage Customer");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Log Out");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Edit Profile");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Manage Category of an Item");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categorylist, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(categorytf)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(96, 96, 96)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(reviewitem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categorylist, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reviewitem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(categorytf)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (categorylist.getSelectedIndex() != -1) {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            try {
                String query = "select id from itemrecord where category = ?";
                int catid = ((Category) categorylist.getSelectedItem()).id;
                PreparedStatement preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, catid);
                ResultSet rs = preparedStmt.executeQuery();
                if (!rs.next()) {
                    query = "delete from categoryrecord where id = ?";
                    preparedStmt = null;
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, catid);
                    preparedStmt.execute();
                    categorylist.removeItem(categorylist.getSelectedItem());
                } else {
                    JOptionPane.showMessageDialog(null, "Items with the selected category exist in the portal.\nChoose appropriate categories for those items.\nDeletion unsuccesful.");
                }
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem in deleting the category.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a category !");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DBConnection dbc = new DBConnection();
        Connection con = null;
        con = dbc.getConnnection();
        String query = "insert into categoryrecord (category) VALUES (?)";
        PreparedStatement preparedStmt = null;
        if (!(categorytf.getText() == null || categorytf.getText().trim().equals(""))) {
            try {
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, categorytf.getText());
                try {
                    preparedStmt.executeUpdate();
                    query = "select * from categoryrecord where category = ?";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, categorytf.getText());
                    ResultSet rs = preparedStmt.executeQuery();
                    rs.next();
                    categorylist.addItem(new Category(rs.getInt("id"), rs.getString("category")));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "A category with the same name already exists.\nAddition unsuccesful.");
                }
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Same category is not allowed twice.\nProblem with Database Connection.\n Inconvinience is regreted.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "please enter a category");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            ManageCustomerFrame manageCustomerFrame = new ManageCustomerFrame(this);
            this.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void reviewitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewitemActionPerformed
        if (categorylist.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Select a category !");
        } else {
            try {
                ReviewItemFrame reviewItemFrame = new ReviewItemFrame((Category) categorylist.getSelectedItem(), this);
                this.setEnabled(false);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        }
    }//GEN-LAST:event_reviewitemActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            ChangeCategoryItemFrame fr = new ChangeCategoryItemFrame(this);
            this.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        EditManagerFrame fr = new EditManagerFrame(this);
        this.setEnabled(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        DBConnection dbc = new DBConnection();
        Connection con = null;
        con = dbc.getConnnection();
        String query = "select * from messagerecord where receiverid = ? AND receivertype = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, -1);
            preparedStmt.setInt(2, -1);
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
            Logger.getLogger(BuyerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DBConnection dbc = new DBConnection();
        Connection con = null;
        con = dbc.getConnnection();
        String query = "select status,delivered from itemrecord ";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = con.prepareStatement(query);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();
            int sold = 0, unsold = 0;
            int bought = 0;
            while (rs.next()) {
                if (rs.getBoolean("status")) {
                    sold++;
                    if (rs.getBoolean("delivered")) {
                        bought++;
                    }
                } else {
                    unsold++;
                }
            }
            JOptionPane.showMessageDialog(null, "NUMBER OF ITEMS SOLD : " + sold + ".\n NUMBER OF ITEMS BOUGHT : " + bought + ".\nNUMBER OF ITEMS NOT YET SOLD : " + unsold);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(BuyerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Category> categorylist;
    private javax.swing.JTextField categorytf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reviewitem;
    // End of variables declaration//GEN-END:variables
}
