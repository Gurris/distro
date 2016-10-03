package Model.DB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Gurris on 2016-10-02.
 */
public class DBConnection {

    public static Connection getConnection(){
        Connection conn = null;

        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/myDB?autoReconnect=true&useSSL=false", "Gurris", "gurris");
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/distro", "root", "1234");

        }catch (Exception e){
            System.out.println("Exception from getConnection! " + e);
        }

        return conn;
    }

}
