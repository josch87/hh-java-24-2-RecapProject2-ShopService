package com.aljoschazoeller.java;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderListRepo {
    private List<Order> orders = new ArrayList<>();

    public Order addOrder(String customer, List<Product> products) {
        Order newOrder = new Order(customer, products);
        orders.add(newOrder);
        System.out.println("Placed new order with UUID " + newOrder.uuid());
        return newOrder;
    }

    public void removeOrder(UUID uuidToRemove) {
        boolean isRemoved = orders.removeIf(order -> order.uuid().equals(uuidToRemove));
        if (isRemoved) {
            System.out.println("Removed order with UUID " + uuidToRemove);
        } else {
            System.out.println("Order with UUID " + uuidToRemove + " not found.");
            throw new RuntimeException("Could not remove order with UUID " + uuidToRemove);
        }
    }

    public Order getOrder(UUID uuidToGet) {
        for (Order order : orders) {
            if (order.uuid().equals(uuidToGet)) {
                return order;
            }
        }
        throw new RuntimeException(("Could not find order with UUID " + uuidToGet));
    }
}
