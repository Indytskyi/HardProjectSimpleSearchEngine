package com.indytskyi.strategy;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AllSearcher implements BasicSearcher {

    @Override
    public Set<Integer> search(Map<String, List<Integer>> wordOfPersons) {

        Scanner scanner = new Scanner(System.in);
        final Set<Integer> filterPeople = new LinkedHashSet<>();

        System.out.println("Enter a name or email to search all suitable people.");
        String inputData = scanner.nextLine().toLowerCase();

        int counter = 0;

        for (String data : inputData.split(" ")) {
            if (wordOfPersons.containsKey(data)) {
                if (counter == 0) {
                    filterPeople.addAll(wordOfPersons.get(data));
                } else {
                    filterPeople.retainAll(wordOfPersons.get(data));
                }
                counter++;
            }
        }

        return filterPeople;
    }


}
