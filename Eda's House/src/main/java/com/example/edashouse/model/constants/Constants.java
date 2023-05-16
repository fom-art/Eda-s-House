package com.example.edashouse.model.constants;

public enum Constants {
    GRID_CELL_SIZE(80),
    GRID_SIZE_IN_CELLS(9);

    private Integer value;

    Constants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
