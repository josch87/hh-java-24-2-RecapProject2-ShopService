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
        System.out.println("Placed new order with ID " + newOrder.id() + " in list of OrderListRepo.");
        return newOrder;
    }

    @Override
    public void removeOrder(UUID idToRemove) {
        boolean isRemoved = orders.removeIf(order -> order.id().equals(idToRemove));
        if (isRemoved) {
            System.out.println("Removed order with ID " + idToRemove + " from list of OrderListRepo.");
        } else {
            System.out.println("Order with ID " + idToRemove + " not found in list of OrderListRepo.");
            throw new IllegalArgumentException("Order with ID " + idToRemove + " not found in list of OrderListRepo.");
        }
    }

    @Override
    public Order getOrder(UUID idToGet) {
        for (Order order : orders) {
            if (order.id().equals(idToGet)) {
                return order;
            }
        }
        System.out.println("Could not find order with ID \" + idToGet + \" in list of OrderListRepo.");
        throw new IllegalArgumentException(("Could not find order with ID " + idToGet + " in list of OrderListRepo."));
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
