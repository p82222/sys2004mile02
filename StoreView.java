//STUDENT NAME: Chia-Yu Liu
//STUDENT ID: 100698737
//STUDENT NAME: Keefer Belanger
//STUDENT ID: 101152085

import java.util.HashMap;
import java.util.Scanner;

public class StoreView {

    private static StoreManager storeManager;

    private static int cartID;

    public StoreView(StoreManager storeManager, int cartID){
        this.storeManager = storeManager;
        this.cartID = cartID;
    }

    public static void main(String[] args) {

        /**
         * This is the first product
         */

        Product apple = new Product("apple", 001, 1.0);
        /**
         * This is the inventory
         */
        Inventory inventory = new Inventory(apple, 10);

        /**
         * This is the manager for the StoreView
         */
        StoreManager manager = new StoreManager(inventory);

        /**
         * This is the StoreView variable
         */
        StoreView storeView = new StoreView(manager, manager.assignNewCartID());

        /**
         * This is the shopping cart
         */
        ShoppingCart cart = new ShoppingCart();

        /**
         * This takes an input from the user
         */
        Scanner in = new Scanner(System.in);

        /**
         * This is an empty string to be used later
         */
        String command = "";

        System.out.print("CHOOSE YOUR STOREVIEW >>> ");

        /**
         * This stores the user input
         */
        int storeCount = in.nextInt();

        //This loop would run forever until the system shuts down.
        while(true) {

            /**
             * This stores the shopping cart from the manager
             */
            cart = storeManager.getShoppingCart();

            System.out.println("CART >>> " + cartID);

            while (!command.equals("quit")) {

                /**
                 *This is the HashMap that stores the options and the items that options point to.
                 */
                HashMap<Integer, Integer> store = new HashMap<>();

                System.out.println("\nCommand Option:\n Browse\n Add\n Remove\n Checkout\n quit\n\n" +
                        "Please enter a command from above:");

                command = in.next().toLowerCase();

                if (!command.equals("quit")) {

                    System.out.println("|----------------THE SMARTPHONE STORE----------------|");
                }

                if (command.equals("browse")) {

                    storeManager.browse();

                    System.out.print("\nGO TO ANOTHER STOREVIEW? (Y) >>> ");
                    String newStore = in.next().toUpperCase();

                    if (newStore.equals("Y")) {

                        storeView = new StoreView(manager, manager.assignNewCartID());
                    }

                    System.out.println("CART >>> " + cartID);

                } else if (command.equals("add")) {
                    System.out.println("\\-------------------------ADD------------------------/\n");

                    storeManager.browse();
                    int count = 0;


                    System.out.print("\nWhat item you like to add to your cart? : ");

                    String add = in.next().toUpperCase();
                    Product addproduct = storeManager.findProduct(add);
                    storeManager.addToCart(addproduct);



                } else if (command.equals("remove")) {

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
                } else if (command.equals("checkout")) {

                    storeManager.processTransaction(cart);


                } else if (command.equals("quit")) {

                   storeManager.quit(storeManager.getCartID());
                }
            }

            System.out.println("\nThanks for shopping.\n");




        }
    }

}
