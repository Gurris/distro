import Model.DBM.UserManager;
import Model.Entitys.*;

/**
 * Created by Gurris on 2016-10-02.
 */
public class App {

    public static void main(String[] args){

        //ArrayList<User> list = new ArrayList<User>();
        //UserManager um = new UserManager();
        //list = um.getUsers();

        User u = new User("Snurris", "Gustaf", "Holmström", "123");
        UserManager um = new UserManager();
        um.createUser(u);



        //Product p = new Product("Korv", 67);
        //ProductManager pm = new ProductManager();
        //pm.createProduct(p);


    }

}