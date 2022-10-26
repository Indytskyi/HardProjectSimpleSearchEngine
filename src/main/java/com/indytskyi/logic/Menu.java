package com.indytskyi.logic;


import com.indytskyi.strategy.AllSearch;
import com.indytskyi.strategy.AnySearch;
import com.indytskyi.strategy.FindPerson;
import com.indytskyi.strategy.NoneSearch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    static List<String> peopleData = new ArrayList<>();
    private final FindPerson findPerson;

    public Menu(FindPerson findPerson) {
        this.findPerson = findPerson;
    }


    public void menu() {
        Scanner scanner = new Scanner(System.in);
        MapFinder mapFinder = new MapFinder();
        mapFinder.fillingMap(peopleData);

        while (true) {
            System.out.println("""
                    === Menu ===
                    1. Find a person
                    2. Print all people
                    0. Exit""");
            int controller;
            String controllerString = scanner.nextLine();
            if (!controllerString.matches("[0-2]")) {
                System.out.println("\nIncorrect option! Try again.\n");
                continue;
            } else {
                controller = Integer.parseInt(controllerString);
            }

            switch (controller) {
                case 1 -> {
                    typeOfStrategy(findPerson, scanner);
                    view(findPerson.search(mapFinder.getWordOfPersons()));
                }

                case 2 -> printAllPerson();

                case 0 -> {
                    System.out.println("\nBye!");
                    return;
                }
            }
        }
    }

    private void typeOfStrategy(FindPerson findPerson, Scanner scanner) {

        while (true) {
            System.out.println("Select a matching strategy: ALL, ANY, NONE");
            String strategy = scanner.nextLine();

            switch (strategy) {
                case "ALL" -> {
                    findPerson.setTypeOfSearch(new AllSearch());
                    return;
                }

                case "ANY" -> {
                    findPerson.setTypeOfSearch(new AnySearch());
                    return;
                }

                case "NONE" -> {
                    findPerson.setTypeOfSearch(new NoneSearch());
                    return;
                }
            }

        }
    }


    private void view(Set<Integer> filterIndexOfPeople) {

        if (filterIndexOfPeople.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println(filterIndexOfPeople.size() + " person found:");
            filterIndexOfPeople.forEach(i -> System.out.println(peopleData.get(i)));
        }
    }


    private void printAllPerson() {
        System.out.println("\n=== List of people ===");
        peopleData.forEach(System.out::println);
        System.out.println();
    }

    public void getFromFileDataOfPeople(String directory) {
        File file = new File(directory);

        try (Scanner scanner1 = new Scanner(file)) {
            while (scanner1.hasNext()) {
                peopleData.add(scanner1.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("There is no such file!");
        }
    }
}
