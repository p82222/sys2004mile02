//STUDENT NAME: Chia-Yu Liu
//STUDENT ID: 100698737
//STUDENT NAME: Keefer Belanger
//STUDENT ID: 101152085

import java.util.HashMap;
import java.util.Scanner;

/**
 * This class will keep track the states of StoreView
 */
public class StoreView {

    private static StoreManager storeManager;

    private static int cartID;

    public StoreView(){
        this(new StoreManager(),0);
    }

    /**
     * Creates a new StoreView with the supplied attributes.
     * Set default values upon object creation
     */
    public StoreView(StoreManager storeManager, int cartID){
        this.storeManager = storeManager;
        this.cartID = cartID;
    }

    public static void main(String[] args) {


        /**
         * the first product
         */
        Product apple = new Product("apple", 101, 1.0);
        Product banana = new Product("banana", 202, 2.0);
        Product iPhone = new Product("iPhone", 303, 3.0);
        Product iPad = new Product("iPad",404 , 4.0);
        Product MacBook = new Product("MacBook", 505, 5.0);



        /**
         * the inventory
         */
        Inventory inventor1 = new Inventory(apple, 10);
        Inventory inventor2 = new Inventory(banana, 10);
        Inventory inventor3 = new Inventory(iPhone, 10);
        Inventory inventor4 = new Inventory(iPad, 10);
        Inventory inventor5 = new Inventory(MacBook, 10);






        /**
         * the manager for the StoreView
         */
        StoreManager manager = new StoreManager();
        ShoppingCart currentCart;


        StoreView sv1 = new StoreView(manager, manager.assignNewCartID());
        StoreView sv2 = new StoreView(manager, manager.assignNewCartID());
        StoreView sv3 = new StoreView(manager, manager.assignNewCartID());




        manager.addInventory(inventor1);
        manager.addInventory(inventor2);
        manager.addInventory(inventor3);
        manager.addInventory(inventor4);
        manager.addInventory(inventor5);



        System.out.println("============store test from now========");

        System.out.println(" pick first cart");

        currentCart = manager.findCart();

        boolean flag = true;

        String command = manager.command();


        //b/a/r/c/q
        while(!command.equals("q")){

            if (command.equals("b")){
                manager.browse();
                command = manager.command();
            }else if (command.equals("a")){
                manager.addToCart(currentCart);
                command = manager.command();
            }else if (command.equals("r")){
                manager.removeFromCart(currentCart);
                command = manager.command();
            }else if(command.equals("c")){
                double total = manager.processTransaction(currentCart);
                System.out.println("total test:");
                System.out.println(total);
                break;
            }else if(command.equals("q")){
                manager.quit(currentCart, cartID);
                break;
            }

        }
        System.out.println("thanks for shopping with us today");




    }

}
