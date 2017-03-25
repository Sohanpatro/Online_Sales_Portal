

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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReviewItemFrame extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel(new Object[][]{},
            new String[]{
                "Photo", "ID", "Price",}) {
        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 0:
                    return ImageIcon.class;
                default:
                    return String.class;
            }
        }

    };
    JFrame parentobj;

    public ReviewItemFrame(Category incat, JFrame parentframe) throws SQLException {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");        } catch (MalformedURLException ex) {
        }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 700, 387, back.getType()))));
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
            String query = "select * from itemrecord where category = ? and ispoor = ?";
            PreparedStatement preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, incat.id);
            preparedStmt.setInt(2, 0);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();
            BufferedImage buff = null;
            while (rs.next()) {
                byte[] img = rs.getBytes("photo");
                try {
                    buff = ImageIO.read(new ByteArrayInputStream(img));
                    buff = MainFrame.resizeImage(buff, 50, 50, buff.getType());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Problem loading image of the item.");
                }
                ImageIcon image = new ImageIcon(buff);
                dtm.addRow(new Object[]{image, rs.getInt("id"), rs.getDouble("price")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngp = new javax.swing.ButtonGroup();
        viewitembtn = new javax.swing.JButton();
        poorrdbtn = new javax.swing.JRadioButton();
        goodrdbtn = new javax.swing.JRadioButton();
        submitbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemtable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        viewitembtn.setText("View Item");
        viewitembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewitembtnActionPerformed(evt);
            }
        });

        btngp.add(poorrdbtn);
        poorrdbtn.setText("Poor");

        btngp.add(goodrdbtn);
        goodrdbtn.setText("Good");

        submitbtn.setText("Submit");
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtnActionPerformed(evt);
            }
        });

        itemtable.setModel(dtm);
        itemtable.setRowHeight(60);
        jScrollPane1.setViewportView(itemtable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(viewitembtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(poorrdbtn)
                                .addComponent(goodrdbtn))
                            .addGap(75, 75, 75)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(viewitembtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(poorrdbtn)
                        .addGap(18, 18, 18)
                        .addComponent(goodrdbtn)
                        .addGap(67, 67, 67)
                        .addComponent(submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbtnActionPerformed
        int ri = itemtable.getSelectedRow();
        if (ri != -1) {
            if (poorrdbtn.isSelected()) {
                try {
                    DBConnection dbc = new DBConnection();
                    Connection con = null;
                    con = dbc.getConnnection();
                    String query = "delete from itemrecord where id = ?";
                    PreparedStatement preparedStmt = null;
                    preparedStmt = con.prepareStatement(query);

                    int ci = itemtable.getSelectedColumn();
                    int nid = (int) (itemtable.getValueAt(ri, ci));
                    preparedStmt.setInt(1, nid);
                    preparedStmt.executeUpdate();
                    dtm.removeRow(itemtable.getSelectedRow());
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
                }
            } else if (goodrdbtn.isSelected()) {
                try {
                    DBConnection dbc = new DBConnection();
                    Connection con = null;
                    con = dbc.getConnnection();
                    String query = "update itemrecord SET ispoor = ? where id = ?";
                    PreparedStatement preparedStmt = null;
                    preparedStmt = con.prepareStatement(query);
                    int nid = (int) itemtable.getValueAt(ri, 1);
                    preparedStmt.setBoolean(1, true);
                    preparedStmt.setInt(2, nid);
                    preparedStmt.executeUpdate();
                    dtm.removeRow(itemtable.getSelectedRow());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select an Option !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select an Item !");
        }
    }//GEN-LAST:event_submitbtnActionPerformed

    private void viewitembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewitembtnActionPerformed
        int ri = itemtable.getSelectedRow();
        if (ri != -1) {
            int iid = (int) (itemtable.getValueAt(ri, 1));
            try {
                ManagerItemFrame mif = new ManagerItemFrame(iid, this);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select an Item !");
        }
    }//GEN-LAST:event_viewitembtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngp;
    private javax.swing.JRadioButton goodrdbtn;
    private javax.swing.JTable itemtable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton poorrdbtn;
    private javax.swing.JButton submitbtn;
    private javax.swing.JButton viewitembtn;
    // End of variables declaration//GEN-END:variables
}
