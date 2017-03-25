

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MessageFrame extends javax.swing.JFrame {

    transient JFrame parentobj;
    transient String selectedmessage = "";
    transient Vector<MessageClass> messages;
    DefaultTableModel dtm = new javax.swing.table.DefaultTableModel(new Object[][]{},
            new String[]{"ID", "Sender ID", "Subject"}) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public MessageFrame(JFrame parentframe, ResultSet rs) throws SQLException {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");        } catch (MalformedURLException ex) {
        }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 708, 487, back.getType()))));
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
            java.util.logging.Logger.getLogger(MessageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        while (rs.next()) {
            int senderType = rs.getInt("sendertype");
            String senderId = "";
            if (senderType == -1) {
                senderId = "manager";
            } else if (senderType == 0) {
                senderId = "buyer" + rs.getInt("senderid");
            } else {
                senderId = "seller" + rs.getInt("senderid");
            }
            dtm.addRow(new Object[]{rs.getInt("id"), senderId, rs.getString("subject")});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Reply");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Double-Click to view entire message :");

        messageTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        messageTable.setModel(dtm);
        messageTable.setRowHeight(30);
        messageTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                messageTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(messageTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ri = messageTable.getSelectedRow();
        if (ri != -1) {
            try {
                DBConnection dbc = new DBConnection();
                Connection con = null;
                con = dbc.getConnnection();
                String query = "select * from messagerecord where id = ?";
                java.sql.PreparedStatement preparedStmt = null;
                int messid = (int) messageTable.getValueAt(ri, 0);
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, messid);
                ResultSet rs = null;
                rs = preparedStmt.executeQuery();
                rs.next();
                EmailFrame ef = new EmailFrame(rs.getInt("receiverid"), rs.getInt("receivertype"), rs.getInt("senderid"), rs.getInt("sendertype"), this);
                this.setEnabled(false);
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        } else{
                JOptionPane.showMessageDialog(null, "Select a Message !");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void messageTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageTableMousePressed
        if (evt.getClickCount() == 2) {
            try {
                DBConnection dbc = new DBConnection();
                Connection con = null;
                con = dbc.getConnnection();
                String query = "select * from messagerecord where id = ?";
                java.sql.PreparedStatement preparedStmt = null;
                int ri = messageTable.getSelectedRow();
                int messid = (int) messageTable.getValueAt(ri, 0);
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, messid);
                ResultSet rs = null;
                rs = preparedStmt.executeQuery();
                rs.next();
                EmailFrame ef = new EmailFrame(rs.getInt("receiverid"), rs.getInt("receivertype"), rs.getInt("senderid"), rs.getInt("sendertype"), this);
                ef.subjectfield.setText(rs.getString("subject"));
                ef.messagearea.setText(rs.getString("message"));
                ef.sendbutton.setVisible(false);
                this.setEnabled(false);
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_messageTableMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable messageTable;
    // End of variables declaration//GEN-END:variables
}
