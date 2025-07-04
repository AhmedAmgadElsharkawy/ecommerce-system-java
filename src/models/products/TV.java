package models.products;

import models.products.interfaces.Product;
import models.products.interfaces.Shippable;

public class TV extends Product implements Shippable{
    private double weight;

    public TV(String name, int quantity, double price, double weight, String code) {
        super(name, quantity, price, code);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
}
