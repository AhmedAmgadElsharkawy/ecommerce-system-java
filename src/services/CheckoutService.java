package services;

import models.Customer;
import models.Shippable;
import services.ShippingServices.ShippingService;

import java.util.List;

import models.Cart;
import models.CartItem;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart, ShippingService shippingService) {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty!");
            return;
        }

        List<Shippable> shippables = cart.getShippableItems();
        double subtotal = cart.getSubtotal();

        double shippingFees = shippingService.calculateShippingFee(shippables);
        double total = subtotal + shippingFees;

        if (customer.getBalance() < total) {
            System.out.println("Customer Balance: " + customer.getBalance() + " is not enough!");
            return;
        }

        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        if (!shippables.isEmpty())
            ShippingService.ship(cart.getItems());

        customer.deductBalance(total);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal " + subtotal);
        System.out.println("Shipping " + shippingFees);
        System.out.println("Amount " + total);
        System.out.println("Customer balance after payment: " + customer.getBalance());

        cart.clear();
    }

}

