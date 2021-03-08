//STUDENT NAME: Chia-Yu Liu
//STUDENT ID: 100698737
//STUDENT NAME: Keefer Belanger
//STUDENT ID: 101152085

import java.util.*;

public class Inventory{

    /**
     * The Inventory class will track the state of the inventory of your system. It should keep track of the type
     * and quantity of each Product.
     */
    protected int price;                        // price of Product
    protected int quantity = 0;                 // quantity of Product
    private Product product = null;             // set a default product as null

    /**
     *  Using HashMap variable, products to contain the quantity data for each product.
     *  we choose HashMap because we can loop through each product to find the quantity
     *  or modify the quantity information, since Product class does not have quantity
     *  information inside the class
     */
    private HashMap<Product, Integer> products = new HashMap<Product, Integer>();      // products the inventory is tracking

    /**
     * Creates a new Inventory with the supplied attributes.
     * Set default values upon object creation
     */
    public Inventory(Product product, int quantity) {
        super();
        this.product = product;
        this.quantity = quantity;
        this.products.put(product, quantity);

    }
    /**
     * Create a default constructor without taking any attributes.
     * The product will be null and quantity is set to 0.
     */
    public Inventory(){
        this.product = null;
        this.quantity = 0;
    }

    /**
     * Author: Chia-Yu Liu
     *
     * Add the quantity of this Inventory by giving the product ID. If the id matches the product
     * id, the method will ask user to input the new quantity to add on exiting quantity. If none of
     * product id matches, the method will ask user to input new product info and add it into the inventory
     *
     * @param id
     * @void the method has no return value
     *
     */
    public void addQuantity(int id) {
        for (Map.Entry<Product, Integer> set : products.entrySet()) {
            if(set.getKey().getId() == id){
                Scanner keyboard = new Scanner(System.in);
                System.out.println("enter adding quantity amount");
                int num = keyboard.nextInt();
                num += set.getValue();
                set.setValue(num);
                return;
            }
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.println("New product for inventory");
        System.out.println("enter the product name");
        String name = keyboard.nextLine();

        System.out.println("enter the product price");
        float price = keyboard.nextFloat();
        Product product = new Product(name,id,price);

        System.out.println("enter new Quantity amount");
        int num = keyboard.nextInt();
        this.products.put(product, num);
        return;
    }

    /**
     * Author: Chia-Yu Liu
     *
     * Get the quantity of this Inventory by giving the product ID. If none of product id matches,
     * the method will print a error message telling user there is no such products in the inventory
     *
     * @param id
     * @returns Get the quantity of this Inventory
     * @return 0 if no product id mataches
     *
     */
    public int getQuantity(int id) {
        for (Map.Entry<Product, Integer> set : products.entrySet()) {
            if(set.getKey().getId() == id){
                return set.getValue();
            }
        }
        System.out.println("Product not in inventory.");
        return 0;

    }
    /**
     * Author: Chia-Yu Liu
     *
     * Subtract the quantity of this Inventory by giving the product ID. If the id matches the product
     * id, the method will ask user to input the quantity value wish to subtract from exiting quantity
     * If the new quantity is less than 0, will set quantity as 0
     *
     * If none of product id matches, the method will print message to tell user the prodcut is not in the
     * inventory
     *
     * @param id
     * @void the method has no return value
     *
     */
    public void removeQuantity(int id) {
        for (Map.Entry<Product, Integer> set : products.entrySet()) {
            if(set.getKey().getId() == id){
                Scanner keyboard = new Scanner(System.in);
                System.out.println("how much quantity to remove?");
                int num = keyboard.nextInt();
                int newnum = set.getValue()-num;
                if (newnum < 0){
                    set.setValue(0);
                    return;
                }else{
                    set.setValue(set.getValue()-num);
                    return;
                }
            }
        }
        System.out.println("Product not in inventory.");
        return;
    }

    /**
     * Author: Chia-Yu Liu
     *
     * Getter menthod for the Hashmap products
     *
     * @param products
     * @retuen Hashmap products
     *
     */
    public HashMap<Product, Integer> getProducts(HashMap<Product, Integer> products) {

        return this.products;

    }
    /**
     * Author: Chia-Yu Liu
     *
     * Getter method for information on a Product given a Product ID.
     * If no product ID matches, will print error message and return null
     *
     * @param id
     * @return the product which matches the given id
     * @return null, if cannot product ID matches
     *
     */
    public Product getProductInfo(int id) {
        for (Product set : products.keySet()) {
            if (set.getId() == id) {
                System.out.println("Prodcut name:" + set.getName());
                System.out.println("Prodcut ID:" + set.getId());
                System.out.println("Prodcut price:" + set.getPrice());

                return set;
            }
        }
        System.out.println("no such product");
        return null;
    }

    /**
     * Get this Product's quantity
     */
    public int getQuantity(){ return quantity; }
}

