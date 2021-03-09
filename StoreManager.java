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

    /**
     * Constructor for StoreManager
     */
    public StoreManager(){
        this.inventory = null;
        this.shoppingCarts = new HashMap<Integer, ShoppingCart>();
    }

    /**
     * Accessor for ShoppingCart
     * @return newCart
     */
    public ShoppingCart getShoppingCart(){
        return newCart;
    }

    /**
     * Constructor for StoreManager
     * @param inventory
     */
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
    public double processTransaction(ShoppingCart cart){
        double total = 0;

        if(cart.getCartItem().size() == 0){
            return 0;
        }
        else{
            total = cart.getTotalPrice();
            System.out.println("Total = " + total);
        }
        return total;
    }

    /**
     * Creates new cartID
     * @return cartID int
     */
    public int assignNewCartID(){
        ShoppingCart newCart = new ShoppingCart();
        cartID = shoppingCarts.size();
        shoppingCarts.put(cartID-1, newCart);
        return cartID;
    }

    /**
     * Adds product to cart
     * @param product
     */
    public void addToCart(Product product){
        if(products.containsKey(product)){
            this.newCart.addToCart(product);
        }
    }

    /**
     * Lets user quit store and puts products back into inventory 
     * @param cardID
     */
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

    /**
     * Lets user browse inventory
     */
    public void browse(){
        System.out.println("STOCK  |  PRODUCT NAME  |  UNIT PRICE  |  OPTION");
        for (Product item : this.inventory.getProducts().keySet()) {

            System.out.println(item.getQuantity() + " | "
                    + item.getName() + " | "
                    + item.getPrice());
        }

    }

    /**
     * Find specified product in inventory
     * @param name
     * @return findProduct
     */
    public Product findProduct(String name){
        Product find = new Product();
        for (Product item : this.inventory.getProducts().keySet()){
            if(item.getName().equals(name)){
                find = item;
            }
        }
        return find;
    }

    /**
     * Removes product from cart
     * @param product
     */
    public void removeFromCart(Product product){
        if(products.containsKey(product)){
            this.newCart.removeFromCart(product);
        }
    }

    /**
     * Accessor for CartID
     * @return cartID int
     */
    public int getCartID(){
        return cartID;
    }
}
