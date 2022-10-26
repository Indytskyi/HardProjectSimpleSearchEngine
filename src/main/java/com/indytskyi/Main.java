package com.indytskyi;

import com.indytskyi.logic.Menu;
import com.indytskyi.strategy.FindPerson;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu(new FindPerson());
        menu.getFromFileDataOfPeople("./src/text.txt");
        menu.menu();
    }



}
