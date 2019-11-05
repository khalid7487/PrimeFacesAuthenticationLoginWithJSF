package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author KHALID
 */
public class UserDAO {
    public static boolean login(String user,String password){
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=Database.getConnection();
            ps=con.prepareStatement("select user, password from user where user=? and password=?");
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (Exception er) {
            er.printStackTrace();
            return false;
        }finally{
            Database.close(con);
        }
    }
    
}
