package ru.mephi.lab1.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RussianBookReader {

    private static final String FILEPATH = "src/main/resources/russian_books.txt";

    public static List<String[]> readBooks() {
        List<String[]> books = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(FILEPATH));
            String line = reader.readLine();
            while (line != null) {
                books.add(line.split(";"));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error with file reading.");
        }
        return books;
    }

}
