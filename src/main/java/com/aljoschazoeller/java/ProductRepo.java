package com.aljoschazoeller.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductRepo {
    List<Product> products = new ArrayList<>();

    public Product addProduct(String name, BigDecimal price) {
        Product newProduct = new Product(name, price);
        products.add(newProduct);
        System.out.println("Added new product \"" + name + "\" to the products.");
        return newProduct;
    }

    public void removeProduct(UUID uuidToRemove) {
        boolean isRemoved = products.removeIf(product -> product.id().equals(uuidToRemove));
        if (isRemoved) {
            System.out.println("Removed product with UUID " + uuidToRemove);
        } else {
            System.out.println("Product with UUID " + uuidToRemove + " not found.");
            throw new IllegalArgumentException("Could not remove order with UUID " + uuidToRemove);
        }
    }

    public Product getProduct(UUID uuidToGet) {
        for (Product product : products) {
            if (product.id().equals(uuidToGet)) {
                return product;
            }

        }
        throw new IllegalArgumentException("Could not find product with UUID " + uuidToGet);
    }

    public List<Product> getProducts() {
        return products;
    }


    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}
