package com.aljoschazoeller.java;

import java.util.*;

public class OrderMapRepo implements OrderRepo {
    private Map<UUID, Order> orders = new HashMap<>();

    @Override
    public Order addOrder(String customer, List<Product> products) {
        Order newOrder = new Order(customer, products);
        orders.put(newOrder.uuid(), newOrder);
        System.out.println("Placed new order with UUID " + newOrder.uuid() + " in map of OrderMapRepo.");
        return newOrder;
    }

    @Override
    public void removeOrder(UUID uuidToRemove) {
        Order removedOrder = orders.remove(uuidToRemove);
        if (removedOrder != null) {
            System.out.println("Removed order with UUID " + uuidToRemove + " from map of OrderMapRepo.");
        } else {
            System.out.println("Order with UUID " + uuidToRemove + " not found in map of OrderMapRepo.");
            throw new IllegalArgumentException("Order with UUID " + uuidToRemove + " not found in map of OrderMapRepo.");
        }
    }

    @Override
    public Order getOrder(UUID uuidToGet) {
        Order order = orders.get(uuidToGet);

        if (order != null) {
            return order;
        } else {
            System.out.println("Could not find order with UUID " + uuidToGet + " in map of OrderMapRepo.");
            throw new IllegalArgumentException("Could not find order with UUID " + uuidToGet + " in map of OrderMapRepo.");
        }
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orders=" + orders +
                '}';
    }
}
