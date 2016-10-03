import Model.ManageDataObj.UserManage;
import Model.Entitys.*;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by Gurris on 2016-10-02.
 */
public class App {

    public static void main(String[] args){

        UserManage um = new UserManage();

        ArrayList<User> list = um.getUsers();

        for (int i=0; i<list.size(); i++) {
            System.out.println("ID's: " + list.get(i).getId());
        }
    }

}