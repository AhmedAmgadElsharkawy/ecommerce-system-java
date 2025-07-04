package models.store;

import java.util.ArrayList;
import java.util.List;

import models.products.interfaces.Product;

public class Store {
    private List<Product> inventory = new ArrayList<>();

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public Product findByCode(String code) {
        for (Product product : inventory) {
            if (product.getCode().equals(code)) {
                return product;
            }
        }
        return null;
    }
}
