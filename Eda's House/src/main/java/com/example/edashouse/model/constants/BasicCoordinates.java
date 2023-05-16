package com.example.edashouse.model.constants;

public enum BasicCoordinates {
    WITCH_DEFAULT(new int[]{Constants.GRID_CELL_SIZE.getValue() * 4, Constants.GRID_CELL_SIZE.getValue() * 4});

    private int[] coordinates;

    BasicCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int[] getCoordinates() {
        return coordinates;
    }
}
