package com.aljoschazoeller.java;

import java.util.List;

public class ShopService {
    public void placeNewOrder(String customer, List<Product> products) {
        ProductRepo productRepo = new ProductRepo();
        List<Product> availableProducts = productRepo.getProducts();
        for (Product product : products) {
            if (!availableProducts.contains(product)) {
                System.out.println("Product not available");
                throw new IllegalArgumentException("Product \"" + product.name() + "\" is not available");
            }
        }

        OrderListRepo orderListRepo = new OrderListRepo();
        orderListRepo.addOrder(customer, products);
    }
}
