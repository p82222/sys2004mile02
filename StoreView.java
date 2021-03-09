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
        Product apple = new Product("apple", 001, 1.0);
        /**
         * the inventory
         */
        Inventory inventory = new Inventory(apple, 10);

        /**
         * the manager for the StoreView
         */
        StoreManager manager = new StoreManager(inventory);

        /**
         * the StoreView variable
         */
        StoreView storeView = new StoreView(manager, manager.assignNewCartID());

        /**
         * the shopping cart
         */
        ShoppingCart cart = new ShoppingCart();

        /**
         * Taking an input from the user
         */
        Scanner in = new Scanner(System.in);

        /**
         * empty string to use as input string
         */
        String reply = "";

        System.out.print("CHOOSE YOUR STOREVIEW >>> ");

        /**
         * accepting the user input
         */
        int storeCount = in.nextInt();


        while(true) {

            /**
             * create a shooping cart
             */
            cart = storeManager.getShoppingCart();

            System.out.println("CART >>> " + cartID);

            while (!reply.equals("quit")) {

                /**
                 *This is the HashMap that stores the options and the items that options point to.
                 */
                HashMap<Integer, Integer> store = new HashMap<>();

                System.out.println("Please enter a command : (B/A/R/C/Q)");
                System.out.println("Option: Browse, Add, Remove, Checkout and Quit");


                reply = in.next().toUpperCase();

                if (!reply.equals("Q")) {

                    System.out.println("|----------------THE STORE----------------|");
                }

                if (reply.equals("B")) {

                    storeManager.browse();

                    System.out.print("\nGO TO ANOTHER STOREVIEW? (Y) >>> ");
                    String newStore = in.next().toUpperCase();

                    if (newStore.equals("Y")) {

                        storeView = new StoreView(manager, manager.assignNewCartID());
                    }

                    System.out.println("CART >>> " + cartID);

                } else if (reply.equals("A")) {
                    System.out.println("\\-------------------------ADD------------------------/\n");

                    storeManager.browse();


                    System.out.print("\nWhat item you like to add to your cart? : ");

                    String add = in.next().toUpperCase();
                    Product addproduct = storeManager.findProduct(add);
                    storeManager.addToCart(addproduct);



                } else if (reply.equals("R")) {

                    //checking if cart is empty
                    if (cart.getCartItem().size() > 0) {

                        System.out.println("\\------------------------Remove----------------------/\n");
                        storeManager.browse();

                        System.out.print("\nWhat item you like to remove to your cart? : ");

                        String remove = in.next().toUpperCase();
                        Product removeproduct = storeManager.findProduct(remove);
                        storeManager.removeFromCart(removeproduct);
                    } else {

                        System.out.println("\nNo item in the cart.");
                    }
                } else if (reply.equals("C")) {

                    //proceed check out
                    storeManager.processTransaction(cart);


                } else if (reply.equals("Q")) {
                    //quit the process
                   storeManager.quit(storeManager.getCartID());
                   break;
                }
            }
            System.out.println("\nThanks for shopping.\n");

        }
    }

}
