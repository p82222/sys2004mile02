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
    private HashMap<Integer, Integer> items;
    private Inventory inv = new Inventory();

    /**
     * Creates a new Product with the supplied attributes.
     */
    public ShoppingCart() {
        this.totalPrice = 0;
        this.items = new HashMap<Integer, Integer>();
    }

    /**
     * Adds product to cart
     * @param newProduct
     */
    //worked, tested
    public void addToCart(int productID, int quantity){
        items.put(productID,quantity);

    }

    /**
     * Removes product from cart
     * @param oldProduct
     */

    public void removeFromCart(int productID, int quantity){
        // check if cart has the product by checking productID
        if(items.containsKey(productID)){
            //remove the item by quantity
            if(items.get(productID) >= quantity ){
                items.put(productID, items.get(productID) - quantity);

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
    //worked, tested
    public HashMap<Integer, Integer> getItems(){

        return items;
    }








}
