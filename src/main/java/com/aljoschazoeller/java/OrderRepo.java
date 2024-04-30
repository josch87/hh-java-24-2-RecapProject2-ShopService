package com.aljoschazoeller.java;

import java.util.List;
import java.util.UUID;

public interface OrderRepo {
    public Order addOrder(String customer, ProductRepo products);
    public void removeOrder (UUID uuidToRemove);
    public Order getOrder(UUID uuidToGet);
    public List<Order> getOrders();
}
