package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {

    public int getNumberOfMales(String path) {
        int sum = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line;
            while ((line = reader.readLine())!= null) {
                sum += checkIfMale(line);
            }
            return sum;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    private int checkIfMale(String line) {
        String gender = line.split(",")[4];
        if (gender.equals("Male")) {
            return 1;
        }
        return 0;
    }


}
