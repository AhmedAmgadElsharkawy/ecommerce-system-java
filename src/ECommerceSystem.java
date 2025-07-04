import java.time.LocalDate;

import models.cart.Cart;
import models.products.Cheese;
import models.products.MobileScratchCard;
import models.products.TV;
import models.products.interfaces.Product;
import models.store.Store;
import models.user.Customer;
import services.ShippingServices.StandardShipping;
import services.checkoutServices.CheckoutService;;

public class ECommerceSystem {
    public static void main(String[] args) {
        Store store = new Store();
        
        Product cheddarCheese = new Cheese("Cheddar Cheese", 5, 20, 1, LocalDate.of(2025, 1, 1), "cc11");
        Product samsungTV = new TV("Samsung TV", 50, 1500, 5.0, "stv21");
        Product toshibaTV = new TV("Toshiba TV", 1, 1000, 7.0, "ttv21");
        Product fetaCheese = new Cheese("Feta Cheese", 10, 30, 0.6, LocalDate.of(2025, 12, 1), "fc11");
        Product mobileScrachCards = new MobileScratchCard("Mobile Scratch Card", 200, 5, "msc5");
        
        store.addProduct(cheddarCheese);
        store.addProduct(fetaCheese);
        store.addProduct(samsungTV);
        store.addProduct(toshibaTV);
        store.addProduct(mobileScrachCards);

        Customer customer = new Customer("Ahmed", 1000);

        Cart cart = new Cart();

        // test of adding expired item 
        System.err.println("### Expired Item Test ###");
        cart.add(store.findByCode("cc11"), 2);
        System.err.println();

        // test of not enough item stock in the inventory 
        System.err.println("### Not Enough Item Stock Test ###");
        cart.add(store.findByCode("ttv21"), 2);
        System.err.println();

        // test not enough customer balance
        System.err.println("### Not Enough Customer Balance Test ###");
        cart.add(store.findByCode("fc11"), 3);
        cart.add(store.findByCode("stv21"), 1);
        CheckoutService.checkout(customer, cart, new StandardShipping());
        System.err.println();
        
        cart.clear();

        System.err.println("### Successful Checkout Test ###");
        customer.setBalcance(10000);

        cart.add(store.findByCode("fc11"), 4);
        cart.add(store.findByCode("stv21"), 2);
        cart.add(store.findByCode("ttv21"), 1);
        cart.add(store.findByCode("msc5"), 12);

        CheckoutService.checkout(customer, cart, new StandardShipping());
    }
}
