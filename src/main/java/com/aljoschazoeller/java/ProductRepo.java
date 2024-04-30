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

    public void removeProduct(UUID idToRemove) {
        boolean isRemoved = products.removeIf(product -> product.id().equals(idToRemove));
        if (isRemoved) {
            System.out.println("Removed product with ID " + idToRemove);
        } else {
            System.out.println("Product with ID " + idToRemove + " not found.");
            throw new IllegalArgumentException("Could not remove order with ID " + idToRemove);
        }
    }

    public Product getProduct(UUID idToGet) {
        for (Product product : products) {
            if (product.id().equals(idToGet)) {
                return product;
            }

        }
        throw new IllegalArgumentException("Could not find product with ID " + idToGet);
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
