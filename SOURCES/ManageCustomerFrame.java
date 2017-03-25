

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageCustomerFrame extends javax.swing.JFrame {

    transient Vector<Buyer> buyers = new Vector<Buyer>();
    transient Vector<Seller> sellers = new Vector<Seller>();
    DefaultTableModel dtm = new javax.swing.table.DefaultTableModel(new Object[][]{},
            new String[]{"Name", "email", "telephone", "ID"});
    DefaultTableModel dtm2 = new javax.swing.table.DefaultTableModel(new Object[][]{},
            new String[]{"Name", "email", "telephone", "ID"});
    JFrame parentobj;

    public ManageCustomerFrame(JFrame parentframe) throws SQLException {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");
        } catch (MalformedURLException ex) {
        }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 669, 477, back.getType()))));
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
        parentobj = parentframe;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent window) {
                parentobj.setEnabled(true);
            }
        });
        setTitle("ONLINE SALES PORTAL");
        try {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "select * from buyerrecord";
            PreparedStatement preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();

            while (rs.next()) {
                buyers.add(new Buyer(rs.getInt("id"), rs.getString("name"), rs.getString("city"), rs.getString("telephone"), rs.getString("email"), rs.getString("password"), null));
            }
            String query2 = "select * from sellerrecord";
            PreparedStatement preparedStmt2 = null;
            preparedStmt2 = con.prepareStatement(query2);
            ResultSet rs2 = null;
            rs2 = preparedStmt2.executeQuery();

            while (rs2.next()) {
                sellers.add(new Seller(rs2.getInt("id"), rs2.getString("name"), rs2.getString("city"), rs2.getString("telephone"), rs2.getString("email"), rs2.getString("password"), null));
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
        for (int i = 0; i < buyers.size(); i++) {
            dtm.addRow(new Object[]{buyers.get(i).name, buyers.get(i).email, buyers.get(i).telephone, "buyer" + buyers.get(i).id});
        }
        for (int i = 0; i < sellers.size(); i++) {
            dtm2.addRow(new Object[]{sellers.get(i).name, sellers.get(i).email, sellers.get(i).telephone, "seller" + sellers.get(i).id});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        removebtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        resetbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        buyertable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        sellertable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ONLINE SALES PORTAL");
        setResizable(false);

        removebtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        removebtn.setText("Remove Customer");
        removebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Buyers List :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Sellers List :");

        resetbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        resetbtn.setText("Reset Password");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });

        buyertable.setModel(dtm);
        buyertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buyertableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(buyertable);

        sellertable.setModel(dtm2);
        sellertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellertableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(sellertable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resetbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addGap(68, 68, 68)
                        .addComponent(removebtn)
                        .addGap(48, 48, 48)
                        .addComponent(resetbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2)
                        .addContainerGap(172, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buyertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyertableMouseClicked
        sellertable.clearSelection();
    }//GEN-LAST:event_buyertableMouseClicked

    private void sellertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellertableMouseClicked
        buyertable.clearSelection();
    }//GEN-LAST:event_sellertableMouseClicked

    private void removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtnActionPerformed
        if (buyertable.getSelectedRow() != -1) {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "delete from buyerrecord where id = ?";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = con.prepareStatement(query);
                int ri = buyertable.getSelectedRow();
                int nid = (int) (buyertable.getValueAt(ri, 3));
                preparedStmt.setInt(1, nid);
                preparedStmt.executeUpdate();
                dtm.removeRow(buyertable.getSelectedRow());
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        } else if (sellertable.getSelectedRow() != -1) {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "delete from sellerrecord where id = ?";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = con.prepareStatement(query);

                int ri = sellertable.getSelectedRow();
                int nid = (int) (sellertable.getValueAt(ri, 3));
                preparedStmt.setInt(1, nid);
                preparedStmt.executeUpdate();
                dtm.removeRow(sellertable.getSelectedRow());
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a Customer !");
        }
    }//GEN-LAST:event_removebtnActionPerformed

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        if (buyertable.getSelectedRow() != -1) {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "update buyerrecord SET password = ? where id = ?";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = con.prepareStatement(query);
                int ri = buyertable.getSelectedRow();
                int nid = (int) (buyertable.getValueAt(ri, 3));
                Random rand = new Random();
                int randnum = rand.nextInt(9000000) + 1000000;
                String newpassword = Integer.toString(randnum);
                preparedStmt.setString(1, newpassword);
                preparedStmt.setInt(2, nid);
                preparedStmt.executeUpdate();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        } else if (sellertable.getSelectedRow() != -1) {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "update sellerrecord SET password = ? where id = ?";
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = con.prepareStatement(query);
                int ri = sellertable.getSelectedRow();
                int nid = (int) (sellertable.getValueAt(ri, 3));
                Random rand = new Random();
                int randnum = rand.nextInt(9000000) + 1000000;
                String newpassword = Integer.toString(randnum);
                preparedStmt.setString(1, newpassword);
                preparedStmt.setInt(2, nid);
                preparedStmt.executeUpdate();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a Customer !");
        }
    }//GEN-LAST:event_resetbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable buyertable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removebtn;
    private javax.swing.JButton resetbtn;
    private javax.swing.JTable sellertable;
    // End of variables declaration//GEN-END:variables

}
