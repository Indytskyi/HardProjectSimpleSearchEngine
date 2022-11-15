package com.indytskyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {
    public static Map<String, List<Integer>> MAP_OF_ALL_WORDS_FROM_LIS = new TreeMap<>();

    public static Map<String, List<Integer>> createMapOfAllWordsFromList() {
        MAP_OF_ALL_WORDS_FROM_LIS.put("burgess", new ArrayList<>(List.of(2)));
        MAP_OF_ALL_WORDS_FROM_LIS.put("djo@gmail.com", new ArrayList<>(List.of(0, 1)));
        MAP_OF_ALL_WORDS_FROM_LIS.put("dwight", new ArrayList<>(List.of(0)));
        MAP_OF_ALL_WORDS_FROM_LIS.put("erick", new ArrayList<>(List.of(2)));
        MAP_OF_ALL_WORDS_FROM_LIS.put("joseph", new ArrayList<>(List.of(0)));
        MAP_OF_ALL_WORDS_FROM_LIS.put("medina", new ArrayList<>(List.of(1)));
        MAP_OF_ALL_WORDS_FROM_LIS.put("myrtle", new ArrayList<>(List.of(1)));
        return  MAP_OF_ALL_WORDS_FROM_LIS;
    }
}
