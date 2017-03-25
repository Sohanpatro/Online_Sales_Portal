

import java.awt.Component;
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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ChangeCategoryItemFrame extends javax.swing.JFrame {

    JFrame parentobj;
    DefaultTableModel dtm = new DefaultTableModel(new Object[][]{},
            new String[]{
                "Photo", "CategoryID", "ItemID",}) {
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

    public ChangeCategoryItemFrame(JFrame parentframe) throws SQLException {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");        } catch (MalformedURLException ex) {
        }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 617, 347, back.getType()))));
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
            java.util.logging.Logger.getLogger(ChangeCategoryItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeCategoryItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeCategoryItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeCategoryItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
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
            String query = "select * from itemrecord";
            PreparedStatement preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();
            BufferedImage buff = null;
            while (rs.next()) {
                byte[] img = rs.getBytes("photo");
                try {
                    buff = ImageIO.read(new ByteArrayInputStream(img));
                    buff = MainFrame.resizeImage(buff, 50, 50, buff.getType());
                } catch (IOException ex) {
                    Logger.getLogger(BuyerFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ImageIcon image = new ImageIcon(buff);
                dtm.addRow(new Object[]{image, rs.getString("category"), rs.getInt("id")});
            }
            query = "select * from categoryrecord";
            preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            rs = null;
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

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        itemtable = new javax.swing.JTable();
        categorylist = new javax.swing.JComboBox<>();
        changecatbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        itemtable.setModel(dtm);
        itemtable.setRowHeight(60);
        jScrollPane1.setViewportView(itemtable);

        changecatbtn.setText("Change Category");
        changecatbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changecatbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changecatbtn)
                    .addComponent(categorylist, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(changecatbtn)
                .addGap(36, 36, 36)
                .addComponent(categorylist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changecatbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changecatbtnActionPerformed

        int ri = itemtable.getSelectedRow();
        if (ri != -1) {
            if (categorylist.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Select a category !");
            } else {
                try {
                    DBConnection dbc = new DBConnection();
                    Connection con = null;
                    con = dbc.getConnnection();
                    String query = "update itemrecord SET category = ? where id = ?";
                    PreparedStatement preparedStmt = null;
                    preparedStmt = con.prepareStatement(query);
                    int ci = itemtable.getSelectedColumn();
                    int nid = (int) (itemtable.getValueAt(ri, 2));
                    Object ob = categorylist.getSelectedItem();
                    Category cat = (Category) ob;
                    preparedStmt.setInt(1, cat.id);
                    preparedStmt.setInt(2, nid);
                    preparedStmt.executeUpdate();
                    itemtable.setValueAt(cat.category, ri, 2);
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select an Item!");
        }
    }//GEN-LAST:event_changecatbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Category> categorylist;
    private javax.swing.JButton changecatbtn;
    private javax.swing.JTable itemtable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
