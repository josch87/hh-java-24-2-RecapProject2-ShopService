package com.aljoschazoeller.java;

import com.aljoschazoeller.java.utility.OrderHelper;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record Order(UUID id, String customer, List<Product> products, BigDecimal totalPrice, Instant orderedAt,
                    Instant shippedAt) {

    public Order(String customer, List<Product> products) {
        this(UUID.randomUUID(), customer, products, OrderHelper.calculateTotalPrice(products), Instant.now(), null);
    }


}
