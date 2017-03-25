

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
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EditDetailsFrame extends javax.swing.JFrame {

    transient BufferedImage bi = null;
    Customer customer;
    transient boolean isbuyer;
    transient JFrame parentobj;

    public EditDetailsFrame(Customer cust, boolean b, JFrame parentframe) {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");        } catch (MalformedURLException ex) {
        }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 577, 501, back.getType()))));
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
            java.util.logging.Logger.getLogger(EditDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditDetailsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
        customer = cust;
        isbuyer = b;
        parentobj = parentframe;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent window) {
                parentobj.setEnabled(true);
            }
        });
        namefield.setText(customer.name);
        cityfield.setText(customer.city);
        telephonefield.setText(customer.telephone);
        emailidfield.setText(customer.email);
        setTitle("ONLINE SALES PORTAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        passwordfield = new javax.swing.JPasswordField();
        confirmpasswordfield = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ivtelelbl = new javax.swing.JLabel();
        ivnamelbl = new javax.swing.JLabel();
        ivemaillbl = new javax.swing.JLabel();
        ivcitylbl = new javax.swing.JLabel();

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

        jLabel6.setText("Change Password :");

        jLabel7.setText("New Password :");

        jLabel8.setText(" Confirm Password :");

        ivtelelbl.setForeground(new java.awt.Color(255, 0, 0));

        ivnamelbl.setForeground(new java.awt.Color(255, 0, 0));

        ivemaillbl.setForeground(new java.awt.Color(255, 0, 0));

        ivcitylbl.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(2, 2, 2))
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(namefield, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                    .addComponent(cityfield)
                                    .addComponent(telephonefield)
                                    .addComponent(emailidfield)
                                    .addComponent(imidbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ivtelelbl, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                    .addComponent(ivnamelbl, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                    .addComponent(ivemaillbl, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                    .addComponent(ivcitylbl, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(confirmpasswordfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                .addComponent(passwordfield, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addComponent(submitdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(namefield)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                            .addComponent(ivnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ivcitylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cityfield)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(telephonefield)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                            .addComponent(ivtelelbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailidfield)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                    .addComponent(ivemaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imidbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordfield, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(confirmpasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(submitdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "!!! Error \nProblem with the IM ID.");
            }
        }
    }//GEN-LAST:event_imidbuttonActionPerformed

    private void submitdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitdetailsActionPerformed
        String name, email, mobile, city, password = "", confirmpassword = "";
        boolean b = true;
        boolean dontsetpass = false;
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
            ivemaillbl.setText("Invalid !");
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
        password = new String(passwordfield.getPassword());
        confirmpassword = new String(confirmpasswordfield.getPassword());
        if (passwordfield.getPassword().length == 0 && confirmpasswordfield.getPassword().length == 0) {
            dontsetpass = true;
        } else if (!password.trim().equals(password)) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, " Invalid Password Entered (No Spaces Allowed). Enter Again .");
            b = false;
        } else if (!password.equals(confirmpassword)) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, " Password and Confirm Password are not matching. Enter Again .");
            b = false;
        }
        if (b && isbuyer) {
            // update query for buyer.
            try {
                DBConnection dbc = new DBConnection();
                Connection con = null;
                con = dbc.getConnnection();
                String query = "UPDATE buyerrecord SET password = ? , name = ? , city = ? , telephone = ? , email = ? where id = ?";
                PreparedStatement preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                if (!dontsetpass) {
                    preparedStmt.setString(1, password);
                } else {
                    preparedStmt.setString(1, customer.password);
                }
                preparedStmt.setString(2, name);
                preparedStmt.setString(3, city);
                preparedStmt.setString(4, mobile);
                preparedStmt.setString(5, email);
                preparedStmt.setInt(6, customer.id);
                try {
                    preparedStmt.executeUpdate();
                    if (bi != null) {
                        query = "UPDATE buyerrecord SET imid = ? where id = ?";
                        preparedStmt = con.prepareStatement(query);
                        ByteArrayOutputStream baos = null;
                        try {
                            baos = new ByteArrayOutputStream();
                            boolean write = ImageIO.write(bi, "png", baos);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Problem loading IM ID.");
                        } finally {
                            try {
                                baos.close();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Problem loading IM ID.");
                            }
                        }
                        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                        preparedStmt.setBlob(1, bais);
                        preparedStmt.setInt(2, customer.id);
                        preparedStmt.executeUpdate();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, " A buyer with the same email already exists.\n Updation failed.");
                }
                Component frame = null;
                JOptionPane.showMessageDialog(frame, " Updation Successful Login Again");
                con.close();
                parentobj.dispose();
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        } else if (b && !isbuyer) {
            // update query for seller.
            try {
                DBConnection dbc = new DBConnection();
                Connection con = null;
                con = dbc.getConnnection();
                String query = "UPDATE sellerrecord SET password = ? , name = ? , city = ? , telephone = ? , email = ? where id = ?";
                PreparedStatement preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                if (!dontsetpass) {
                    preparedStmt.setString(1, password);
                } else {
                    preparedStmt.setString(1, customer.password);
                }
                preparedStmt.setString(2, name);
                preparedStmt.setString(3, city);
                preparedStmt.setString(4, mobile);
                preparedStmt.setString(5, email);
                preparedStmt.setInt(6, customer.id);
                try {
                    preparedStmt.executeUpdate();
                    if (bi != null) {
                        query = "UPDATE sellerrecord SET imid = ? where id = ?";
                        preparedStmt = con.prepareStatement(query);
                        ByteArrayOutputStream baos = null;
                        try {
                            baos = new ByteArrayOutputStream();
                            boolean write = ImageIO.write(bi, "png", baos);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Problem loading IM ID.");
                        } finally {
                            try {
                                baos.close();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Problem loading IM ID.");
                            }
                        }
                        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                        preparedStmt.setBlob(1, bais);
                        preparedStmt.setInt(2, customer.id);
                        preparedStmt.executeUpdate();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, " A seller with the same email already exists.\n Updation failed.");
                }

                Component frame = null;
                JOptionPane.showMessageDialog(frame, " Updation Successful \n Login again .");
                con.close();
                parentobj.dispose();
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        }
    }//GEN-LAST:event_submitdetailsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cityfield;
    private javax.swing.JPasswordField confirmpasswordfield;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField namefield;
    private javax.swing.JPasswordField passwordfield;
    private javax.swing.JButton submitdetails;
    private javax.swing.JTextField telephonefield;
    // End of variables declaration//GEN-END:variables
}
