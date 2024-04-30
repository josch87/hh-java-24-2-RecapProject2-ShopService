package com.aljoschazoeller.java;

import java.math.BigDecimal;
import java.util.List;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public ShopService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Product addProductToWarehouse(String name, BigDecimal price) {
        return productRepo.addProduct(name, price);
    }

    public void placeNewOrder(String customer, List<Product> products) {

        List<Product> availableProducts = this.productRepo.getProducts();
        for (Product product : products) {
            if (!availableProducts.contains(product)) {
                System.out.println("Product \"" + product.name() + "\" is not available");
                throw new IllegalArgumentException("Product \"" + product.name() + "\" is not available");
            }
        }
        orderRepo.addOrder(customer, products);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderRepo=" + orderRepo +
                '}';
    }
}
