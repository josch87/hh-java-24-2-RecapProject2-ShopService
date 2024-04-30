package com.aljoschazoeller.java;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderListRepo implements OrderRepo {
    private List<Order> orders = new ArrayList<>();

    @Override
    public Order addOrder(String customer, List<Product> products) {
        Order newOrder = new Order(customer, products);
        orders.add(newOrder);
        System.out.println("Placed new order with UUID " + newOrder.uuid() + " in list of OrderListRepo.");
        return newOrder;
    }

    @Override
    public void removeOrder(UUID uuidToRemove) {
        boolean isRemoved = orders.removeIf(order -> order.uuid().equals(uuidToRemove));
        if (isRemoved) {
            System.out.println("Removed order with UUID " + uuidToRemove + " from list of OrderListRepo.");
        } else {
            System.out.println("Order with UUID " + uuidToRemove + " not found in list of OrderListRepo.");
            throw new IllegalArgumentException("Order with UUID " + uuidToRemove + " not found in list of OrderListRepo.");
        }
    }

    @Override
    public Order getOrder(UUID uuidToGet) {
        for (Order order : orders) {
            if (order.uuid().equals(uuidToGet)) {
                return order;
            }
        }
        System.out.println("Could not find order with UUID \" + uuidToGet + \" in list of OrderListRepo.");
        throw new IllegalArgumentException(("Could not find order with UUID " + uuidToGet + " in list of OrderListRepo."));
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }
}
