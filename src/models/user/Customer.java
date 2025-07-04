package models.user;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalcance(double balance){
        this.balance = balance;
    }

    public void setName(String name){
        this.name = name;
    }

    public void deductBalance(double amount) {
        if (balance < amount) throw new IllegalStateException("Insufficient balance.");
        balance -= amount;
    }
}