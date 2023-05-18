package com.example.edashouse.model.constants;

import com.example.edashouse.model.utils.CoordinatesCounter;

public enum BasicCoordinates {
    WITCH_DEFAULT(CoordinatesCounter.calculateCoordinates(5, 4)),
    BUGS(CoordinatesCounter.calculateCoordinates(9, 2)),
    BELLFLOWER(CoordinatesCounter.calculateCoordinates(6, 9)),
    HUMANS_GARBAGE(CoordinatesCounter.calculateCoordinates(1, 3)),
    KING(CoordinatesCounter.calculateCoordinates(1, 4)),
    MOUSES(CoordinatesCounter.calculateCoordinates(7, 1)),
    POT(CoordinatesCounter.calculateCoordinates(5, 5)),
    SNAKES(CoordinatesCounter.calculateCoordinates(2, 6)),
    SPIDERS(CoordinatesCounter.calculateCoordinates(9, 9)),
    WINDOWSILL(CoordinatesCounter.calculateCoordinates(9, 5));

    private int[] coordinates;

    BasicCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int[] getCoordinates() {
        return coordinates;
    }
}
