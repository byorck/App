package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    public static Map<String, List<Product>> myProductBasket = new HashMap<>();

    public static void addProductBasket(Product name) {
        int totalProduct = 0;
        for (List<Product> products : myProductBasket.values()) {
            totalProduct += products.size();
        }

        if (totalProduct >= 5) {
            return;
        }

        String productName = name.getName();
        if (!myProductBasket.containsKey(productName)) {
            myProductBasket.put(productName, new LinkedList<>());
        }
        myProductBasket.get(productName).add(name);
    }

    public static int basketTotalCost() {
        int totalCost = 0;
        if (myProductBasket.isEmpty()) {
            return totalCost;
        }
        for (List<Product> products : myProductBasket.values()) {
            for (Product product : products) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public static void basketContents() {
        int totalProduct = 0;
        for (List<Product> products : myProductBasket.values()) {
            totalProduct += products.size();
        }

        if (totalProduct == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;
        for (List<Product> products : myProductBasket.values()) {
            for (Product product : products) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + basketTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public static boolean checkingProduct(Product name) {
        for (List<Product> products : myProductBasket.values()) {
            for (Product product : products) {
                if (Objects.equals(product.getName(), name.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void eraseProductBasket() {
        myProductBasket.clear();
    }

    public static List<Product> deleteProductByName(Product name) {
        List<Product> removed = myProductBasket.remove(name.getName());
        return removed != null ? removed : new LinkedList<>();
    }
}

