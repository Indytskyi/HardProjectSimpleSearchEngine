package com.indytskyi.strategy;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class FindPerson {
    private TypeOfSearch typeOfSearch;

    public void setTypeOfSearch(TypeOfSearch typeOfSearch) {
        this.typeOfSearch = typeOfSearch;
    }

    public Set<Integer> search(Map<String, ArrayList<Integer>> wordOfPersons) {
        return typeOfSearch.search(wordOfPersons);
    }

}
