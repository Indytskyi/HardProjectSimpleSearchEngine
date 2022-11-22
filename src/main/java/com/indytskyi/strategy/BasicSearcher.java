package com.indytskyi.strategy;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BasicSearcher {

    Set<Integer> search(Map<String, List<Integer>> wordOfPersons);
}
