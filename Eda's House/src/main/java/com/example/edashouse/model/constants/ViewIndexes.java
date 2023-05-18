package com.example.edashouse.model.constants;

public enum ViewIndexes {
    WITCH_VIEW(0),
    BELLFLOWER(1),
    BUGS(2),
    HUMANS_GARBAGE(3),
    KING(4),
    MOUSES(5),
    POT(6),
    SNAKES(7),
    SPIDERS(8),
    WINDOWSILL(9);

    private final Integer index;

    ViewIndexes(Integer index) {
        this.index = index;
    }

    public Integer getValue() {
        return index;
    }
}
