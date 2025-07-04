package models;

public class TV extends Product implements Shippable{
    private double weight;

    public TV(String name, int quantity, double price, double weight) {
        super(name, quantity, price);
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
