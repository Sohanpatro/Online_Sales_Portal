

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");
        } catch (MalformedURLException ex) {
                  }
        BufferedImage back = null;
        try {
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 704, 453, back.getType()))));
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

        setTitle("ONLINE SALES PORTAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loginbutton = new javax.swing.JButton();
        usernamefield = new javax.swing.JTextField();
        passwordfield = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        signupbutton = new javax.swing.JButton();
        usernamelabel = new javax.swing.JLabel();
        passwordlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("ON-LINE SALES PORTAL");

        jLabel2.setText("_________________________________________________________________________________________________________________");

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        jLabel3.setText("Username   :");

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        jLabel4.setText("Password   :");

        loginbutton.setFont(new java.awt.Font("Monotype Corsiva", 2, 36)); // NOI18N
        loginbutton.setText("Login");
        loginbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbuttonActionPerformed(evt);
            }
        });

        usernamefield.setToolTipText("Enter username");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Don't have an account ? :");

        signupbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        signupbutton.setText("Sign Up");
        signupbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(loginbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel5)
                                .addGap(49, 49, 49)
                                .addComponent(signupbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(usernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))
                .addComponent(loginbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signupbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbuttonActionPerformed
        String id, pass;
        boolean b = true;
        id = usernamefield.getText();
        int length = passwordfield.getPassword().length;
        pass = new String(passwordfield.getPassword());
        usernamelabel.setForeground(Color.red);
        passwordlabel.setForeground(Color.red);
        if (id.trim().equals("")) {
            usernamelabel.setText("Invalid username");
            b = false;
        } else{
            usernamelabel.setText("");
        }
        if (pass.trim().equals("")) {
            passwordlabel.setText("Invalid password");
            b = false;
        } else{
            passwordlabel.setText("");
        }
        if (b) {
            int idpart = -1;
            if (id.equals("manager")) {
                DBConnection dbc = new DBConnection();
                Connection con = null;
                con = dbc.getConnnection();
                String query = "select * from manager";
                PreparedStatement preparedStmt = null;
                try {
                    preparedStmt = con.prepareStatement(query);
                } catch (SQLException ex) {
                }
                try {
                    // execute the preparedstatement  
                    ResultSet rs = null;
                    rs = preparedStmt.executeQuery();

                    while (rs.next()) {

                        if (rs.getString("password").equals(pass)) {
                            Manager manager = new Manager();
                            manager.id = "manager";
                            manager.password = pass;
                            manager.name = rs.getString("name");
                            manager.address = rs.getString("address");
                            manager.telephone = rs.getString("telephone");
                            manager.email = rs.getString("email");
                            Blob blob = rs.getBlob("imid");
                            int bloblength = (int) blob.length();
                            byte[] blobbytes = blob.getBytes(1, bloblength);
                            try {
                                manager.imid = ImageIO.read(new ByteArrayInputStream(blobbytes));
                            } catch (IOException ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            blob = rs.getBlob("bioid");
                            bloblength = (int) blob.length();
                            blobbytes = blob.getBytes(1, bloblength);
                            try {
                                manager.biometricid = ImageIO.read(new ByteArrayInputStream(blobbytes));
                            } catch (IOException ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            ManagerFrame managerframe = new ManagerFrame(manager);
                            try {
                                con.close();
                            } catch (SQLException ex) {
                            }

                        } else {
                            passwordlabel.setText("Invalid Password");
                            try {
                                con.close();
                            } catch (SQLException ex) {
                            }
                            b = false;
                        }
                        b = false;
                        break;
                    }
                    if (b) {
                        usernamelabel.setText("Invalid Username");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else if (id.startsWith("seller")) {
                try {
                    idpart = Integer.parseInt(id.substring(6));
                } catch (Exception number) {
                    usernamelabel.setText("Invalid username");
                    b = false;
                }
                if (b) {
                    DBConnection dbc = new DBConnection();
                    Connection con = null;
                    con = dbc.getConnnection();
                    String query = "select * from sellerrecord where id = ?";
                    PreparedStatement preparedStmt = null;
                    try {
                        preparedStmt = con.prepareStatement(query);
                        preparedStmt.setInt(1, idpart);
                    } catch (SQLException ex) {
                    }
                    try {
                        // execute the preparedstatement  
                        ResultSet rs = null;
                        rs = preparedStmt.executeQuery();
                        while (rs.next()) {
                            if (rs.getString("password").equals(pass)) {
                                Seller seller = new Seller();
                                seller.id = idpart;
                                seller.password = pass;
                                seller.name = rs.getString("name");
                                seller.city = rs.getString("city");
                                seller.telephone = rs.getString("telephone");
                                seller.email = rs.getString("email");
                                Blob blob = rs.getBlob("imid");
                                if (blob != null) {
                                    int bloblength = (int) blob.length();
                                    byte[] blobbytes = blob.getBytes(1, bloblength);
                                    try {
                                        seller.im_id = ImageIO.read(new ByteArrayInputStream(blobbytes));
                                    } catch (IOException ex) {
                                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    seller.im_id = null;
                                }
                                SellerFrame sellframe = new SellerFrame(seller, this);

                                try {
                                    con.close();
                                } catch (SQLException ex) {
                                }
                            } else {
                                passwordlabel.setText("Invalid Password");
                                b = false;
                                try {
                                    con.close();
                                } catch (SQLException ex) {
                                }
                            }
                            b = false;
                            break;
                        }
                        if (b) {
                            usernamelabel.setText("Invalid Username");
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (id.startsWith("buyer")) {
                try {
                    idpart = Integer.parseInt(id.substring(5));
                } catch (Exception number) {
                    usernamelabel.setText("Invalid username");
                    b = false;
                }
                if (b) {
                    DBConnection dbc = new DBConnection();
                    Connection con = null;
                    con = dbc.getConnnection();
                    String query = "select * from buyerrecord where id = ?";
                    PreparedStatement preparedStmt = null;
                    try {
                        preparedStmt = con.prepareStatement(query);
                        preparedStmt.setInt(1, idpart);
                    } catch (SQLException ex) {
                    }
                    try {
                        // execute the preparedstatement  
                        ResultSet rs = null;
                        rs = preparedStmt.executeQuery();
                        while (rs.next()) {
                            if (rs.getString("password").equals(pass)) {
                                Buyer buyer = new Buyer();
                                buyer.id = idpart;
                                buyer.password = pass;
                                buyer.name = rs.getString("name");
                                buyer.city = rs.getString("city");
                                buyer.telephone = rs.getString("telephone");
                                buyer.email = rs.getString("email");
                                Blob blob = rs.getBlob("imid");
                                if (blob != null) {
                                    int bloblength = (int) blob.length();
                                    byte[] blobbytes = blob.getBytes(1, bloblength);
                                    try {
                                        buyer.im_id = ImageIO.read(new ByteArrayInputStream(blobbytes));
                                    } catch (IOException ex) {
                                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    buyer.im_id = null;
                                }
                                BuyerFrame buyframe = new BuyerFrame(buyer, this);
                                try {
                                    con.close();
                                } catch (SQLException ex) {
                                }

                            } else {
                                passwordlabel.setText("Invalid Password");
                                try {
                                    con.close();
                                } catch (SQLException ex) {
                                }
                                b = false;
                            }
                            b = false;
                            break;
                        }
                        if (b) {
                            usernamelabel.setText("Invalid Username");
                        }

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,"DATABASE CONNECTION PROBLEM");
                        ex.printStackTrace();
                    }
                }
            } else {
                usernamelabel.setText("Invalid Username");
            }
        }
    }//GEN-LAST:event_loginbuttonActionPerformed

    private void signupbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbuttonActionPerformed
        RegistrationFrame rf = new RegistrationFrame(this);
        this.setEnabled(false);
    }//GEN-LAST:event_signupbuttonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

    }

    static BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) {
        BufferedImage scaledImage = new BufferedImage(width, height, type);
        Graphics2D g = scaledImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();
        return scaledImage;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton loginbutton;
    private javax.swing.JPasswordField passwordfield;
    private javax.swing.JLabel passwordlabel;
    private javax.swing.JButton signupbutton;
    private javax.swing.JTextField usernamefield;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
