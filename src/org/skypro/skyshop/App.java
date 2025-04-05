package org.skypro.skyshop;

import org.skypro.skyshop.Searchable.SearchEngine;
import org.skypro.skyshop.Searchable.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.LinkedList;

import static org.skypro.skyshop.basket.ProductBasket.myProductBasket;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        SimpleProduct apple = new SimpleProduct("Яблоки", 100);
        FixPriceProduct razor = new FixPriceProduct("Бритва");
        SimpleProduct cookie = new SimpleProduct("Печенье", 200);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 777, 25);
        SimpleProduct milk = new SimpleProduct("Молоко", 150);
        SimpleProduct salt = new SimpleProduct("Соль", 50);

        System.out.println(apple);

        ProductBasket.addProductBasket(apple);
        ProductBasket.addProductBasket(razor);
        ProductBasket.addProductBasket(cookie);
        ProductBasket.addProductBasket(meat);
        ProductBasket.addProductBasket(milk);
        System.out.println(myProductBasket);

        ProductBasket.addProductBasket(salt);
        System.out.println(myProductBasket);

        System.out.println("Общая стоимость корзины: " + ProductBasket.basketTotalCost());

        ProductBasket.basketContents();

        System.out.println("Проверка наличия продукта: " + apple + " - " + ProductBasket.checkingProduct(apple));
        System.out.println("Проверка наличия продукта: " + razor + " - " + ProductBasket.checkingProduct(razor));
        System.out.println("Проверка наличия продукта: " + salt + " - " + ProductBasket.checkingProduct(salt));

        ProductBasket.eraseProductBasket();

        ProductBasket.basketContents();

        System.out.println("Общая стоимость корзины: " + ProductBasket.basketTotalCost());

        System.out.println("Проверка наличия продукта: " + apple + " - " + ProductBasket.checkingProduct(apple));
        System.out.println("Проверка наличия продукта: " + razor + " - " + ProductBasket.checkingProduct(razor));
        System.out.println("Проверка наличия продукта: " + meat + " - " + ProductBasket.checkingProduct(meat));

        System.out.println("ДЗ: 'ООП. Полиморфизм. Интерфейсы'");

        Article appleAbout = new Article("Яблоки", "Свежие яблоки");
        Article razorAbout = new Article("Бритва", "Острая бритва");
        Article cookieAbout = new Article("Печенье", "Хрустящее печенье");
        Article meatAbout = new Article("Мясо", "Говяжье");
        Article milkAbout = new Article("Молоко", "Пастеризованное");
        Article saltAbout = new Article("Соль", "Йодированная");

        SearchEngine elements = new SearchEngine();

        elements.add(apple);
        elements.add(appleAbout);
        elements.add(razor);
        elements.add(razorAbout);
        elements.add(cookie);
        elements.add(cookieAbout);
        elements.add(meat);
        elements.add(meatAbout);
        elements.add(milkAbout);
        elements.add(saltAbout);


        LinkedList<Searchable> result = elements.search("ябл");
        System.out.println("Найдено: " + result);
        LinkedList<Searchable> result2 = elements.search("моло");
        System.out.println("Найдено: " + result2);
        LinkedList<Searchable> result3 = elements.search("ПЕЧЕНЬ");
        System.out.println("Найдено: " + result3);
        LinkedList<Searchable> result4 = elements.search("осТрая");
        System.out.println("Найдено: " + result4);
        LinkedList<Searchable> result5 = elements.search("я");
        System.out.println("Найдено: " + result5);

        System.out.println("ДЗ: 'Исключения в Java'");

        try {
            DiscountedProduct meat2 = new DiscountedProduct("null", 50, 150);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct salt3 = new SimpleProduct("null", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct salt3 = new SimpleProduct(" ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            FixPriceProduct razor2 = new FixPriceProduct(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        SearchEngine elements2 = new SearchEngine();

//        elements2.findingMostSuitableElement("ье");

        elements2.add(cookie);
        elements2.add(cookieAbout);
        elements2.add(meat);
        elements2.add(meatAbout);

        System.out.println("Найдено: " + elements2.search("ье"));
        System.out.println("Наиболее подходящий элемент поиска: " + elements2.findingMostSuitableElement("ье"));

//        elements2.findingMostSuitableElement("gье");

        System.out.println("ДЗ: Java Collections Framework: List");
        ProductBasket.addProductBasket(apple);
        ProductBasket.addProductBasket(razor);
        ProductBasket.addProductBasket(cookie);
        ProductBasket.addProductBasket(meat);
        ProductBasket.addProductBasket(razor);
        System.out.println(myProductBasket);

        System.out.println("Удалено из корзины: " + ProductBasket.deleteProductByName(razor));

        ProductBasket.basketContents();

        System.out.println("Удалено из корзины: " + ProductBasket.deleteProductByName(razor));

        if (ProductBasket.deleteProductByName(razor).isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println(myProductBasket);
    }
}

