package com.example.edashouse.model.constants;

public enum ViewIndexes {
    WITCH_VIEW(0);

    private Integer index;

    ViewIndexes(Integer index) {
        this.index = index;
    }

    public Integer getValue() {
        return index;
    }
}
