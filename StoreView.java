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

        Product p1 = new Product("IPHONE", 1001, 400);
        /**
         * This is the inventory
         */
        Inventory inv = new Inventory(p1, 23);

        /**
         * This is the manager for the StoreView
         */
        StoreManager manager = new StoreManager(inv);

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

                    System.out.println("\\----------------------BROWSE------------------------/\n");

                    System.out.println("STOCK  |  PRODUCT NAME  |  UNIT PRICE ");

                    storeManager.brow();

                    System.out.print("\nGO TO ANOTHER STOREVIEW? (Y) >>> ");
                    String newStore = in.next().toUpperCase();

                    if (newStore.equals("Y")) {

                        storeView = new StoreView(manager, manager.assignNewCartID());
                    }

                    System.out.println("CART >>> " + cartID);

                } else if (command.equals("add")) {

                    System.out.println("\\-------------------------ADD------------------------/\n");
                    System.out.println("STOCK  |  PRODUCT NAME  |  UNIT PRICE  |  OPTION");

                    int count = 0;

                    String option = "";

                    int optChoice = 0;

                    //This loop just prints out the items in to store and
                    // adds the number assigned to the products into the store hashmap.
                    for (Product item : storeManager.getAllProducts().keySet()) {

                        System.out.println(storeManager.getStockAmount(item.getID()) + " | "
                                + storeManager.getSingleProduct(item.getID()).getName() + " | "
                                + storeManager.getSingleProduct(item.getID()).getPrice() + " | (" + count + ")");

                        store.put(count, item.getID());

                        count++;
                    }

                    while (!option.equals("quit")) {

                        System.out.println("\nPlease enter the option that you wish to add to your cart or enter quit:");
                        option = in.next();

                        boolean numeric = true;
                        int quantity = 0;

                        /**
                         * Down the line there are many variables which are used for the programming of the StoreView
                         *
                         * Try-catch checks if option is a number and if not, it sets numeric to false.
                         */
                        try {

                            optChoice = Integer.parseInt(option);
                        } catch (NumberFormatException e) {

                            numeric = false;
                        }

                        if (numeric == true) {

                            if (store.containsKey(optChoice)) {

                                if(storeManager.getStockAmount(store.get(optChoice)) > 0) {

                                    System.out.println("\nWe have " + storeManager.getStockAmount(store.get(optChoice)) + " " +
                                            storeManager.getSingleProduct(store.get(optChoice)).getName() + "(s) in store");

                                    System.out.print("How many " + storeManager.getSingleProduct(store.get(optChoice)).getName()
                                            + "(s) do you want - ");

                                    quantity = in.nextInt();

                                    if (quantity > 0) {

                                        if (quantity <= storeManager.getStockAmount(store.get(optChoice))) {

                                            //This line here calls the cart activity function and
                                            // tells it to add the product ID with the required quantity to the cart.
                                            storeManager.cartActivity(store.get(optChoice), quantity, "add");

                                            System.out.println("\nYour selection has been added.");
                                        } else {

                                            System.out.println("\nNot enough stock available.");
                                        }
                                    } else {

                                        System.out.println("\nPlease enter a quantity greater than 0.");
                                    }
                                }

                                else{

                                    System.out.println("\nSorry we are out of stock for " +
                                            storeManager.getSingleProduct(store.get(optChoice)).getName());
                                }

                            } else {

                                System.out.print("\nPlease enter the correct option\n");
                            }
                        } else if (!option.equals("quit")) {

                            System.out.println("\nPlease enter the correct option");
                        }
                    }
                } else if (command.equals("remove")) {

                    //This line of code only runs if cart is not empty.
                    if (cart.getCart().size() > 0) {

                        System.out.println("\\------------------------Remove----------------------/\n");
                        System.out.println("QUANTITY ADDED  |  PRODUCT NAME  |  UNIT PRICE  |  OPTION");

                        int count = 0;
                        String option = "";
                        int optChoice = 0;

                        //This loop just prints out the items in the cart and
                        // adds the number assigned to the products into the store hashmap.
                        for (int item : cart.getCart().keySet()) {

                            System.out.println(cart.getQuantity(item) + " | " + storeManager.getSingleProduct(item).getName()
                                    + " | " + storeManager.getSingleProduct(item).getPrice() + " | (" + count + ")");

                            store.put(count, item);

                            count++;
                        }

                        while (!option.equals("quit")) {

                            System.out.println("\nPlease enter the option that you wish to remove to your cart or enter quit:");
                            option = in.next();

                            boolean numeric = true;

                            try {

                                optChoice = Integer.parseInt(option);
                            } catch (NumberFormatException e) {

                                numeric = false;
                            }

                            if (numeric == true) {

                                if (store.containsKey(optChoice)) {

                                    if(cart.getQuantity(store.get(optChoice)) > 0) {

                                        System.out.println("\nYou have added " + cart.getQuantity(store.get(optChoice)) + " "
                                                + storeManager.getSingleProduct(store.get(optChoice)).getName() + "(s)");

                                        System.out.print("How many " + storeManager.getSingleProduct(store.get(optChoice)).getName()
                                                + "(s) do you want to remove - ");
                                        int quantity = in.nextInt();

                                        if (quantity > 0) {

                                            if (quantity <= cart.getQuantity(store.get(optChoice))) {

                                                storeManager.cartActivity(store.get(optChoice), quantity, "remove");

                                                System.out.println("\nYour selection has been removed.");
                                            } else {

                                                System.out.println("\nInvalid quantity input.");
                                            }
                                        } else {

                                            System.out.println("\nPlease enter a quantity greater than 0.");
                                        }
                                    }

                                    else{

                                        System.out.println("\nInvalid selection input");
                                    }
                                }
                                else {

                                    System.out.print("\nPlease enter the correct option\n");
                                }
                            } else if (!option.equals("quit")) {

                                System.out.println("\nPlease enter the correct option");
                            }
                        }
                    } else {

                        System.out.println("\nYour cart  is empty.");
                    }
                } else if (command.equals("checkout")) {

                    if (cart.getCart().size() > 0) {

                        System.out.println("\\----------------------CHECKOUT----------------------/\n");
                        System.out.println("\nThe total price for the items in the cart: "
                                + storeManager.doTransaction(cart) + "$");

                        break;
                    } else {

                        System.out.println("\nYour cart is empty for checkout.");
                    }
                } else if (!command.equals("quit")) {

                    System.out.println("\nPlease enter the correct command.");
                }
            }

            System.out.println("\nThanks for shopping.\n");

            if (cart.getCart().size() > 0 && command.equals("quit")) {

                /**
                 * This calls the storeManager method called quit which gets triggered if the person types quit.
                 * It simply takes all the products from the cart back to the inventory.
                 */
                storeManager.quit(cart, cartID);
            }

            command = "";

            storeView = new StoreView(manager, manager.getCartID());
        }
    }
    }
}
