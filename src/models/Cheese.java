package models;

import java.time.LocalDate;

public class Cheese extends Product implements Expirable, Shippable {
    LocalDate expiryDate;
    double weight;

    public Cheese(String name, int quantity, double price, double weight, LocalDate expiryDate) {
        super(name, quantity, price);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    @Override
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
