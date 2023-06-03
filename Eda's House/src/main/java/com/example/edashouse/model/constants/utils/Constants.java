package com.example.edashouse.model.constants.utils;

/**
 * Constants used in the game.
 */
public enum Constants {
    GRID_CELL_SIZE(80),
    GRID_SIZE_IN_CELLS(9),
    ACTIVE_ICON_SIZE(25),
    ITEM_PICKED_SIZE(30);

    private int value;

    /**
     * Constructs a constant with the specified value.
     *
     * @param value the value of the constant
     */
    Constants(int value) {
        this.value = value;
    }

    /**
     * Returns the value of the constant.
     *
     * @return the value of the constant
     */
    public int getValue() {
        return value;
    }
}
