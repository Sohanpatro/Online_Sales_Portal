
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

public class ManagerItemFrame extends javax.swing.JFrame {

    transient Item item;
    transient JFrame parentobj;

    public ManagerItemFrame(int itemID, JFrame parentframe) throws SQLException {
        URL input = null;
        try {
            input = new URL("file:nice-earth-wind-hd-wallpaper-backgrounds.jpg");        } catch (MalformedURLException ex) {
        }

        try {
            BufferedImage back = null;
            back = ImageIO.read(input);
            setContentPane(new JLabel(new ImageIcon(MainFrame.resizeImage(back, 797, 556, back.getType()))));
        } catch (IOException ex) {
        }
        ImageIcon image = null;
        try {
            DBConnection dbc = new DBConnection();
            Connection con = null;
            con = dbc.getConnnection();
            String query = "select * from itemrecord where id = ?";
            PreparedStatement preparedStmt = null;
            preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, itemID);
            ResultSet rs = null;
            rs = preparedStmt.executeQuery();

            rs.next();
            Item item = new Item();
            item.id = rs.getInt("id");
            item.categoryId = rs.getInt("category");
            item.price = rs.getDouble("price");
            item.ownerId = rs.getInt("ownerid");
            item.age = rs.getDouble("age");
            item.city = rs.getString("city");
            item.info = rs.getString("info");
            item.isHeavy = rs.getBoolean("isheavy");
            item.isNew = rs.getBoolean("isnew");
            item.mfgComp = rs.getString("mfgcomp");
            byte[] img = rs.getBytes("photo");
            image = new ImageIcon(img);
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem with Database Connection.\n Inconvinience is regreted.");
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
        parentobj = parentframe;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent window) {
                parentobj.setEnabled(true);
            }
        });
        photolbl.setIcon(image);
        infota.setText(item.info);
        idtf.setText("" + item.id);
        categorytf.setText("" + item.categoryId);
        citytf.setText(item.city);
        owneridtf.setText("seller" + item.ownerId);
        pricetf.setText("" + item.price);
        manucomptf.setText(item.mfgComp);
        if (item.isNew == true) {
            newtf.setText("New Item");
        } else {
            newtf.setText("");
        }
        agetf.setText("" + item.age);
        if (item.isHeavy == true) {
            heavytf.setText("Heavy Item");
        } else {
            heavytf.setText("");
        }
        setTitle("ONLINE SALES PORTAL");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photolbl = new javax.swing.JLabel();
        categorylbl = new javax.swing.JLabel();
        categorytf = new javax.swing.JTextField();
        manucomplbl = new javax.swing.JLabel();
        infolbl = new javax.swing.JLabel();
        citylbl = new javax.swing.JLabel();
        citytf = new javax.swing.JTextField();
        manucomptf = new javax.swing.JTextField();
        idlbl = new javax.swing.JLabel();
        owneridlbl = new javax.swing.JLabel();
        pricelbl = new javax.swing.JLabel();
        agelbl = new javax.swing.JLabel();
        owneridtf = new javax.swing.JTextField();
        pricetf = new javax.swing.JTextField();
        agetf = new javax.swing.JTextField();
        idtf = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        infota = new javax.swing.JTextArea();
        heavytf = new javax.swing.JLabel();
        newtf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        categorylbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        categorylbl.setText("Category :");

        categorytf.setEditable(false);

        manucomplbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manucomplbl.setText("Manufacturing Company :");

        infolbl.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        infolbl.setText("Information :");

        citylbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        citylbl.setText("City :");

        citytf.setEditable(false);

        manucomptf.setEditable(false);

        idlbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idlbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        idlbl.setText("ID :");

        owneridlbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        owneridlbl.setText("Owner ID :");

        pricelbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pricelbl.setText("Price :");

        agelbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        agelbl.setText("Age :");

        owneridtf.setEditable(false);

        pricetf.setEditable(false);

        agetf.setEditable(false);
        //
        //if(item.isNew == true)
        //    agetf.setText("0");
        //else
        //    agetf.setText("" + item.age);

        idtf.setEditable(false);

        infota.setEditable(false);
        infota.setBackground(new java.awt.Color(240, 240, 240));
        infota.setColumns(20);
        infota.setLineWrap(true);
        infota.setRows(5);
        jScrollPane2.setViewportView(infota);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(citylbl)
                            .addComponent(categorylbl))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(citytf, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(manucomplbl))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(owneridlbl)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(idtf, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(categorytf, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(101, 101, 101)
                                    .addComponent(pricelbl))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pricetf, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(owneridtf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manucomptf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(heavytf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(newtf, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(agelbl)
                                        .addGap(24, 24, 24)
                                        .addComponent(agetf, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(photolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(infolbl))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infolbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(photolbl, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idlbl)
                            .addComponent(idtf, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(owneridlbl)
                            .addComponent(owneridtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(newtf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(categorylbl)
                        .addComponent(categorytf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pricelbl)
                        .addComponent(pricetf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(agetf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(citylbl)
                    .addComponent(citytf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manucomplbl)
                    .addComponent(manucomptf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(heavytf, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agelbl;
    private javax.swing.JTextField agetf;
    private javax.swing.JLabel categorylbl;
    private javax.swing.JTextField categorytf;
    private javax.swing.JLabel citylbl;
    private javax.swing.JTextField citytf;
    private javax.swing.JLabel heavytf;
    private javax.swing.JLabel idlbl;
    private javax.swing.JTextField idtf;
    private javax.swing.JLabel infolbl;
    private javax.swing.JTextArea infota;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel manucomplbl;
    private javax.swing.JTextField manucomptf;
    private javax.swing.JLabel newtf;
    private javax.swing.JLabel owneridlbl;
    private javax.swing.JTextField owneridtf;
    private javax.swing.JLabel photolbl;
    private javax.swing.JLabel pricelbl;
    private javax.swing.JTextField pricetf;
    // End of variables declaration//GEN-END:variables
}
