package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProductBasket {
    public static List<Product> myProductBasket = new LinkedList<>();

    public static void addProductBasket(Product name) {
        if (myProductBasket.size() < 5) {
            myProductBasket.add(name);
        }
    }

    public static int basketTotalCost() {
        int totalCost = 0;
        if (myProductBasket.isEmpty()) {
            return totalCost;
        }
        for (Product product : myProductBasket) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    public static void basketContents() {
        if (myProductBasket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int specialCount = 0;
        for (int i = 0; i < myProductBasket.size(); i++) {
            if (myProductBasket.get(i) != null) {
                System.out.println(myProductBasket.get(i));
            }
            if (myProductBasket.get(i).isSpecial()) {
                specialCount += 1;
            }
        }
        System.out.println("Итого: " + basketTotalCost());
        System.out.println("Специальных товаров: " + specialCount);

    }

    public static boolean checkingProduct(Product name) {
        for (Product product : myProductBasket) {
            if (Objects.equals(product.getName(), name.getName())) {
                return true;
            }
        }
        return false;
    }

    public static void eraseProductBasket() {
        myProductBasket.clear();
    }

    public static List<Product> deleteProductByName(Product name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = myProductBasket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}

