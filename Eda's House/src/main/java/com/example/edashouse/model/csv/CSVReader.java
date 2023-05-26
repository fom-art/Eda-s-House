package com.example.edashouse.model.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * A utility class for reading character coordinates from a CSV file.
 */
public class CSVReader {
    /**
     * Reads the coordinates of a character from a CSV file.
     *
     * @param characterIndex the index of the character in the CSV file
     * @return an array containing the x and y coordinates of the character
     */
    public static int[] readCoordinatesOfCharacters(int characterIndex) {
        int[] result = new int[2];
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/example/edashouse/model/csv/CSVCharactersCoordinates.csv"));
            for (int i = 0; i <= characterIndex; i++) {
                line = reader.readLine();
                String[] splitOfLine = line.split(splitBy);
                result = new int[]{Integer.parseInt(splitOfLine[0]), Integer.parseInt(splitOfLine[1])};
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
