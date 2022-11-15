package com.indytskyi.strategy;

import static com.indytskyi.MapFactory.createMapOfAllWordsFromList;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.AfterClass;
import org.junit.Test;

public class AllSearcherTest {

    @AfterClass
    public static void afterClass() {
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    public void CheckIfWeFoundPeopleWithALLDataThatWeInputWithOneArgument() {
        //GIVEN
        String testInputs = """
                djo@gmail.com
                dwight djo@gmail.com
                """;
        ByteArrayInputStream in = new ByteArrayInputStream(testInputs.getBytes());
        System.setIn(in);

        AllSearcher allSearcher = new AllSearcher();
        Map<String, List<Integer>> mapFinder = createMapOfAllWordsFromList();
        Set<Integer> expected = Set.of(0, 1);

        //WHEN
        Set<Integer> retrieved = allSearcher.search(mapFinder);

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

        AllSearcher allSearcher = new AllSearcher();
        Map<String, List<Integer>> mapFinder = createMapOfAllWordsFromList();
        Set<Integer> expected = Set.of(2);

        //WHEN
        Set<Integer> retrieved = allSearcher.search(mapFinder);

        //THEN
        assertEquals(expected, retrieved);
    }
}