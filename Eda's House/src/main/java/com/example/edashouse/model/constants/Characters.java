package com.example.edashouse.model.constants;

import com.example.edashouse.model.csv.CSVReader;
import com.example.edashouse.model.utils.CoordinatesCounter;

/**
 * Constants representing different characters in the game.
 */
public enum Characters {
    WITCH(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(0)), 0),
    BELLFLOWER(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(1)), 1),
    BUGS(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(2)), 2),
    HUMANS_GARBAGE(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(3)), 3),
    KING(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(4)), 4),
    MOUSES(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(5)), 5),
    POT(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(6)), 6),
    SNAKES(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(7)), 7),
    SPIDERS(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(8)), 8),
    WINDOWSILL(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(9)), 9),
    ACTIVE_ICON(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(10)), 10),
    PICKED_ITEM(CoordinatesCounter.calculateCoordinates(CSVReader.readCoordinatesOfCharacters(11)), 11);

    private final int[] coordinates;
    private final Integer index;

    /**
     * Constructs a character with the specified coordinates and index.
     *
     * @param coordinates the coordinates of the character
     * @param index       the index of the character
     */
    Characters(int[] coordinates, Integer index) {
        this.coordinates = coordinates;
        this.index = index;
    }

    /**
     * Returns the coordinates of the character.
     *
     * @return the coordinates of the character
     */
    public int[] getCoordinates() {
        return coordinates;
    }

    /**
     * Returns the index of the character.
     *
     * @return the index of the character
     */
    public Integer getIndex() {
        return index;
    }
}
