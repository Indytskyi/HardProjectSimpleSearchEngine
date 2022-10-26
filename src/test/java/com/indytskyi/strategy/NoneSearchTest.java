package com.indytskyi.strategy;

import static com.indytskyi.MapFactory.createMapOfAllWordsFromList;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class NoneSearchTest {

    @Before
    public void setUp() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("Dwight medina".getBytes());
        System.setIn(in);
    }

    @Test
    public void CheckIfWeFoundPeopleWithoutArgumentsThatWeInput() {
        //GIVEN
        NoneSearch noneSearch = new NoneSearch();
        Map<String, ArrayList<Integer>> mapFinder = createMapOfAllWordsFromList();
        Set<Integer> expected = Set.of(2);

        //WHEN
        Set<Integer> retrieved = noneSearch.search(mapFinder);

        //THEN
        assertEquals(expected, retrieved);
    }
}