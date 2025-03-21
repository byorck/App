package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable.Searchable;

public class Article implements Searchable {
    String nameArticle;
    String contentArticle;

    public Article(String nameArticle, String contentArticle) {
        this.nameArticle = nameArticle;
        this.contentArticle = contentArticle;
    }

    @Override
    public String toString() {
        return nameArticle + " " + contentArticle;
    }

    @Override
    public String searchableTerm() {
        return nameArticle + " " + contentArticle;
    }

    @Override
    public String searchableType() {
        return "ARTICLE";
    }

    @Override
    public String searchableName() {
        return nameArticle;
    }

    @Override
    public void getStringRepresentation() {
    }
}
