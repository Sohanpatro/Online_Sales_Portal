

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EditManagerFrame extends javax.swing.JFrame {

    transient BufferedImage biimid = null;
    transient BufferedImage bibioid = null;
    transient JFrame parentobj;
    transient SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");

    public EditManagerFrame(JFrame parentframe) {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");        } catch (MalformedURLException ex) {
        }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 751, 497, back.getType()))));
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
            java.util.logging.Logger.getLogger(EditManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        try {
            DBConnection dbc = new DBConnection();
            Connection con = dbc.getConnnection();
            PreparedStatement preparedStmt = null;
            ResultSet rs = null;
            String query = "select * from manager";
            preparedStmt = con.prepareStatement(query);
            rs = preparedStmt.executeQuery();
            rs.next();
            namefield.setText(rs.getString("name"));
            addressfield.setText(rs.getString("address"));
            telephonefield.setText(rs.getString("telephone"));
            emailidfield.setText(rs.getString("email"));
            String genderdb = rs.getString("gender");
            if (genderdb.equals("male")) {
                maleradio.setSelected(true);
            } else if (genderdb.equals("female")) {
                femaleradio.setSelected(true);
            } else {
                otherradio.setSelected(true);
            }
            String birthday = rs.getString("dob");
            Date day = null;
            try {
                ft.setLenient(false);
                day = ft.parse(birthday);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Date of Birth.\n Inconvinience is regreted.");
            }
            dobchooser.setDate(day);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
        }
        setTitle("ONLINE SALES PORTAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngp = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        namefield = new javax.swing.JTextField();
        addressfield = new javax.swing.JTextField();
        telephonefield = new javax.swing.JTextField();
        emailidfield = new javax.swing.JTextField();
        imidbutton = new javax.swing.JButton();
        submitdetails = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordfield = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        confirmpasswordfield = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        biometricidbutton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        maleradio = new javax.swing.JRadioButton();
        femaleradio = new javax.swing.JRadioButton();
        otherradio = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        dobchooser = new com.toedter.calendar.JDateChooser();
        ivtelelbl = new javax.swing.JLabel();
        ivnamelbl = new javax.swing.JLabel();
        ivemaillbl = new javax.swing.JLabel();
        ivadrslbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("IM_ID        :");

        jLabel8.setText(" Confirm Password :");

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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Name         :");

        jLabel6.setText("Change Password :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Telephone  :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("E-mail         :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Address      :");

        jLabel7.setText("New Password :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Biometric ID :");

        biometricidbutton.setText("Browse");
        biometricidbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biometricidbuttonActionPerformed(evt);
            }
        });

        jLabel10.setText("Gender   :");

        btngp.add(maleradio);
        maleradio.setActionCommand("male");
        maleradio.setText("Male");

        btngp.add(femaleradio);
        femaleradio.setText("Female");
        femaleradio.setActionCommand("female");

        btngp.add(otherradio);
        otherradio.setText("Other");
        otherradio.setActionCommand("other");

        jLabel11.setText("Date Of Birth :");

        ivtelelbl.setForeground(new java.awt.Color(255, 0, 0));

        ivnamelbl.setForeground(new java.awt.Color(255, 0, 0));

        ivemaillbl.setForeground(new java.awt.Color(255, 0, 0));

        ivadrslbl.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(2, 2, 2))
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addressfield, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                    .addComponent(namefield)
                                    .addComponent(emailidfield)
                                    .addComponent(telephonefield))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ivtelelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ivnamelbl, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                    .addComponent(ivemaillbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ivadrslbl, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dobchooser, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 38, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(biometricidbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(maleradio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(femaleradio)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(otherradio))))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(confirmpasswordfield, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passwordfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(imidbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namefield, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(biometricidbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ivnamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(addressfield, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addComponent(ivadrslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(ivtelelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(telephonefield))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(maleradio)
                                .addComponent(femaleradio)
                                .addComponent(otherradio)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dobchooser, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ivemaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(emailidfield))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imidbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(confirmpasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(submitdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
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
                biimid = ImageIO.read(fc.getSelectedFile());
                biimid = MainFrame.resizeImage(biimid, 50, 50, biimid.getType());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "!!! Error \n Problem loading the IM ID.\n Old IM ID is preserved.\n Inconvinience is Regreted");
                biimid = null;
            }
        }
    }//GEN-LAST:event_imidbuttonActionPerformed

    private void biometricidbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biometricidbuttonActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        fc.setDialogTitle("Choose a Picture to upload.");
        fc.setFileFilter(filter);
        int a = fc.showOpenDialog(this);
        if (a == JFileChooser.APPROVE_OPTION) {
            Component frame = null;
            try {
                bibioid = ImageIO.read(fc.getSelectedFile());
                bibioid = MainFrame.resizeImage(bibioid, 50, 50, bibioid.getType());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "!!! Error \n Problem loading the Biometric ID.\n Old Biometric ID is preserved.\n Inconvinience is Regreted");
                bibioid = null;
            }
        }
    }//GEN-LAST:event_biometricidbuttonActionPerformed

    private void submitdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitdetailsActionPerformed
        String name, email, mobile, address, password, confirmpassword, dob, gender;
        boolean b = true;
        boolean dontchange = false;
        name = namefield.getText();
        if (name.trim().equals("")) {
            ivnamelbl.setText("Invalid !");
            b = false;
        } else {
            ivnamelbl.setText("");
        }
        address = addressfield.getText();
        if (address.trim().equals("")) {
            ivadrslbl.setText("Invalid !");
            b = false;
        } else {
            ivadrslbl.setText("");
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
        gender = btngp.getSelection().getActionCommand();
        if (gender == null) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, " Select a gender .");
            b = false;  // to match only 10 digited numbers with first digit greater than = 1.
        }
        if (b) {
            Pattern mobilepattern = Pattern.compile("^[1-9][0-9]{9}");
            Matcher testA = mobilepattern.matcher(mobile);
            if (!testA.matches()) {
                Component frame = null;
                JOptionPane.showMessageDialog(frame, " Invalid Telephone Entered . Enter Again .");
                b = false;  // to match only 10 digited numbers with first digit greater than = 1.
            }
        }
        dob = ft.format(dobchooser.getDate());
        password = new String(passwordfield.getPassword());
        confirmpassword = new String(confirmpasswordfield.getPassword());
        if (passwordfield.getPassword().length == 0 && confirmpasswordfield.getPassword().length == 0) {
            dontchange = true;
        } else if (!password.trim().equals(password)) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, " Invalid Password Entered (No Spaces Allowed). Enter Again .");
            b = false;
        } else if (!password.equals(confirmpassword)) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, " Password and Confirm Password are not matching. Enter Again .");
            b = false;
        }
        if (b) {
            try {
                DBConnection dbc = new DBConnection();
                Connection con = null;
                con = dbc.getConnnection();
                String query = "UPDATE manager SET gender = ? ,name = ?, address = ?, telephone = ?, email = ?, dob = ?  where id = ?";
                PreparedStatement preparedStmt = null;
                preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, gender);
                preparedStmt.setString(2, name);
                preparedStmt.setString(3, address);
                preparedStmt.setString(4, mobile);
                preparedStmt.setString(5, email);
                preparedStmt.setString(6, dob);
                preparedStmt.setString(7, "manager");
                preparedStmt.executeUpdate();
                if (dontchange == false) {
                    query = "UPDATE manager SET password = ? where id = ?";
                    preparedStmt = con.prepareStatement(query);
                    preparedStmt.setString(1, password);
                    preparedStmt.setString(2, "manager");
                    preparedStmt.executeUpdate();
                }
                if (biimid != null) {
                    query = "UPDATE manager SET imid = ? where id = ?";
                    preparedStmt = con.prepareStatement(query);
                    ByteArrayOutputStream baos = null;
                    try {
                        baos = new ByteArrayOutputStream();
                        boolean write = ImageIO.write(biimid, "png", baos);
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
                    preparedStmt.setString(2, "manager");
                    preparedStmt.executeUpdate();
                }
                if (bibioid != null) {
                    query = "UPDATE manager SET bioid = ? where id = ?";
                    preparedStmt = con.prepareStatement(query);
                    ByteArrayOutputStream baos = null;
                    try {
                        baos = new ByteArrayOutputStream();
                        boolean write = ImageIO.write(bibioid, "png", baos);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Problem loading Biometric ID.");
                    } finally {
                        try {
                            baos.close();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Problem loading Biometric ID.");
                        }
                    }
                    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                    preparedStmt.setBlob(1, bais);
                    preparedStmt.setString(2, "manager");
                    preparedStmt.executeUpdate();
                }
                Component frame = null;
                JOptionPane.showMessageDialog(frame, " Updation Successful Login Again");
                con.close();
                parentobj.dispose();
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
            }
        }

    }//GEN-LAST:event_submitdetailsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressfield;
    private javax.swing.JButton biometricidbutton;
    private javax.swing.ButtonGroup btngp;
    private javax.swing.JPasswordField confirmpasswordfield;
    private com.toedter.calendar.JDateChooser dobchooser;
    private javax.swing.JTextField emailidfield;
    private javax.swing.JRadioButton femaleradio;
    private javax.swing.JButton imidbutton;
    private javax.swing.JLabel ivadrslbl;
    private javax.swing.JLabel ivemaillbl;
    private javax.swing.JLabel ivnamelbl;
    private javax.swing.JLabel ivtelelbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton maleradio;
    private javax.swing.JTextField namefield;
    private javax.swing.JRadioButton otherradio;
    private javax.swing.JPasswordField passwordfield;
    private javax.swing.JButton submitdetails;
    private javax.swing.JTextField telephonefield;
    // End of variables declaration//GEN-END:variables
}
