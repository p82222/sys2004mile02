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
    private ArrayList<ShoppingCart> cartItem;
    protected Inventory inv = new Inventory();

    /**
     * Creates a new Product with the supplied attributes.
     */
    public ShoppingCart() {
        this.totalPrice = 0;
        this.cartItem = new ArrayList<ShoppingCart>();
    }

    /**
     * Adds product to cart
     * @param newProduct
     */
    public void addToCart(ShoppingCart newProduct){

<<<<<<< HEAD
        if (cartItem.contains(newProduct)){
            int id = newProduct.getId();
            this.removeQuantity(id);
        }else{
=======
        //see if product is repetitive
        int currIndex = cartItem.indexOf(newProduct);

        //if its a new product add to cart
        if(currIndex == -1){
>>>>>>> 5adddf5628f7c5094a30a231bab221733bc10643
            cartItem.add(newProduct);
            int id = newProduct.getId();
            this.removeQuantity(id);
        }
<<<<<<< HEAD

=======
        //if similar products add to quantity
        else{
            ShoppingCart currItem = (ShoppingCart) cartItem.get(currIndex);
            currItem.add(newProduct);
        }
        //sum total price with quantity of product and that products price
>>>>>>> 5adddf5628f7c5094a30a231bab221733bc10643
        totalPrice += newProduct.price * newProduct.quantity;
    }

    /**
     * Removes product from cart
     * @param oldProduct
     */
    public void removeFromCart(ShoppingCart oldProduct){

        //find product in cart
        int currIndex = cartItem.indexOf(oldProduct);

        //if no product just return same cart
        if(currIndex == -1){
            return;
        }

        else{
            ShoppingCart currItem = (ShoppingCart) cartItem.get(currIndex);
            currItem.add(oldProduct);
        }

        //subtract the removed products price from total price
        if(oldProduct.quantity > Inventory.currItem.quantity){
            oldProduct.quantity = currItem.quantity;
        }

        //if product quantity = 0, remove product from cart
        if(currItem.quantity == 0){
            cartItem.remove(currIndex);
        }
        totalPrice -= oldProduct.price * oldProduct.inv.quantity;
        currItem.subtract(oldProduct);
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
