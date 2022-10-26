package com.indytskyi.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NoneSearch implements TypeOfSearch {

    @Override
    public Set<Integer> search(Map<String, ArrayList<Integer>> wordOfPersons) {
        Scanner scanner = new Scanner(System.in);
        final Set<Integer> allIndexOfPeople = new LinkedHashSet<>();
        final Set<Integer> filterPeople = new LinkedHashSet<>();

        wordOfPersons.values().forEach(allIndexOfPeople::addAll);


        System.out.println("Enter a name or email to search none suitable people.");
        String inputData = scanner.nextLine().toLowerCase();

        Arrays.stream(inputData.split(" ")).forEach(data -> {
            if (wordOfPersons.containsKey(data)) {
                filterPeople.addAll(wordOfPersons.get(data));
            }
        });

        allIndexOfPeople.removeAll(filterPeople);

        return allIndexOfPeople;
    }


}
