package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
    private static final int basketSize = 5;
    public static Product[] myProductBasket = new Product[basketSize];

    public static void addProductBasket(Product name) {
        for (int i = 0; i < basketSize; i++) {
            if (myProductBasket[i] == null) {
                myProductBasket[i] = name;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public static int basketTotalCost() {
        int totalCost = 0;
        if (myProductBasket[0] == null) {
            return totalCost;
        }
        for (int i = 0; i < basketSize; i++) {
            totalCost += myProductBasket[i].getPrice();
        }
        return totalCost;
    }

    public static void basketContents() {
        if (myProductBasket[0] == null) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < basketSize; i++) {
            if (myProductBasket[i] != null) {
                System.out.println(myProductBasket[i].getName() + ": " + myProductBasket[i].getPrice());
            }
        }
        System.out.println("Итого: " + basketTotalCost());

    }

    public static boolean checkingProduct(Product name) {
        if (myProductBasket[0] == null) {
            return false;
        }
        for (int i = 0; i < basketSize; i++) {
            if (Objects.equals(myProductBasket[i].getName(), name.getName())) {
                return true;
            }
        }
        return false;
    }

    public static void eraseProductBasket() {
        Arrays.fill(myProductBasket, null);
    }
}

