package models.products.interfaces;

public abstract class Product {
    private String name;
    private int quantity;
    private double price;
    private String code;

    public Product(String name, int quantity, double price, String code) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getCode(){
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void reduceQuantity(int reducedQuantity) {
        this.quantity = this.quantity - reducedQuantity;
    }
}
