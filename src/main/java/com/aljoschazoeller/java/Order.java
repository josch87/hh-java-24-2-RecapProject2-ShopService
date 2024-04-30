package com.aljoschazoeller.java;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record Order(UUID uuid, String customer, List<Product> products, Instant orderedAt, Instant shippedAt) {
        public Order(String customer, List<Product> products) {
        this(UUID.randomUUID(), customer, products, Instant.now(), null);
    }
}
