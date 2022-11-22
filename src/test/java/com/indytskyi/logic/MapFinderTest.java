package com.indytskyi.logic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

public class MapFinderTest {

    @Test
    public void checkIfConvertingFromListToMapCorrect() {
        //GIVEN
        List<String> peopleData = List.of("Dwight Joseph djo@gmail.com",
                "Myrtle Medina djo@gmail.com",
                "Erick Burgess");
        MapFinder mapFinder = new MapFinder();
        Map<String, ArrayList<Integer>> expected = new TreeMap<>();
        expected.put("burgess", new ArrayList<>(List.of(2)));
        expected.put("djo@gmail.com", new ArrayList<>(List.of(0, 1)));
        expected.put("dwight", new ArrayList<>(List.of(0)));
        expected.put("erick", new ArrayList<>(List.of(2)));
        expected.put("joseph", new ArrayList<>(List.of(0)));
        expected.put("medina", new ArrayList<>(List.of(1)));
        expected.put("myrtle", new ArrayList<>(List.of(1)));
        //WHEN
        mapFinder.fillingMap(peopleData);

        //THEN
        assertEquals(expected, mapFinder.getWordOfPersons());
    }
}