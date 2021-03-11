//STUDENT NAME: Chia-Yu Liu
//STUDENT ID: 100698737
//STUDENT NAME: Keefer Belanger
//STUDENT ID: 101152085

import java.util.*;

/**
 * Definition of shopping cart class
 */
public class ShoppingCart {

    private double totalPrice;
    private HashMap<Integer, Integer> cart;
    private Inventory inv = new Inventory();

    /**
     * Creates a new Product with the supplied attributes.
     */
    public ShoppingCart() {
        this.totalPrice = 0;
        this.cart = new HashMap<Integer, Integer>();
    }

    /**
     * Adds product to cart
     * @param newProduct
     */
    public void addToCart(int productID, int quantity){
        cart.put(productID,quantity);

    }

    /**
     * Removes product from cart
     * @param oldProduct
     */
    public void removeFromCart(int productID, int quantity){
        // check if cart has the product by checking productID
        if(cart.containsKey(productID)){
            //remove the item by quantity
            if(cart.get(productID) >= quantity ){
                cart.put(productID, cart.get(productID) - quantity);

            }else{
                System.out.println("not enough item in the cart.");
            }
        }
        else{
            System.out.println("item not existing in cart.");
        }
    }


    /**
     * @return all items in the cart as ArrayList
     */
    public HashMap<Integer, Integer> getCart(){

        return cart;
    }







}
