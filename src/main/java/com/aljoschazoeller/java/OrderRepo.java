package com.aljoschazoeller.java;

import java.util.List;
import java.util.UUID;

public interface OrderRepo {
    public Order addOrder(String customer, List<Product> products);
    public void removeOrder (UUID idToRemove);
    public Order getOrder(UUID idToGet);
    public List<Order> getOrders();
}
