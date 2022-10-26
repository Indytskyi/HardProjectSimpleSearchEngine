package com.indytskyi.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MapFinder {

    private final Map<String, ArrayList<Integer>> wordOfPersons = new TreeMap<>();

    void fillingMap(List<String> peopleData) {

        for (int i = 0; i < peopleData.size(); i++) {

            String[] personData = peopleData.get(i).toLowerCase().split(" ");

            for (String data: personData) {
                if (!wordOfPersons.containsKey(data)) {
                    wordOfPersons.put(data, new ArrayList<>(List.of(i)));
                } else {
                    wordOfPersons.get(data).add(i);
                }
            }
        }
    }

    public Map<String, ArrayList<Integer>> getWordOfPersons() {
        return wordOfPersons;
    }
}
