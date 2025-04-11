package org.skypro.skyshop.Searchable;

import org.skypro.skyshop.product.BestResultNotFound;

import java.util.*;


public class SearchEngine {
    private List<Searchable> elements;

    public SearchEngine() {
        this.elements = new ArrayList<>();
    }

    public void add(Searchable element) {
        elements.add(element);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Searchable element : elements) {
            if (element != null && element.searchableTerm().toLowerCase().contains(query.toLowerCase())) {
                results.put(element.toString(), element);
            }
        }
        return results;
    }

    public String findingMostSuitableElement(String searchingElement) throws BestResultNotFound {
        Map<String, Searchable> intermediateResults = search(searchingElement);
        if (intermediateResults.isEmpty()) {
            throw new BestResultNotFound(searchingElement);
        }
        List<Searchable> resultsList = new ArrayList<>(intermediateResults.values());
        int resultIndex = 0;
        int mostBiggestResult = 0;
        for (int i = 0; i < resultsList.size(); i++) {
            int index = 0;
            int countResult = 0;
            int indexSubstring = resultsList.get(i).toString().toLowerCase().indexOf(searchingElement.toLowerCase(), index);
            while (indexSubstring != -1) {
                countResult++;
                index = indexSubstring + searchingElement.length();
                indexSubstring = resultsList.get(i).toString().toLowerCase().indexOf(searchingElement.toLowerCase(), index);
            }
            if (countResult > mostBiggestResult) {
                resultIndex = i;
                mostBiggestResult = countResult;
            }
        }
        if (resultsList.isEmpty()) {
            throw new BestResultNotFound(searchingElement);
        }
        return resultsList.get(resultIndex).toString();
    }
}






