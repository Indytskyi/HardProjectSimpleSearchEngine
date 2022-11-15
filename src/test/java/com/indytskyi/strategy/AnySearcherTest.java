package com.indytskyi.strategy;

import static com.indytskyi.MapFactory.createMapOfAllWordsFromList;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class AnySearcherTest {

    @Test
    public void CheckIfWeFoundPeopleWithAtLeastOneArgumentThatWeInput() {
        //GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream("djo@gmail.com erick\n".getBytes());
        System.setIn(in);
        AnySearcher anySearcher = new AnySearcher();
        Map<String, List<Integer>> mapFinder = createMapOfAllWordsFromList();
        Set<Integer> expected = Set.of(0, 1, 2);

        //WHEN
        Set<Integer> retrieved = anySearcher.search(mapFinder);

        //THEN
        assertEquals(expected, retrieved);
    }
}
