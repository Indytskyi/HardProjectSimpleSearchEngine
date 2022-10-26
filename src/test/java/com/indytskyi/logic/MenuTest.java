package com.indytskyi.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.indytskyi.strategy.FindPerson;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    FindPerson findPerson;

    @Test
    public void getFromFileDataOfPeopleWithIncorrectDirectory() {
        //GIVEN
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        Menu menu = new Menu(findPerson);
        String incorrectDirectory = "./src/txt1.txt";
        String expected = "There is no such file!\n";
        // WHEN
        menu.getFromFileDataOfPeople(incorrectDirectory);

        //THEN
        assertEquals(expected, byteArrayOutputStream.toString());
    }


    @Test
    public void testMenuWithIncorrect() {
        //GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream("3\n0\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        Menu menu = new Menu(findPerson);
        String expected = "Incorrect option! Try again.";

        // WHEN
        menu.menu();
        String got = byteArrayOutputStream.toString();
        String retrieved = got.split("\n\n")[1];

        //THEN
        assertEquals(expected, retrieved);
    }

    @Test
    public void checkWorkingOfNavigationToAllStrategy() {
        //GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream("1\nALL\n0\n".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setIn(in);
        System.setOut(ps);
        Menu menu = new Menu(findPerson);
        String incorrectDirectory = "./src/text.txt";
        String expectedValue = "Bye!";

        //WHEN
        when(findPerson.search(any())).thenReturn(Set.of());
        menu.getFromFileDataOfPeople(incorrectDirectory);
        menu.menu();

        //THEN
        boolean response = byteArrayOutputStream.toString().contains(expectedValue);
        assertTrue(response);
        System.setOut(System.out);
    }

    @Test
    public void checkWorkingOfNavigationToAnyStrategy() {
        //GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream("1\nANY\n0\n".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setIn(in);
        System.setOut(ps);
        Menu menu = new Menu(findPerson);
        String incorrectDirectory = "./src/text.txt";
        String expectedValue = "Bye!";

        //WHEN
        when(findPerson.search(any())).thenReturn(Set.of(0,1));
        menu.getFromFileDataOfPeople(incorrectDirectory);
        menu.menu();

        //THEN
        boolean response = byteArrayOutputStream.toString().contains(expectedValue);
        assertTrue(response);
        System.setOut(System.out);
    }

    @Test
    public void checkWorkingOfNavigationToNoneStrategy() {
        //GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream("1\nNONE\n0\n".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setIn(in);
        System.setOut(ps);
        Menu menu = new Menu(findPerson);
        String incorrectDirectory = "./src/text.txt";
        String expectedValue = "Bye!";

        //WHEN
        when(findPerson.search(any())).thenReturn(Set.of());
        menu.getFromFileDataOfPeople(incorrectDirectory);
        menu.menu();

        //THEN
        boolean response = byteArrayOutputStream.toString().contains(expectedValue);
        assertTrue(response);
        System.setOut(System.out);
    }

    @Test
    public void testPrintAllDataThatWeGetFromFile() {
        //GIVEN
        ByteArrayInputStream in = new ByteArrayInputStream("2\n0\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        System.setOut(ps);
        Menu menu = new Menu(findPerson);

        String incorrectDirectory = "./src/text.txt";

        String expected = """
                === List of people ===
                Dwight Joseph djo@gmail.com
                Rene Webb webb@gmail.com
                Katie Jacobs
                Erick Harrington harrington@gmail.com
                Myrtle Medina
                Erick Burgess""";

        // WHEN
        menu.getFromFileDataOfPeople(incorrectDirectory);
        menu.menu();
        boolean retrieved =  byteArrayOutputStream.toString().contains(expected);

        //THEN
        assertTrue(retrieved);
    }


}