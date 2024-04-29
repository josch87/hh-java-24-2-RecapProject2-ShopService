package com.aljoschazoeller.java;

import java.util.List;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public void placeNewOrder(String customer, List<Product> products) {

        List<Product> availableProducts = productRepo.getProducts();
        for (Product product : products) {
            if (!availableProducts.contains(product)) {
                System.out.println("Product not available");
                throw new IllegalArgumentException("Product \"" + product.name() + "\" is not available");
            }
        }
        orderRepo.addOrder(customer, products);
    }
}
