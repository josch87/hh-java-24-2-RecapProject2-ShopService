package com.aljoschazoeller.java;

import java.util.List;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public void placeNewOrder(String customer, ProductRepo products) {

        List<Product> availableProducts = this.productRepo.getProducts();
        for (Product product : products.getProducts()) {
            if (!availableProducts.contains(product)) {
                System.out.println("Product not available");
                throw new IllegalArgumentException("Product \"" + product.name() + "\" is not available");
            }
        }
        orderRepo.addOrder(customer, products);
    }

    public ShopService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderRepo=" + orderRepo +
                '}';
    }
}
