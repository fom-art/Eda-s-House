package com.example.edashouse.model.constants;

/**
 * Identifiers for non-playable characters (NPCs) in the game.
 */
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

    /**
     * Constructs an NPCIdentity enum with the specified associated item.
     *
     * @param item the item associated with the NPCIdentity
     */
    NPCIdentity(Items item) {
        this.item = item;
    }

    /**
     * Gets the item associated with the NPCIdentity.
     *
     * @return the associated item
     */
    public Items getNPCItem() {
        return this.item;
    }
}
