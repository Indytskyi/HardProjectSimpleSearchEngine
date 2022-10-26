package com.indytskyi;

import java.util.ArrayList;
import java.util.List;

public class PeopleDataFactory {
    public static List<String> PEOPLE_DATA = new ArrayList<>();

    public static List<String> createPeopleData() {
        PEOPLE_DATA.add("Dwight Joseph djo@gmail.com");
        PEOPLE_DATA.add("Myrtle Medina djo@gmail.com");
        PEOPLE_DATA.add("Erick Burgess");
        return PEOPLE_DATA;
    }
}
