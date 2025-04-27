package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.*;


public class ProductBasket {
    public static Map<String, List<Product>> myProductBasket = new HashMap<>();

    public static void addProductBasket(Product name) {
        int totalProduct = myProductBasket.values().stream()
                .mapToInt(List::size)
                .sum();

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
        return myProductBasket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public static void basketContents() {
        int totalProduct = myProductBasket.values().stream()
                .mapToInt(List::size)
                .sum();

        if (totalProduct == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        myProductBasket.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        long specialCount = myProductBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();

        System.out.println("Итого: " + basketTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public static boolean checkingProduct(Product name) {
        return myProductBasket.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(product -> Objects.equals(product.getName(), name.getName()));
    }

    public static void eraseProductBasket() {
        myProductBasket.clear();
    }

    public static List<Product> deleteProductByName(Product name) {
        List<Product> removed = myProductBasket.remove(name.getName());
        return removed != null ? removed : new LinkedList<>();
    }
}

