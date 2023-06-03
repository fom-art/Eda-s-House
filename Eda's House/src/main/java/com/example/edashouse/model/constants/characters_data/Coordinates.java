package com.example.edashouse.model.constants.characters_data;

import com.example.edashouse.model.csv.CSVReader;
import com.example.edashouse.model.utils.CoordinatesCounter;

/**
 * Constants representing different actions triggered by key presses.
 */
public enum Coordinates {
    WITCH(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(0))),
    BELLFLOWER(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(1))),
    BUGS(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(2))),
    HUMANS_GARBAGE(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(3))),
    KING(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(4))),
    MOUSES(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(5))),
    POT(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(6))),
    SNAKES(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(7))),
    SPIDERS(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(8))),
    WINDOWSILL(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(9))),
    ACTIVE_ICON(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(10))),
    PICKED_ITEM(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(11)));

    private final int[] coordinates;

    Coordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int[] getCoordinates() {
        return this.coordinates;
    }
}
