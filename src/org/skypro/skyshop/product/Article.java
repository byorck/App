package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameArticle, article.nameArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameArticle);
    }
}
