package com.aljoschazoeller.java.utility;

import com.aljoschazoeller.java.Product;

import java.math.BigDecimal;
import java.util.List;

public class OrderHelper {

    public static BigDecimal calculateTotalPrice(List<Product> products) {
        BigDecimal calculatedPrice = BigDecimal.ZERO;
        for (Product product : products) {
            calculatedPrice = calculatedPrice.add(product.price());
        }
        return calculatedPrice;
    }
}
