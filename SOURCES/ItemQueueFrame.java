

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ItemQueueFrame extends javax.swing.JFrame {

    transient Buyer buyer;
    transient JFrame parentobj;
    DefaultTableModel dtm = new javax.swing.table.DefaultTableModel(new Object[][]{},
            new String[]{"ID", "Photo", "Owner", "Price"}) {
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

    public ItemQueueFrame(Buyer buyermtp, JFrame parentframe) throws SQLException {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");        } catch (MalformedURLException ex) {
        }

        try {
            BufferedImage back = null;
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 769, 476, back.getType()))));
        } catch (IOException ex) {
        }
        buyer = buyermtp;
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
        receivedbox.setEnabled(false);
        returnbox.setEnabled(false);
        setTitle("ONLINE SALES PORTAL");
        try {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "select * from requestrecord where buyerid = ?";
            PreparedStatement preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, buyer.id);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();
            while (rs.next()) {
                query = "select * from itemrecord where id = ?";
                preparedStmt = null;
                try {
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setInt(1, rs.getInt("itemid"));
                } catch (SQLException ex) {
                }
                ResultSet rs1 = null;
                rs1 = preparedStmt.executeQuery();
                rs1.last();
                double itemprice = 0;
                BufferedImage buff = null;
                byte[] img = rs1.getBytes("photo");
                try {
                    buff = ImageIO.read(new ByteArrayInputStream(img));
                    buff = MainFrame.resizeImage(buff, 50, 50, buff.getType());
                } catch (IOException ex) {
                    Logger.getLogger(BuyerFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ImageIcon image = new ImageIcon(buff);
                if (rs1.getBoolean("status") && rs1.getBoolean("delivered")) {
                    dtm.addRow(new Object[]{rs.getInt("itemid"), image, "seller" + rs1.getInt("ownerid"), itemprice + "[DELIVERED]"});
                } else if (rs1.getBoolean("status") && !rs1.getBoolean("delivered")) {
                    dtm.addRow(new Object[]{rs.getInt("itemid"), image, "seller" + rs1.getInt("ownerid"), itemprice + "[BILL PAID]"});
                } else if (rs.getBoolean("status") == true) {
                    itemprice = rs.getDouble("price");
                    dtm.addRow(new Object[]{rs.getInt("itemid"), image, "seller" + rs1.getInt("ownerid"), itemprice + " [ACCEPTED]"});
                } else {
                    itemprice = rs1.getDouble("price");
                    dtm.addRow(new Object[]{rs.getInt("itemid"), image, "seller" + rs1.getInt("ownerid"), Double.toString(itemprice)});
                }
            }
            con.close();
        } catch (SQLException ex) {
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

        jScrollPane2 = new javax.swing.JScrollPane();
        itemtable = new javax.swing.JTable();
        receivedbox = new javax.swing.JCheckBox();
        returnbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        itemtable.setModel(dtm);
        itemtable.setRowHeight(60);
        itemtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemtableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(itemtable);

        receivedbox.setText("Item Recieved");
        receivedbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivedboxActionPerformed(evt);
            }
        });

        returnbox.setText("Return Item");
        returnbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(632, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnbox)
                    .addComponent(receivedbox))
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(160, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(receivedbox)
                .addGap(32, 32, 32)
                .addComponent(returnbox)
                .addContainerGap(282, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemtableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemtableMousePressed
        int ri = itemtable.getSelectedRow();
        if (ri != -1) {
            int nid = (int) (itemtable.getValueAt(ri, 0));
            String test = (String) itemtable.getValueAt(ri, 3);
            if (evt.getClickCount() == 2) {
                if (test.contains("[BILL PAID]") || test.contains("[DELIVERED]")) {
                    try {
                        ItemFrame itfr = new ItemFrame(nid, buyer, 2, this);
                        this.setEnabled(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(ItemQueueFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        ItemFrame itfr = new ItemFrame(nid, buyer, 1, this);
                        dtm.removeRow(ri);
                        this.setEnabled(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(ItemQueueFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (evt.getClickCount() == 1) {
                if (test.contains("[BILL PAID]")) {
                    receivedbox.setEnabled(true);
                } else if (test.contains("[DELIVERED]")) {
                    returnbox.setEnabled(true);
                } else {
                    receivedbox.setEnabled(false);
                    returnbox.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_itemtableMousePressed

    private void receivedboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedboxActionPerformed
        // TODO add your handling code here:
        if (receivedbox.isSelected()) {
            int ri = itemtable.getSelectedRow();
            int nid = (int) itemtable.getValueAt(ri, 0);
            try {
                DBConnection dbc = new DBConnection();
                Connection con = null;
                con = dbc.getConnnection();
                String query = "update itemrecord set delivered = ?, deliverydate = ? where id = ?";
                java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                PreparedStatement preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setBoolean(1, true);
                preparedStmt.setInt(3, nid);
                preparedStmt.setDate(2, today);
                preparedStmt.executeUpdate();
                dtm.setValueAt("[DELIVERED]", ri, 3);
                receivedbox.setEnabled(false);
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        }
    }//GEN-LAST:event_receivedboxActionPerformed

    private void returnboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnboxActionPerformed
        // TODO add your handling code here:
        if (returnbox.isSelected()) {
            int ri = itemtable.getSelectedRow();
            int nid = (int) itemtable.getValueAt(ri, 0);
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "select deliverydate from itemrecord where id = ?";
            java.sql.Date thisday = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            PreparedStatement preparedStmt = null;
            try {
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, nid);
            } catch (SQLException ex) {
            }
            ResultSet rs = null;
            try {
                rs = preparedStmt.executeQuery();
                rs.next();
                java.sql.Date thatday = rs.getDate("deliverydate");
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, -15);
                java.sql.Date daylimit = new java.sql.Date(cal.getTime().getTime());
                if (thatday.compareTo(daylimit) > 0) {
                    query = "update itemrecord set delivered = ?, deliverydate = ?, status = ? where id = ?";
                    preparedStmt = null;
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setBoolean(1, false);
                    preparedStmt.setBoolean(3, false);
                    preparedStmt.setInt(4, nid);
                    preparedStmt.setNull(2, java.sql.Types.DATE);
                    preparedStmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Item returned. \n Paid Amount will be refunded to your account");
                    dtm.removeRow(ri);
                    receivedbox.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Item cannot be returned as it has been more than 15 days from reception");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        }
    }//GEN-LAST:event_returnboxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable itemtable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox receivedbox;
    private javax.swing.JCheckBox returnbox;
    // End of variables declaration//GEN-END:variables
}
