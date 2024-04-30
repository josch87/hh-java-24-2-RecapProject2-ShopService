package com.aljoschazoeller.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

//        ProductRepo myWarehouseProducts = new ProductRepo();
//        myWarehouseProducts.addProduct("Nivea Creme", new BigDecimal("9.95"));
//        myWarehouseProducts.addProduct("Smoothie (Apfel, Mango, Maracuja)", new BigDecimal("0.65"));
//        myWarehouseProducts.addProduct("Shampoo & Spülung Twinpack Sunny Side", new BigDecimal("1.55"));
//        System.out.println("myWarehouseProducts: " + myWarehouseProducts);
//
//        ProductRepo rewe = new ProductRepo();
//        rewe.addProduct("Toilet Paper", new BigDecimal("3.99"));
//        rewe.addProduct("Hand Sanitizer", new BigDecimal("5.99"));
//        rewe.addProduct("Face Mask", new BigDecimal("1.99"));
//        System.out.println("Rewe: " + rewe);

        System.out.println("-------- myListShop --------");

        OrderRepo orderListRepo = new OrderListRepo();
        ShopService myListShop = new ShopService(orderListRepo);


        Product toiletPaper = myListShop.addProductToWarehouse("Toilet Paper", new BigDecimal("3.99"));
        Product faceMask = myListShop.addProductToWarehouse("Face Mask", new BigDecimal("1.99"));
        System.out.println("toiletPaper: " + toiletPaper);

        System.out.println("myListShop: " + myListShop);

        List<Product> aljoschasShoppingCard = new ArrayList<>();
        aljoschasShoppingCard.add(toiletPaper);
        aljoschasShoppingCard.add(toiletPaper);

        myListShop.placeNewOrder("Aljoscha Zöller", aljoschasShoppingCard);
        System.out.println("myListShop after first order: " + myListShop);


        System.out.println("-------- myMapShop --------");

        OrderRepo orderMapRepo = new OrderMapRepo();
        ShopService myMapShop = new ShopService(orderMapRepo);
        System.out.println("myMapShop: " + myMapShop);

        Product nivea = myMapShop.addProductToWarehouse("Nivea Creme", new BigDecimal("9.95"));
        Product smoothie = myMapShop.addProductToWarehouse("Smoothie (Apfel, Mango, Maracuja)", new BigDecimal("0.65"));
        Product shampoo = myMapShop.addProductToWarehouse("Shampoo & Spülung Twinpack Sunny Side", new BigDecimal("1.55"));
        System.out.println("myMapShop: " + myMapShop);

        List<Product> benjaminsShoppingCard = new ArrayList<>();
        benjaminsShoppingCard.add(shampoo);
        myMapShop.placeNewOrder("Benjamin Blümchen", benjaminsShoppingCard);

        List<Product> karlasShoppingCard = new ArrayList<>();
        karlasShoppingCard.add(nivea);
        karlasShoppingCard.add(shampoo);
        myMapShop.placeNewOrder("Karla Kolumna", karlasShoppingCard);

        System.out.println("myMapShop after two orders: " + myMapShop);
    }
}
