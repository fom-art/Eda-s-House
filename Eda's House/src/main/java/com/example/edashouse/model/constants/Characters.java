package com.example.edashouse.model.constants;

import com.example.edashouse.model.utils.CoordinatesCounter;

public enum Characters {
    WITCH(CoordinatesCounter.calculateCoordinates(5, 4), 0),
    BELLFLOWER(CoordinatesCounter.calculateCoordinates(6, 9), 1),
    BUGS(CoordinatesCounter.calculateCoordinates(9, 2), 2),
    HUMANS_GARBAGE(CoordinatesCounter.calculateCoordinates(1, 3), 3),
    KING(CoordinatesCounter.calculateCoordinates(1, 4), 4),
    MOUSES(CoordinatesCounter.calculateCoordinates(7, 1), 5),
    POT(CoordinatesCounter.calculateCoordinates(5, 5), 6),
    SNAKES(CoordinatesCounter.calculateCoordinates(2, 6), 7),
    SPIDERS(CoordinatesCounter.calculateCoordinates(9, 9), 8),
    WINDOWSILL(CoordinatesCounter.calculateCoordinates(9, 5), 9),
    ACTIVE_ICON(CoordinatesCounter.calculateCoordinates(-3, -3), 10);

    private final int[] coordinates;
    private final Integer index;

    Characters(int[] coordinates, Integer index) {
        this.coordinates = coordinates;
        this.index = index;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public Integer getIndex() {
        return index;
    }
}
