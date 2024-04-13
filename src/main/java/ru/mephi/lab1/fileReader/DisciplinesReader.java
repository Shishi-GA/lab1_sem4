package ru.mephi.lab1.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinesReader{

    private static final String FILEPATH = "src/main/resources/disciplines.txt";

    public static List<String> readDisciplines() {
        List<String> disciplines = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(FILEPATH));
            String line = reader.readLine();
            while (line != null) {
                disciplines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error with file reading.");
        }
        return disciplines;
    }

}
