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
     * Constructs a CharactersIdentity enum with the specified index.
     *
     * @param index the index associated with the character identity
     */
    CharactersIdentity(Integer index) {
        this.index = index;
    }

    /**
     * Gets the index associated with the character identity.
     *
     * @return the index associated with the character identity
     */
    public Integer getCharacterIndex() {
        return this.index;
    }
}
