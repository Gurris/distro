package Model.ManageDataObj;

import Model.DB.DBConnection;
import Model.Entitys.Product;
import Model.Entitys.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Gurris on 2016-10-03.
 */
public class ProductManager {

    public void createProduct(Product prod){ // get from DB
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("INSERT INTO product(P_name, P_price)" +
                    "VALUES (?, ?)");
            stmt.setString(1, prod.getName());
            stmt.setInt(2, prod.getPrice());
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


    public Product getProductByName(String name){// get from DB
        Product p = new Product();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * from product where P_name = ?;");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            while(rs.next()) {
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("P_name"));
                p.setPrice(rs.getInt("P_price"));
            }
            return p;
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

    public Product getProductById(int id){// get from DB
        Product p = new Product();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * from product where Id = ?;");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while(rs.next()) {
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("P_name"));
                p.setPrice(rs.getInt("P_price"));
            }
            return p;
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


    public ArrayList<Product> getProducts(){// get from DB
        ResultSet rs = null;
        ArrayList<Product> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM product");
            rs = stmt.executeQuery();

            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getInt("Id"));
                p.setName(rs.getString("P_name"));
                p.setPrice(rs.getInt("P_price"));
                list.add(p);
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
