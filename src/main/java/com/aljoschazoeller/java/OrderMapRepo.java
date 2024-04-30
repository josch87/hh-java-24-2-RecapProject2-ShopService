package com.aljoschazoeller.java;

import java.util.*;

public class OrderMapRepo implements OrderRepo {
    private Map<UUID, Order> orders = new HashMap<>();

    @Override
    public Order addOrder(String customer, List<Product> products) {
        Order newOrder = new Order(customer, products);
        orders.put(newOrder.id(), newOrder);
        System.out.println("Placed new order with ID " + newOrder.id() + " in map of OrderMapRepo.");
        return newOrder;
    }

    @Override
    public void removeOrder(UUID idToRemove) {
        Order removedOrder = orders.remove(idToRemove);
        if (removedOrder != null) {
            System.out.println("Removed order with ID " + idToRemove + " from map of OrderMapRepo.");
        } else {
            System.out.println("Order with ID " + idToRemove + " not found in map of OrderMapRepo.");
            throw new IllegalArgumentException("Order with ID " + idToRemove + " not found in map of OrderMapRepo.");
        }
    }

    @Override
    public Order getOrder(UUID idToGet) {
        Order order = orders.get(idToGet);

        if (order != null) {
            return order;
        } else {
            System.out.println("Could not find order with ID " + idToGet + " in map of OrderMapRepo.");
            throw new IllegalArgumentException("Could not find order with ID " + idToGet + " in map of OrderMapRepo.");
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
