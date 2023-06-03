package com.example.edashouse.model.constants.characters_data;

/**
 * Identifiers for non-playable characters (NPCs) in the game.
 */
public enum CharactersIdentity {
    WITCH(0),
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

    /**
     * Constructs an NPCIdentity enum with the specified associated item.
     *
     * @param index
     */
    CharactersIdentity(Integer index) {
        this.index = index;
    }

    /**
     * Gets the item associated with the NPCIdentity.
     *
     * @return the associated item
     */
    public Integer getCharacterIndex() {
        return this.index;
    }
}
