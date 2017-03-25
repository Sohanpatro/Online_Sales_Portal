

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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegistrationFrame extends javax.swing.JFrame {

    transient BufferedImage bi = null;
    transient MainFrame objframe;

    public RegistrationFrame(MainFrame obj) {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");
        } catch (MalformedURLException ex) {
        }

        try {
            BufferedImage back = null;
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 578, 427, back.getType()))));
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
        objframe = obj;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent window) {
                obj.setEnabled(true);
            }
        });
        setTitle("ONLINE SALES PORTAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngp = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namefield = new javax.swing.JTextField();
        cityfield = new javax.swing.JTextField();
        telephonefield = new javax.swing.JTextField();
        emailidfield = new javax.swing.JTextField();
        imidbutton = new javax.swing.JButton();
        submitdetails = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        buyerradio = new javax.swing.JRadioButton();
        sellerradio = new javax.swing.JRadioButton();
        ivcitylbl = new javax.swing.JLabel();
        ivtelelbl = new javax.swing.JLabel();
        ivnamelbl = new javax.swing.JLabel();
        ivemaillbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Name         :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Telephone  :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("E-mail         :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("City            :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("IM_ID        :");

        imidbutton.setText("Browse");
        imidbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imidbuttonActionPerformed(evt);
            }
        });

        submitdetails.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        submitdetails.setText("Submit");
        submitdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitdetailsActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Register as  :");

        btngp.add(buyerradio);
        buyerradio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buyerradio.setText("Buyer");
        buyerradio.setActionCommand("Buyer");

        btngp.add(sellerradio);
        sellerradio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sellerradio.setText("Seller");
        sellerradio.setActionCommand("Seller");

        ivcitylbl.setForeground(new java.awt.Color(255, 0, 0));

        ivtelelbl.setForeground(new java.awt.Color(255, 0, 0));

        ivnamelbl.setForeground(new java.awt.Color(255, 0, 0));

        ivemaillbl.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(namefield, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                .addComponent(cityfield)
                                .addComponent(telephonefield)
                                .addComponent(emailidfield))
                            .addComponent(imidbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buyerradio)
                                .addGap(49, 49, 49)
                                .addComponent(sellerradio))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submitdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ivemaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ivcitylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ivnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ivtelelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ivnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(namefield)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ivcitylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cityfield)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(telephonefield)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                    .addComponent(ivtelelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailidfield)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(ivemaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imidbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyerradio)
                    .addComponent(sellerradio))
                .addGap(18, 18, 18)
                .addComponent(submitdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imidbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imidbuttonActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        fc.setDialogTitle("Choose a Picture to upload.");
        fc.setFileFilter(filter);
        int a = fc.showOpenDialog(this);
        if (a == JFileChooser.APPROVE_OPTION) {
            Component frame = null;
            try {
                bi = ImageIO.read(fc.getSelectedFile());
                bi = MainFrame.resizeImage(bi, 50, 50, bi.getType());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "!!! Error \nProblem loading the IM ID.");
            }
        }

    }//GEN-LAST:event_imidbuttonActionPerformed

    private void submitdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitdetailsActionPerformed
        String name, email, mobile, city;
        boolean b = true;
        name = namefield.getText();
        if (name.trim().equals("")) {
            ivnamelbl.setText("Invalid !");
            b = false;
        } else {
            ivnamelbl.setText("");
        }
        city = cityfield.getText();
        if (city.trim().equals("")) {
            ivcitylbl.setText("Invalid !");
            b = false;
        } else {
            ivcitylbl.setText("");
        }
        email = emailidfield.getText();
        if (email.trim().equals("")) {
            ivnamelbl.setText("Invalid !");
            b = false;
        } else {
            ivemaillbl.setText("");
        }
        mobile = telephonefield.getText();
        if (mobile.trim().equals("")) {
            ivtelelbl.setText("Invalid !");
            b = false;
        } else {
            ivtelelbl.setText("");
        }
        if (b) {
            Pattern mobilepattern = Pattern.compile("^[1-9][0-9]{9}");
            Matcher testA = mobilepattern.matcher(mobile);
            if (!testA.matches()) {
                ivtelelbl.setText("Invalid !");
                b = false;
            } else {
                ivtelelbl.setText("");
            }
        }
        String selection = null;
        if (btngp.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Select a customer type.");
            b = false;
        } else {
            selection = btngp.getSelection().getActionCommand();
        }
        String password = null;
        if (b) {
            Random rdm = new Random();
            password = Integer.toString(rdm.nextInt(9000000) + 1000000);
        }
        if (b && selection.equals("Buyer")) {
            try {
                DBConnection dbc = new DBConnection();
                Connection con = dbc.getConnnection();
                String query = " insert into buyerrecord (password, name, city, telephone, email,imid)"
                        + " values (?,?,?,?,?,?)";
                PreparedStatement preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, password);
                preparedStmt.setString(2, name);
                preparedStmt.setString(3, city);
                preparedStmt.setString(4, mobile);
                preparedStmt.setString(5, email);
                if (bi == null) {
                    preparedStmt.setNull(6, java.sql.Types.BLOB);
                } else {
                    ByteArrayOutputStream baos = null;
                    try {
                        baos = new ByteArrayOutputStream();
                        try {
                            ImageIO.write(bi, "png", baos);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Problem loading IM ID.");
                        }
                    } finally {
                        try {
                            baos.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Problem loading IM ID.");
                        }
                    }
                    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                    preparedStmt.setBlob(6, bais);
                }
                try {
                    preparedStmt.executeUpdate();
                    query = "select id from buyerrecord where email = ?";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, email);
                    ResultSet rs = preparedStmt.executeQuery();
                    rs.next();
                    int usernew = rs.getInt("id");
                    JOptionPane.showMessageDialog(null, " Registration Successful . \n The username is : buyer" + usernew + "\n The password id : " + password);
                    objframe.setEnabled(true);
                    this.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, " A buyer with the same email already exists.\n Updation failed.");
                }
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        } else if (b && selection.equals("Seller")) {
            try {
                DBConnection dbc = new DBConnection();
                Connection con = dbc.getConnnection();
                String query = " insert into sellerrecord (password, name, city, telephone, email,imid)"
                        + " values (?,?,?,?,?,?)";
                PreparedStatement preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, password);
                preparedStmt.setString(2, name);
                preparedStmt.setString(3, city);
                preparedStmt.setString(4, mobile);
                preparedStmt.setString(5, email);
                if (bi == null) {
                    preparedStmt.setNull(6, java.sql.Types.BLOB);
                } else {
                    ByteArrayOutputStream baos = null;
                    try {
                        baos = new ByteArrayOutputStream();
                        try {
                            ImageIO.write(bi, "png", baos);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Problem loading IM ID.");
                        }
                    } finally {
                        try {
                            baos.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Problem loading IM ID.");
                        }
                    }
                    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                    preparedStmt.setBlob(6, bais);
                }
                try {
                    preparedStmt.executeUpdate();
                    query = "select id from sellerrecord where email = ?";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, email);
                    ResultSet rs = preparedStmt.executeQuery();
                    rs.next();
                    int usernew = rs.getInt("id");
                    JOptionPane.showMessageDialog(null, " Registration Successful . \n The username is : seller" + usernew + "\n The password id : " + password);
                    objframe.setEnabled(true);
                    this.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, " A seller with the same email already exists.\n Updation failed.");
                }
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        }
    }//GEN-LAST:event_submitdetailsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngp;
    private javax.swing.JRadioButton buyerradio;
    private javax.swing.JTextField cityfield;
    private javax.swing.JTextField emailidfield;
    private javax.swing.JButton imidbutton;
    private javax.swing.JLabel ivcitylbl;
    private javax.swing.JLabel ivemaillbl;
    private javax.swing.JLabel ivnamelbl;
    private javax.swing.JLabel ivtelelbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField namefield;
    private javax.swing.JRadioButton sellerradio;
    private javax.swing.JButton submitdetails;
    private javax.swing.JTextField telephonefield;
    // End of variables declaration//GEN-END:variables
}
