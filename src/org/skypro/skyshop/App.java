package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоки", 100);
        FixPriceProduct razor = new FixPriceProduct("Бритва");
        SimpleProduct cookie = new SimpleProduct("Печенье",200);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 777, 25);
        SimpleProduct milk = new SimpleProduct("Молоко", 150);
        SimpleProduct salt = new SimpleProduct("Соль", 50);

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
        System.out.println("Проверка наличия продукта: " + razor + " - " + ProductBasket.checkingProduct(razor));
        System.out.println("Проверка наличия продукта: " + meat + " - " + ProductBasket.checkingProduct(meat));

        ProductBasket.eraseProductBasket();

        ProductBasket.basketContents();

        System.out.println("Общая стоимость корзины: " + ProductBasket.basketTotalCost());

        System.out.println("Проверка наличия продукта: " + apple + " - " + ProductBasket.checkingProduct(apple));
        System.out.println("Проверка наличия продукта: " + razor + " - " + ProductBasket.checkingProduct(razor));
        System.out.println("Проверка наличия продукта: " + meat + " - " + ProductBasket.checkingProduct(meat));

    }
}
