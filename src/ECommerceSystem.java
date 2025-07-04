import java.time.LocalDate;

import models.Cart;
import models.Cheese;
import models.Customer;
import models.Product;
import models.Store;
import models.TV;
import services.CheckoutService;
import services.ShippingServices.StandardShipping;;

public class ECommerceSystem {
    public static void main(String[] args) {
        Store store = new Store();
        
        Product cheddarCheese = new Cheese("Cheddar Cheese", 5, 20, 1, LocalDate.of(2025, 1, 1), "cc11");
        Product samsungTV = new TV("Samsung TV", 50, 1500, 5.0, "stv21");
        Product toshibaTV = new TV("Toshiba TV", 1, 1000, 7.0, "ttv21");
        Product fetaCheese = new Cheese("Feta Cheese", 10, 30, 0.6, LocalDate.of(2025, 12, 1), "fc11");
        
        store.addProduct(cheddarCheese);
        store.addProduct(fetaCheese);
        store.addProduct(samsungTV);
        store.addProduct(toshibaTV);

        Customer customer = new Customer("Ahmed", 1000);

        Cart cart = new Cart();

        // test of adding expired item 
        cart.add(store.findByCode("cc11"), 2);
        // test of not enough item stock in the inventory 
        cart.add(store.findByCode("ttv21"), 2);

        // test not enough customer balance
        cart.add(store.findByCode("fc11"), 3);
        cart.add(store.findByCode("stv21"), 1);
        CheckoutService.checkout(customer, cart, new StandardShipping());
        
        cart.clear();

        customer.setBalcance(10000);

        cart.add(store.findByCode("fc11"), 4);
        cart.add(store.findByCode("stv21"), 2);
        cart.add(store.findByCode("ttv21"), 1);

        CheckoutService.checkout(customer, cart, new StandardShipping());
    }
}
