package com.example.edashouse.model.utils;

import com.example.edashouse.model.constants.Constants;

public class CoordinatesCounter {
    public static int[] calculateCoordinates(int coordinateX, int coordinateY) {
        int calculatedX = (coordinateX + 1) * Constants.GRID_CELL_SIZE.getValue();
        int calculatedY = (coordinateY + 1) * Constants.GRID_CELL_SIZE.getValue();
        return new int[]{calculatedX, calculatedY};
    }
}
