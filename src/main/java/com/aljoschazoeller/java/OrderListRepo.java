package com.aljoschazoeller.java;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderListRepo implements OrderRepo {
    private List<Order> orders = new ArrayList<>();

    @Override
    public Order addOrder(String customer, ProductRepo products) {
        Order newOrder = new Order(customer, products);
        orders.add(newOrder);
        System.out.println("Placed new order with UUID " + newOrder.uuid() + " in list.");
        return newOrder;
    }

    @Override
    public void removeOrder(UUID uuidToRemove) {
        boolean isRemoved = orders.removeIf(order -> order.uuid().equals(uuidToRemove));
        if (isRemoved) {
            System.out.println("Removed order with UUID " + uuidToRemove + " from list.");
        } else {
            System.out.println("Order with UUID " + uuidToRemove + " not found in list.");
            throw new IllegalArgumentException("Could not remove order with UUID " + uuidToRemove);
        }
    }

    @Override
    public Order getOrder(UUID uuidToGet) {
        for (Order order : orders) {
            if (order.uuid().equals(uuidToGet)) {
                return order;
            }
        }
        throw new IllegalArgumentException(("Could not find order with UUID " + uuidToGet + " in list."));
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
