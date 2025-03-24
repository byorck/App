package org.skypro.skyshop.Searchable;

public class SearchEngine {
    private Searchable[] elements;
    private int index;

    public SearchEngine(int size) {
        this.elements = new Searchable[size];
        this.index = 0;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;
        for (Searchable element : elements) {
            if (element != null && element.searchableTerm().toLowerCase().contains(query.toLowerCase())) {
                results[count] = element;
                count++;
                if (count == 5) {
                    break;
                }
            }
        }
        return results;
    }

    public void add(Searchable element) {
        if (index < elements.length) {
            elements[index] = element;
            index++;
        } else {
            System.out.println("Массив элементов, по которым можно искать, переполнен");
        }
    }
}

