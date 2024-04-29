package com.aljoschazoeller.java;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepo();

        System.out.println("All products: " + productRepo.getProducts());

        Product nivea = productRepo.addProduct("Nivea Creme", new BigDecimal("9.95"));
        Product smoothie = productRepo.addProduct("Smoothie (Apfel, Mango, Maracuja)", new BigDecimal("0.65"));
        Product shampoo = productRepo.addProduct("Shampoo & Spülung Twinpack Sunny Side", new BigDecimal("1.55"));

        System.out.println("productRepo: " + productRepo);
        System.out.println("nivea: " + nivea);

        productRepo.removeProduct(smoothie.id());
        System.out.println("productRepo: " + productRepo);

        Product nivea2 = productRepo.getProduct(nivea.id());
        System.out.println("nivea2: " + nivea2);

        System.out.println("All products: " + productRepo.getProducts());
    }
}
