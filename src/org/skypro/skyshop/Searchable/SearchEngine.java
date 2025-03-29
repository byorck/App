package org.skypro.skyshop.Searchable;

import org.skypro.skyshop.product.BestResultNotFound;


public class SearchEngine {
    private Searchable[] elements;
    private int index;

    public SearchEngine(int size) {
        this.elements = new Searchable[size];
        this.index = 0;
    }

    public void add(Searchable element) {
        if (index < elements.length) {
            elements[index] = element;
            index++;
        } else {
            System.out.println("Массив элементов, по которым можно искать, переполнен");
        }
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

    public String findingMostSuitableElement(String searchingElement) {
        Searchable[] intermediateResults = search(searchingElement);
        int resultIndex = 0;
        int mostBiggestResult = 0;
        for (int i = 0; i < intermediateResults.length; i++) {
            if (intermediateResults[i] == null) {
                continue;
            }
            int index = 0;
            int countResult = 0;
            int indexSubstring = intermediateResults[i].toString().toLowerCase().indexOf(searchingElement.toLowerCase(), index);
            while (indexSubstring != -1) {
                countResult++;
                index = indexSubstring + searchingElement.length();
                indexSubstring = intermediateResults[i].toString().toLowerCase().indexOf(searchingElement.toLowerCase(), index);
            }
            if (countResult > mostBiggestResult) {
                resultIndex = i;
                mostBiggestResult = countResult;
            }
        }
        if (intermediateResults[resultIndex] == null) {
            try {
                throw new BestResultNotFound(searchingElement);
            } catch (BestResultNotFound e) {
                throw new RuntimeException(e);
            }
        }
        return intermediateResults[resultIndex].toString();
    }
}






