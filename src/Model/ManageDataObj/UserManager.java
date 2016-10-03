package Model.ManageDataObj;

import Model.DB.DBConnection;
import Model.Entitys.User;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Gurris on 2016-10-02.
 */
public class UserManager {

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

    public boolean AuthenticateUser(String Username, String Password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * from user where Username = ?;");
            stmt.setString(1, Username);
            rs = stmt.executeQuery();

            while(rs.next()) {
                if(rs.getString("Username").equals(Username) && rs.getString("Password").equals(Password)){
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
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
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("DELETE from user where Id = ?;");
            stmt.setInt(1, id);
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

    public void updateUser(User u){
        User user = u;
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("update user set Username=?, Firstname=?, Lastname=? where Id =?;");
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getFirstname());
            stmt.setString(3, u.getLastname());
            stmt.setInt(4, u.getId());
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

    public ArrayList<User> getUsers(){
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        try{

            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user");
            rs = stmt.executeQuery();

            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("Id"));
                u.setUsername(rs.getString("Username"));
                u.setFirstname(rs.getString("Firstname"));
                u.setLastname(rs.getString("Lastname"));
                list.add(u);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
