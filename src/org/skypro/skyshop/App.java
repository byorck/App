package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоки", 100);
        Product razor = new Product("Бритва", 500);
        Product cookie = new Product("Печенье", 200);
        Product meat = new Product("Мясо", 450);
        Product milk = new Product("Молоко", 150);
        Product salt = new Product("Соль", 50);

        System.out.println(apple);

        ProductBasket.addProductBasket(apple);
        ProductBasket.addProductBasket(razor);
        ProductBasket.addProductBasket(cookie);
        ProductBasket.addProductBasket(meat);
        ProductBasket.addProductBasket(milk);
        System.out.println(Arrays.toString(ProductBasket.myProductBasket));


        ProductBasket.addProductBasket(salt);
        System.out.println(Arrays.toString(ProductBasket.myProductBasket));

        System.out.println("Общая стоимость корзины: " + ProductBasket.basketTotalCost());

        ProductBasket.basketContents();

        System.out.println("Проверка наличия продукта: " + apple + " - " + ProductBasket.checkingProduct(apple));
        System.out.println("Проверка наличия продукта: " + salt + " - " + ProductBasket.checkingProduct(salt));

        ProductBasket.eraseProductBasket();

        ProductBasket.basketContents();
        System.out.println("Общая стоимость корзины: " + ProductBasket.basketTotalCost());
        System.out.println("Проверка наличия продукта: " + apple + " - " + ProductBasket.checkingProduct(apple));

    }
}
