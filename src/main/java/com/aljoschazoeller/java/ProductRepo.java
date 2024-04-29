package com.aljoschazoeller.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    List<Product> products = new ArrayList<>();

    public void addProduct(String name, BigDecimal price) {
        Product newProduct = new Product(name, price);
        products.add(newProduct);
        System.out.println("Added new product \"" + name + "\" to the products.");
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}
