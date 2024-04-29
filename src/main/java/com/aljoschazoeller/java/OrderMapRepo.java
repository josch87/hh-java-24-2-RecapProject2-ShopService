package com.aljoschazoeller.java;

import java.util.*;

public class OrderMapRepo implements OrderRepo {
    private Map<UUID, Order> orders = new HashMap<>();

    @Override
    public Order addOrder(String customer, List<Product> products) {
        Order newOrder = new Order(customer, products);
        orders.put(newOrder.uuid(), newOrder);
        System.out.println("Placed new order with UUID " + newOrder.uuid() + " in map.");
        return newOrder;
    }

    @Override
    public void removeOrder(UUID uuidToRemove) {
        Order removedOrder = orders.remove(uuidToRemove);
        if (removedOrder != null) {
            System.out.println("Removed order with UUID " + uuidToRemove + " from map.");
        } else {
            System.out.println("Order with UUID " + uuidToRemove + " not found in map.");
            throw new IllegalArgumentException("Could not remove order with UUID " + uuidToRemove);
        }
    }

    @Override
    public Order getOrder(UUID uuidToGet) {
        Order order = orders.get(uuidToGet);

        if (order != null) {
            return order;
        } else {
            throw new IllegalArgumentException("Could not find order with UUID " + uuidToGet + " in map.");
        }
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }
}
