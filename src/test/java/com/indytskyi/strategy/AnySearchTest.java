package com.indytskyi.strategy;

import static com.indytskyi.MapFactory.createMapOfAllWordsFromList;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class AnySearchTest {

    @Test
    public void CheckIfWeFoundPeopleWithAtLeastOneArgumentThatWeInput() {
        //GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream("djo@gmail.com erick\n".getBytes());
        System.setIn(in);
        AnySearch anySearch = new AnySearch();
        Map<String, ArrayList<Integer>> mapFinder = createMapOfAllWordsFromList();
        Set<Integer> expected = Set.of(0, 1, 2);

        //WHEN
        Set<Integer> retrieved = anySearch.search(mapFinder);

        //THEN
        assertEquals(expected, retrieved);
    }
}
