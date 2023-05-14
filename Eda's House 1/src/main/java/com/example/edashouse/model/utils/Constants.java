package com.example.edashouse.model.utils;

public enum Constants {
    GRID_CELL_SIZE(48),
    GRID_SIZE_IN_CELLS(16);

    private Integer value;

    Constants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
