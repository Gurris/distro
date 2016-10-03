import Model.ManageDataObj.UserManage;
import Model.Entitys.*;

import java.sql.Connection;

/**
 * Created by Gurris on 2016-10-02.
 */
public class App {

    public static void main(String[] args){

        UserManage um = new UserManage();
        User u = um.getUserById(2);
        System.out.println("id: " + u.getId());
        System.out.println("username: " + u.getUsername());
        System.out.println("Firstnaem: " + u.getFirstname());
        System.out.println("Lastname: " + u.getLastname());



    }

}
