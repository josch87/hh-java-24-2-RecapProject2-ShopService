package com.aljoschazoeller.java;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

//        ProductRepo productRepo = new ProductRepo();
//
//        System.out.println("All products: " + productRepo.getProducts());
//
//        Product nivea = productRepo.addProduct("Nivea Creme", new BigDecimal("9.95"));
//        Product smoothie = productRepo.addProduct("Smoothie (Apfel, Mango, Maracuja)", new BigDecimal("0.65"));
//        Product shampoo = productRepo.addProduct("Shampoo & Spülung Twinpack Sunny Side", new BigDecimal("1.55"));
//
//        System.out.println("productRepo: " + productRepo);
//        System.out.println("nivea: " + nivea);
//
//        productRepo.removeProduct(smoothie.id());
//        System.out.println("productRepo: " + productRepo);
//
//        Product nivea2 = productRepo.getProduct(nivea.id());
//        System.out.println("nivea2: " + nivea2);
//
//        System.out.println("All products: " + productRepo.getProducts());

        ProductRepo myProducts = new ProductRepo();
        myProducts.addProduct("Nivea Creme", new BigDecimal("9.95"));
        myProducts.addProduct("Smoothie (Apfel, Mango, Maracuja)", new BigDecimal("0.65"));
        myProducts.addProduct("Shampoo & Spülung Twinpack Sunny Side", new BigDecimal("1.55"));

        OrderRepo orderListRepo = new OrderListRepo();
        OrderRepo orderMapRepo = new OrderMapRepo();

        ShopService myListShop = new ShopService(orderListRepo);
        ShopService myMapShop = new ShopService(orderMapRepo);

        System.out.println("myListShop: " + myListShop);
        System.out.println("myMapShop: " + myMapShop);

        myListShop.placeNewOrder("Aljoscha Zöller", myProducts);

    }
}
