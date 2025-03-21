package org.skypro.skyshop.Searchable;

public interface Searchable {
    String searchableTerm();

    String searchableType();

    String searchableName();

    default void getStringRepresentation(){
        System.out.println(searchableName() + " — " + searchableType());
    }
}



