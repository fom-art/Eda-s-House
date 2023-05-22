package com.example.edashouse.model.constants;

public enum Constants {
    GRID_CELL_SIZE(80),
    GRID_SIZE_IN_CELLS(9),
    ACTIVE_ICON_SIZE(25),
    ITEM_PICKED_SIZE(30);

    private int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
