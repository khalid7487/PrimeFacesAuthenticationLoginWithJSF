
package dao;

/**
 *
 * @author KHALID
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginjdbc",
                    "root","7487");
            return con;
        } catch (Exception ex) {
            System.out.println("Db Error:"+ex.getMessage());
            return null;
        }
    }
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
        }
    }
}
