package com.example.edashouse.model.constants.characters_data;

import com.example.edashouse.model.csv.CSVReader;
import com.example.edashouse.model.utils.CoordinatesCounter;

/**
 * Constants representing different coordinates of characters in the game.
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

    /**
     * Constructs a Coordinates enum with the specified coordinates.
     *
     * @param coordinates the coordinates associated with the constant
     */
    Coordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets the coordinates associated with the constant.
     *
     * @return the coordinates associated with the constant
     */
    public int[] getCoordinates() {
        return this.coordinates;
    }
}
