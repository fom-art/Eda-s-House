package com.example.edashouse.model.constants;

public enum NPCIdentity {
    BELLFLOWER(Items.BELLFLOWER),
    BUGS(Items.BUGS),
    HUMANS_GARBAGE(Items.HUMANS_GARBAGE),
    KING(Items.KING),
    MOUSES(Items.MOUSES),
    POT(Items.EMPTY_ITEM),
    SNAKES(Items.SNAKES),
    SPIDERS(Items.SPIDERS),
    WINDOWSILL(Items.EMPTY_ITEM);

    private final Items item;

    NPCIdentity(Items item) {
        this.item = item;
    }

    public Items getNPCItem() {
        return this.item;
    }
}
