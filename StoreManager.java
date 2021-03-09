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

    public ShoppingCart getShoppingCart(){
        return newCart;
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

    public int assignNewCartID(){
        ShoppingCart newCart = new ShoppingCart();
        cartID = shoppingCarts.size();
        shoppingCarts.put(cartID-1, newCart);
        return cartID;
    }

    public void addToCart(Product product){
        if(products.containsKey(product)){
            this.newCart.addToCart(product);
        }
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

    public void browse(){
        System.out.println("STOCK  |  PRODUCT NAME  |  UNIT PRICE  |  OPTION");
        for (Product item : this.inventory.getProducts().keySet()) {

            System.out.println(item.getQuantity() + " | "
                    + item.getName() + " | "
                    + item.getPrice());
        }

    }

    public Product findProduct(String name){
        Product find = new Product();
        for (Product item : this.inventory.getProducts().keySet()){
            if(item.getName().equals(name)){
                find = item;
            }
        }
        return find;
    }

    public void removeFromCart(Product product){
        if(products.containsKey(product)){
            this.newCart.removeFromCart(product);
        }
    }

    public int getCartID(){
        return cartID;
    }



}
