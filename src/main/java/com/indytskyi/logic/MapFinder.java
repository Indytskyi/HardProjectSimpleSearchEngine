package com.indytskyi.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MapFinder {

    private final Map<String, List<Integer>> wordOfPersons = new TreeMap<>();

    void fillingMap(List<String> peopleData) {

        for (int i = 0; i < peopleData.size(); i++) {

            String[] personData = peopleData.get(i).toLowerCase().split(" ");

            for (String data: personData) {
                if (wordOfPersons.containsKey(data)) {
                    wordOfPersons.get(data).add(i);
                    continue;
                }
                List<Integer> rows = new ArrayList<>();
                rows.add(i);
                wordOfPersons.put(data, rows);
            }
        }
    }

    public Map<String, List<Integer>> getWordOfPersons() {
        return wordOfPersons;
    }
}
