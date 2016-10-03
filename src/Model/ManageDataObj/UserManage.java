package Model.ManageDataObj;

import Model.DB.DBConnection;
import Model.Entitys.User;

import java.sql.*;

/**
 * Created by Gurris on 2016-10-02.
 */
public class UserManage {

    public void createUser(User user){
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("INSERT INTO user(Username, Firstname, Lastname)" +
                    "VALUES (?, ?, ?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getFirstname());
            stmt.setString(3, user.getLastname());
            stmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public User getUserById(int id){
        User user = new User();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * from user where Id = ?;");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while(rs.next()) {
                user.setId(rs.getInt("Id"));
                user.setUsername(rs.getString("Username"));
                user.setFirstname(rs.getString("Firstname"));
                user.setLastname(rs.getString("Lastname"));
            }
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void deleteUser(int id){

    }

    public void updateUser(int id, String username, String firstName, String lastName){

    }
}
