package Model.Entitys;

/**
 * Created by Gurris on 2016-10-03.
 */
public class Product {
    private int Id;
    private String name;
    private int price;

    public Product(){
    }

    public Product(int id, String name, int price){
        this.Id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public Product(Product p){
        this.Id = p.getId();
        this.name = p.getName();
        this.price = p.getPrice();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
