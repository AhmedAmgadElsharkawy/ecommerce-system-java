package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product == null)
            return;
        if (quantity > product.getQuantity()) {
            System.out.println(
                    "Not enough stock for " + product.getName() + ", the available quantity: " + product.getQuantity());
            return;
        }
        if (product instanceof Expirable && ((Expirable) product).isExpired()) {
            System.out.println(product.getName() + " is expired.");
            return;
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (CartItem cartItem : this.items) {
            subtotal += cartItem.getQuantity() * cartItem.getProduct().getPrice();
        }
        return subtotal;
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : items) {
            if (item.getProduct() instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippables.add((Shippable) item.getProduct());
                }
            }
        }
        return shippables;
    }

    public void clear() {
        items.clear();
    }
}
