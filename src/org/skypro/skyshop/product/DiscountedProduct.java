package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basicPrice;
    private final int discount;

    public DiscountedProduct(String name, int basicPrice, int discount) {
        super(name);
        this.basicPrice = basicPrice;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в пределах от 0 до 100");
        }
        this.discount = discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return basicPrice - (basicPrice * discount) / 100;
    }

    @Override
    public String toString() {
        return super.getName() + ": " + getPrice() + " (" + discount + " %)";
    }
}
