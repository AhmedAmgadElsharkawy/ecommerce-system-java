package services.ShippingServices;

import java.util.List;

import models.Shippable;
import models.CartItem;

public abstract class ShippingService {
    abstract public double calculateShippingFee(Shippable product);

    abstract public double calculateShippingFee(List<Shippable> items);

    public static void ship(List<CartItem> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (CartItem item : items) {
            if (item.getProduct() instanceof Shippable) {
                double item_weight = ((Shippable) item.getProduct()).getWeight() * item.getQuantity();

                System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " "
                        + (item_weight * 1000) + "g");

                totalWeight += item_weight;
            }
        }
        System.out.println("Total package weight " + totalWeight + "kg");
    }
}