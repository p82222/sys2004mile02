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
    private ArrayList<Product> cartItem;
    private Inventory inv = new Inventory();

    /**
     * Creates a new Product with the supplied attributes.
     */
    public ShoppingCart() {
        this.totalPrice = 0;
        this.cartItem = new ArrayList<Product>();
    }

    /**
     * Adds product to cart
     * @param newProduct
     */
    public void addToCart(Product newProduct){

        if(cartItem.contains(newProduct)){
            int id = newProduct.getId();
            newProduct.removeQuantity(id);
        }else{
            cartItem.add(newProduct);
            int id = newProduct.getId();
            newProduct.removeQuantity(id);
        }

        totalPrice += newProduct.price * inv.quantity;
    }

    /**
     * Removes product from cart
     * @param oldProduct
     */
    public void removeFromCart(Product oldProduct){

        if(!cartItem.contains(oldProduct)){
            return;
        }
        else{
            cartItem.remove(oldProduct);
            int id = oldProduct.getId();
            oldProduct.removeQuantity(id);
        }
        totalPrice -= oldProduct.price * inv.quantity;
    }


    /**
     * @return all items in the cart as array
     */
    public ShoppingCart[] getProducts(){

        ShoppingCart[] productArray = new ShoppingCart [cartItem.size()];
        cartItem.toArray(productArray);
        return productArray;
    }

    public ArrayList<Product> getCartItem(){
        return cartItem;
    }

    public double getTotalPrice(){
        return totalPrice;
    }






}
