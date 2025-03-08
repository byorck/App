package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class ProductBasket {
    private static final int basketSize = 5;
    public static String[] nameProductBasket = new String[basketSize];
    public static int[] priceProductBasket = new int[basketSize];

    public static void addProductBasket(Product name) {
        for (int i = 0; i < basketSize; i++) {
            if (nameProductBasket[i] == null) {
                nameProductBasket[i] = name.getName();
                priceProductBasket[i] = name.getPrice();
                break;
            } else if (i == basketSize - 1) {
                System.out.println("Невозможно добавить продукт");
            }
        }
    }

    public static int basketTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < basketSize; i++) {
            totalCost += priceProductBasket[i];
        }
        return totalCost;
    }

    public static void basketContents() {
        if (nameProductBasket[0] == null) {
            System.out.println("В корзине пусто");
        } else {
            for (int i = 0; i < basketSize; i++) {
                if (nameProductBasket[i] != null) {
                    System.out.println(nameProductBasket[i] + ": " + priceProductBasket[i]);
                }
            }
            System.out.println("Итого: " + basketTotalCost());
        }
    }

    public static boolean checkingProduct(Product name) {
        boolean checking = false;
        for (int i = 0; i < basketSize; i++) {
            if (Objects.equals(nameProductBasket[i], name.getName())) {
                checking = true;
                break;
            }
        }
        return checking;
    }

    public static void eraseProductBasket() {
        for (int i = 0; i < basketSize; i++) {
            nameProductBasket[i] = null;
            priceProductBasket[i] = 0;
        }
    }
}

