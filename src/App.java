import Model.ManageDataObj.ProductManager;
import Model.ManageDataObj.UserManager;
import Model.Entitys.*;

import java.util.ArrayList;

/**
 * Created by Gurris on 2016-10-02.
 */
public class App {

    public static void main(String[] args){

        //ArrayList<User> list = new ArrayList<User>();
        //UserManager um = new UserManager();
        //list = um.getUsers();

        Product p = new Product("Ketchup", 50);
        ProductManager pm = new ProductManager();
        pm.createProduct(p);


    }

}