package com.example.edashouse.model.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
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
