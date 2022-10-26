package com.indytskyi.strategy;


import static com.indytskyi.MapFactory.createMapOfAllWordsFromList;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class FindPersonTest {

    @Test
    public void setTypeOfSearch() {
        //GIVEN
        FindPerson findPerson = new FindPerson();

        //THEN
        findPerson.setTypeOfSearch(new AllSearch());

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
        FindPerson findPerson = new FindPerson();
        findPerson.setTypeOfSearch(new AllSearch());
        Map<String, ArrayList<Integer>> mapFinder = createMapOfAllWordsFromList();
        var expected = Set.of(0, 1);

        //WHEN
        Set<Integer> response = findPerson.search(mapFinder);

        //THEN
        Assert.assertEquals(expected, response);
    }
}