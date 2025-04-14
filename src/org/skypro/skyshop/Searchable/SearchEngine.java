package org.skypro.skyshop.Searchable;

import org.skypro.skyshop.product.BestResultNotFound;

import java.util.*;


public class SearchEngine {
    private Set<Searchable> elements;

    public SearchEngine() {
        this.elements = new HashSet<>();
    }

    public void add(Searchable element) {
        elements.add(element);
    }

    private static final Comparator<Searchable> SEARCHABLE_COMPARATOR = (a, b) -> {
        int lengthCompare = Integer.compare(a.toString().length(), b.toString().length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        return a.toString().compareTo(b.toString());
    };

    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(SEARCHABLE_COMPARATOR);
        for (Searchable element : elements) {
            if (element != null && element.searchableTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(element);
            }
        }
        return results;
    }

    public String findingMostSuitableElement(String searchingElement) throws BestResultNotFound {
        Set<Searchable> intermediateResults = search(searchingElement);
        if (intermediateResults.isEmpty()) {
            throw new BestResultNotFound(searchingElement);
        }
        List<Searchable> resultsList = new ArrayList<>(intermediateResults);
        int resultIndex = 0;
        int biggestResult = 0;
        for (int i = 0; i < resultsList.size(); i++) {
            int index = 0;
            int countResult = 0;
            int indexSubstring = resultsList.get(i).toString().toLowerCase().indexOf(searchingElement.toLowerCase(), index);
            while (indexSubstring != -1) {
                countResult++;
                index = indexSubstring + searchingElement.length();
                indexSubstring = resultsList.get(i).toString().toLowerCase().indexOf(searchingElement.toLowerCase(), index);
            }
            if (countResult > biggestResult) {
                resultIndex = i;
                biggestResult = countResult;
            }
        }
        return resultsList.get(resultIndex).toString();
    }
}






