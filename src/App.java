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

        User gustaf = new User("Gurra", "Gustaf", "Holmström");

        um.createUser(gustaf);
    }

}