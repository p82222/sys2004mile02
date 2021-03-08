//STUDENT NAME: Chia-Yu Liu
//STUDENT ID: 100698737
//STUDENT NAME: Keefer Belanger
//STUDENT ID: 101152085


import java.util.HashMap;


public class StoreManager {

    private HashMap<Product, Integer> products = new HashMap<Product, Integer>();

    /**
     * Creates a new inventory
     */
    private Inventory inventory = new Inventory();

    private HashMap<Integer,ShoppingCart> shoppingCarts;

    private int cartID;

    private ShoppingCart newCart = new ShoppingCart();

    public StoreManager(){
        this.inventory = null;
        this.shoppingCarts = new HashMap<Integer, ShoppingCart>();
    }

    public StoreManager(Inventory inventory){
        this.inventory = inventory;
    }

    /**
     * Check how much stock of a given product is in the inventory
     */
    public void checkStock(int id){
        int stock;
        stock = inventory.getQuantity(id);
        System.out.println("Stock is " +stock);
    }

    /**
     * Checks the quantity exists and if it does processes the transaction
     */
    public void processTransaction(int cart[][]){
        float total = 0;
        boolean success = true;
        for(int[] i : cart) {
            if (inventory.getQuantity(i[0]) >= i[1]) {
                total += inventory.getProductInfo(i[0]).getPrice() * i[1];
                inventory.removeQuantity(i[0]);
            } else {
                success = false;
                break;
            }
        }
        if(!success){
            System.out.println("Transaction Failed");
        }
        else{
            System.out.println("Total = " +total);
        }
    }

    public int assignNewCartID(){
        ShoppingCart newCart = new ShoppingCart();
        cartID = shoppingCarts.size();
        shoppingCarts.put(cartID-1, newCart);
        return cartID;
    }

    public void addToCart(Product product){
            this.newCart.addToCart(product);
    }

    public double checkout(int cardID){
        double total = 0;
        if (shoppingCarts.containsKey(cardID)) {
            ShoppingCart newCart = new ShoppingCart();
            newCart = shoppingCarts.get(cardID);
            for (Product p : newCart.getCartItem()) {
                total = total + p.getPrice();
            }

        }else{
            System.out.println("Shopping Cart not exist.");
        }
        return total;

    }

    public void quit(int cardID){
        if (shoppingCarts.containsKey(cardID)) {
            ShoppingCart newCart = new ShoppingCart();
            newCart = shoppingCarts.get(cardID);
            for (Product p : newCart.getCartItem()) {
                p.addQuantity(p.getId());
            }
            shoppingCarts.put(cardID, null);

        }else{
            System.out.println("Shopping Cart not exist.");
        }


    }



}
