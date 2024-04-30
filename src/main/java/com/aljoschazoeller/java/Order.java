package com.aljoschazoeller.java;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record Order(UUID uuid, String customer, ProductRepo products, Instant orderedAt, Instant shippedAt) {
        public Order(String customer, ProductRepo products) {
        this(UUID.randomUUID(), customer, products, Instant.now(), null);
    }
}
