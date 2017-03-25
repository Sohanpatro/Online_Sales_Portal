

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    String username = "root";
    String password = "china2014";
    String host = "jdbc:mysql://localhost:3306/mysql";
    Connection conn = null;
    DBConnection(){
        try {
            conn = DriverManager.getConnection(host, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnnection(){
        return conn;
    }
}