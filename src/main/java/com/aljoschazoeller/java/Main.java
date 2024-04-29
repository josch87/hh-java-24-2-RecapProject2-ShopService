package com.aljoschazoeller.java;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct("Nivea Creme", new BigDecimal("9.95"));

        System.out.println(productRepo);
    }
}
