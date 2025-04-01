package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null");
        }
            this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isSpecial();

    public abstract int getPrice();

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String searchableTerm() {
        return name;
    }

    @Override
    public String searchableType() {
        return "PRODUCT";
    }

    @Override
    public String searchableName() {
        return name;
    }

    @Override
    public void getStringRepresentation() {
    }
}
