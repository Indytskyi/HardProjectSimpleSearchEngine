package com.indytskyi.strategy;


import static com.indytskyi.MapFactory.createMapOfAllWordsFromList;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindPersonTest {

    FindPerson findPerson;
    @Before
    public void setUp() {
        findPerson = new FindPerson();
    }

    @Test
    public void setTypeOfSearch() {
        //THEN
        findPerson.setTypeOfSearch(new AllSearcher());
    }

    @Test
    public void search() {
        //GIVEN
        String testInputs = """
                djo@gmail.com
                dwight djo@gmail.com
                """;
        ByteArrayInputStream in = new ByteArrayInputStream(testInputs.getBytes());
        System.setIn(in);
        findPerson.setTypeOfSearch(new AllSearcher());
        Map<String, List<Integer>> mapFinder = createMapOfAllWordsFromList();
        var expected = Set.of(0, 1);

        //WHEN
        Set<Integer> response = findPerson.search(mapFinder);

        //THEN
        Assert.assertEquals(expected, response);
    }
}