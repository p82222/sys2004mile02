//STUDENT NAME: Chia-Yu Liu
//STUDENT ID: 100698737
//STUDENT NAME: Keefer Belanger
//STUDENT ID: 101152085

import java.util.*;

/**
 * Definition of shopping cart class
 */
public class ShoppingCart extends Inventory{

    private double totalPrice;
    private ArrayList<Product> cartItem;

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

        if (cartItem.contains(newProduct)){
            int id = newProduct.getId();
            this.removeQuantity(id);
        }else{
            cartItem.add(newProduct);
            int id = newProduct.getId();
            this.removeQuantity(id);
        }

        totalPrice += newProduct.price * newProduct.quantity;
    }

    /**
     * Removes product from cart
     * @param oldProduct
     */
    public void removeFromCart(Product oldProduct){



        //find product in cart
        int currIndex = cartItem.indexOf(oldProduct);

        //if no product just return same cart
        if(currIndex == -1){
            return;
        }
        else{
            cartItem.remove(oldProduct);
            int id = oldProduct.getId();
            this.addQuantity(id);

        }
        /*
        //subtract the removed products price from total price
        if(oldProduct.quantity > Inventory.currItem.quantity){
            oldProduct.quantity = currItem.quantity;
        }

        //if product quantity = 0, remove product from cart
        if(currItem.quantity == 0){
            cartItem.remove(currIndex);
        }

         */


        totalPrice -= oldProduct.price * oldProduct.quantity;
        //currItem.subtract(oldProduct);
    }


    /**
     * @return all items in the cart as array
     */
    public ShoppingCart[] getProducts(){

        ShoppingCart[] productArray = new ShoppingCart [cartItem.size()];
        cartItem.toArray(productArray);
        return productArray;
    }
}
