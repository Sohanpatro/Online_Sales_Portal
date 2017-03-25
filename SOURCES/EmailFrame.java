

import java.awt.Component;
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EmailFrame extends javax.swing.JFrame {

    transient int senderid, receiverid, sendertype, receivertype;
    transient JFrame parentobj;

    public EmailFrame(int sender, int senderindi, int receiver, int receiverindi, JFrame parent) {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");
        } catch (MalformedURLException ex) {
        }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 603, 437, back.getType()))));
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
            java.util.logging.Logger.getLogger(EmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
        parentobj = parent;
        senderid = sender;
        receiverid = receiver;
        sendertype = senderindi;
        receivertype = receiverindi;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent window) {
                parentobj.setEnabled(true);
            }
        });
        try {
            DBConnection dbc = new DBConnection();
            Connection con = dbc.getConnnection();
            String to = "";
            String from = "";
            PreparedStatement preparedStmt = null;
            String senderquery = null;
            String receiverquery = null;
            if (sendertype == -1) {
                senderquery = "select email from manager";
                preparedStmt = con.prepareStatement(senderquery);
            } else if (sendertype == 0) {
                senderquery = "select email from buyerrecord where id = ?";
                preparedStmt = con.prepareStatement(senderquery);
                preparedStmt.setInt(1, senderid);
            } else {
                senderquery = "select email from sellerrecord where id = ?";
                preparedStmt = con.prepareStatement(senderquery);
                preparedStmt.setInt(1, senderid);
            }
            ResultSet rs1 = null;
            rs1 = preparedStmt.executeQuery();
            if (receivertype == -1) {
                senderquery = "select email from manager";
                preparedStmt = con.prepareStatement(senderquery);
            } else if (receivertype == 0) {
                senderquery = "select email from buyerrecord where id = ?";
                preparedStmt = con.prepareStatement(senderquery);
                preparedStmt.setInt(1, receiverid);
            } else {
                senderquery = "select email from sellerrecord where id = ?";
                preparedStmt = con.prepareStatement(senderquery);
                preparedStmt.setInt(1, receiverid);
            }
            ResultSet rs2 = null;
            rs2 = preparedStmt.executeQuery();
            while (rs1.next() && rs2.next()) {
                from = rs1.getString("email");
                to = rs2.getString("email");
                senderfield.setText(from);
                receiverfield.setText(to);
            }
            con.close();
            parentobj.setEnabled(true);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
        setTitle("ONLINE SALES PORTAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        senderfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        receiverfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        subjectfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagearea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        sendbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Sender :");

        senderfield.setEnabled(false);

        jLabel2.setText("Receiver :");

        receiverfield.setEnabled(false);

        jLabel3.setText("Subject  :");

        messagearea.setColumns(20);
        messagearea.setRows(5);
        jScrollPane1.setViewportView(messagearea);

        jLabel4.setText("Message :");

        sendbutton.setText("Send");
        sendbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(senderfield, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subjectfield, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(receiverfield, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(sendbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(senderfield, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(receiverfield, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendbuttonActionPerformed
        String subject = "";
        subject = subjectfield.getText();
        boolean b = true;
        if (subject.trim().equals("")) {
            b = false;
            Component frame = null;
            JOptionPane.showMessageDialog(frame, " Subject field cannot be empty.");
        }
        String messagetext = "";
        messagetext = messagearea.getText();
        if (messagetext.trim().equals("")) {
            b = false;
            Component frame = null;
            JOptionPane.showMessageDialog(frame, " Message cannot be empty.");
        }
        if (b) {
            try {
                DBConnection dbc = new DBConnection();
                Connection con = dbc.getConnnection();
                String query = " insert into messagerecord (senderid, receiverid, subject, message, sendertype, receivertype,status)"
                        + " values (?,?,?,?,?,?,?)";
                PreparedStatement preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setInt(1, senderid);
                preparedStmt.setInt(2, receiverid);
                preparedStmt.setString(3, subject);
                preparedStmt.setString(4, messagetext);
                preparedStmt.setInt(5, sendertype);
                preparedStmt.setInt(6, receivertype);
                preparedStmt.setBoolean(7, false);
                preparedStmt.execute();
                con.close();
                JOptionPane.showMessageDialog(null, "Message Succesfully sent.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        }
    }//GEN-LAST:event_sendbuttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea messagearea;
    private javax.swing.JTextField receiverfield;
    public javax.swing.JButton sendbutton;
    private javax.swing.JTextField senderfield;
    public javax.swing.JTextField subjectfield;
    // End of variables declaration//GEN-END:variables
}
