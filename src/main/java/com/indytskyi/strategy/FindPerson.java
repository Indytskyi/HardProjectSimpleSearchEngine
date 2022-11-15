package com.indytskyi.strategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindPerson {
    private BasicSearcher basicSearcher;

    public void setTypeOfSearch(BasicSearcher basicSearcher) {
        this.basicSearcher = basicSearcher;
    }

    public Set<Integer> search(Map<String, List<Integer>> wordOfPersons) {
        return basicSearcher.search(wordOfPersons);
    }

}
