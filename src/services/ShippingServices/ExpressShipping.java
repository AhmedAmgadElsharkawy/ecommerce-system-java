package services.ShippingServices;

import java.util.List;

import models.products.interfaces.Shippable;

public class ExpressShipping extends ShippingService{

    @Override
    public double calculateShippingFee(Shippable product) {
        return product.getWeight() * 10;
    }

    @Override
    public double calculateShippingFee(List<Shippable> items) {
        double sum = 0;
        for(Shippable item : items){
            sum += calculateShippingFee(item);
        }
        return sum;
    }
}
