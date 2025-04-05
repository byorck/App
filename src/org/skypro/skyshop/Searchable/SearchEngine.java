package org.skypro.skyshop.Searchable;

import org.skypro.skyshop.product.BestResultNotFound;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class SearchEngine {
    private List<Searchable> elements;

    public SearchEngine() {
        this.elements = new ArrayList<>();
    }


    public void add(Searchable element) {
        elements.add(element);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new LinkedList<>();
        for (Searchable element : elements) {
            if (element != null && element.searchableTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(element);
            }
        }
        return results;
    }

    public String findingMostSuitableElement(String searchingElement) throws BestResultNotFound {
        List<Searchable> intermediateResults = search(searchingElement);
        int resultIndex = 0;
        int mostBiggestResult = 0;
        if (intermediateResults.isEmpty()) {
            throw new BestResultNotFound(searchingElement);
        }
        for (int i = 0; i < intermediateResults.size(); i++) {
            int index = 0;
            int countResult = 0;
            int indexSubstring = intermediateResults.get(i).toString().toLowerCase().indexOf(searchingElement.toLowerCase(), index);
            while (indexSubstring != -1) {
                countResult++;
                index = indexSubstring + searchingElement.length();
                indexSubstring = intermediateResults.get(i).toString().toLowerCase().indexOf(searchingElement.toLowerCase(), index);
            }
            if (countResult > mostBiggestResult) {
                resultIndex = i;
                mostBiggestResult = countResult;
            }
        }
        if (intermediateResults.isEmpty()) {
            throw new BestResultNotFound(searchingElement);
        }
        return intermediateResults.get(resultIndex).toString();
    }
}






