//STUDENT NAME: Chia-Yu Liu //
//STUDENT ID: 100698737     //
//STUDENT NAME: Keefer Belanger//
//STUDENT ID:  101152085//

import java.util.ArrayList;

public class Product {


    private String name;                     // name of the Product
    private int id;                          // id of Product
    private double price;                     // price of Product



    /**
     * Creates a new Product with the supplied attributes.
     */
    public Product(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    /**
     * Get this Product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Get this Product's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Get this Product's price.
     */
    public double getPrice() {
        return price;
    }





}
