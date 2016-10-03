package Controller;
import Model.Entitys.Product;
import Model.ManageDataObj.ProductManager;

/**
 * Created by Gurris on 2016-10-03.
 */
public class ProductController {

    public Product getProductByName(String productName){
        Product p;
        ProductManager PM = new ProductManager();
        p = PM.getProductByName(productName);
        return new Product(p);
    }

    public Product getProductById(int id){
        Product p;
        ProductManager PM = new ProductManager();
        p = PM.getProductById(id);
        return new Product(p);
    }

}
