package com.indytskyi.strategy;

import static com.indytskyi.MapFactory.createMapOfAllWordsFromList;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.junit.AfterClass;
import org.junit.Test;

public class AllSearchTest {

    @AfterClass
    public static void afterClass() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    public void CheckIfWeFoundPeopleWithALLDataThatWeInputWithOneArgument() throws IOException {
        //GIVEN
        String testInputs = """
                djo@gmail.com
                dwight djo@gmail.com
                """;
        ByteArrayInputStream in = new ByteArrayInputStream(testInputs.getBytes());
        System.setIn(in);

        AllSearch allSearch = new AllSearch();
        Map<String, ArrayList<Integer>> mapFinder = createMapOfAllWordsFromList();
        Set<Integer> expected = Set.of(0, 1);

        //WHEN
        Set<Integer> retrieved = allSearch.search(mapFinder);

        //THEN
        assertEquals(expected, retrieved);
    }


    @Test
    public void CheckIfWeFoundPeopleWithALLDataThatWeInputWithMoreArgumentsButWithIncompleteCoOwnership() {
        //GIVEN
        String testInputs = """
                Erick Burgess
                """;
        ByteArrayInputStream in = new ByteArrayInputStream(testInputs.getBytes());
        System.setIn(in);

        AllSearch allSearch = new AllSearch();
        Map<String, ArrayList<Integer>> mapFinder = createMapOfAllWordsFromList();
        Set<Integer> expected = Set.of(2);

        //WHEN
        Set<Integer> retrieved = allSearch.search(mapFinder);

        //THEN
        assertEquals(expected, retrieved);
    }
}