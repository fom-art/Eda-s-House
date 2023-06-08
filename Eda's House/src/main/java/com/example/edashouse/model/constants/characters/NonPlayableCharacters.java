package com.example.edashouse.model.constants.characters;

import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.constants.characters_data.Coordinates;
import com.example.edashouse.model.constants.utils.ImageURL;


/**
 * Constants representing different characters in the game.
 */
public enum NonPlayableCharacters {
    BELLFLOWER(Coordinates.BELLFLOWER.getCoordinates(),  CharactersIdentity.BELLFLOWER, ImageURL.BELLFLOWER, Items.BELLFLOWER),
    BUGS(Coordinates.BUGS.getCoordinates(),  CharactersIdentity.BUGS, ImageURL.BUGS, Items.BUGS),
    HUMANS_GARBAGE(Coordinates.HUMANS_GARBAGE.getCoordinates(),  CharactersIdentity.HUMANS_GARBAGE, ImageURL.HUMANS_GARBAGE, Items.HUMANS_GARBAGE),
    KING(Coordinates.KING.getCoordinates(),  CharactersIdentity.KING, ImageURL.KING, Items.KING),
    MOUSES(Coordinates.MOUSES.getCoordinates(),  CharactersIdentity.MOUSES, ImageURL.MOUSE, Items.MOUSES),
    POT(Coordinates.POT.getCoordinates(),  CharactersIdentity.POT, ImageURL.POT, Items.EMPTY_ITEM),
    SNAKES(Coordinates.SNAKES.getCoordinates(),  CharactersIdentity.SNAKES, ImageURL.SNAKES_SKIN, Items.SNAKES),
    SPIDERS(Coordinates.SPIDERS.getCoordinates(),  CharactersIdentity.SPIDERS, ImageURL.SPIDER, Items.SPIDERS),
    WINDOWSILL(Coordinates.WINDOWSILL.getCoordinates(),  CharactersIdentity.WINDOWSILL, ImageURL.WINDOWSILL, Items.EMPTY_ITEM);

    private final int[] coordinates;
    private final CharactersIdentity npcId;
    private final ImageURL imageURL;
    private boolean isToBeActivated;
    private final Items itemDropped;

    /**
     * Constructs a character with the specified coordinates and index.
     *
     * @param coordinates the coordinates of the character
     * @param npcId
     * @param imageURL
     */
    NonPlayableCharacters(int[] coordinates, CharactersIdentity npcId, ImageURL imageURL, Items itemDropped) {
        this.coordinates = coordinates;
        this.npcId = npcId;
        this.imageURL = imageURL;
        this.itemDropped = itemDropped;
        this.isToBeActivated = false;
    }

    /**
     * Returns the coordinates of the character.
     *
     * @return the coordinates of the character
     */
    public int[] getCoordinates() {
        return coordinates;
    }

    /**
     * Returns the index of the character.
     *
     * @return the index of the character
     */

    public boolean isToBeActivated() {
        return isToBeActivated;
    }

    public void setToBeActivated(boolean isToBeActivated) {
        this.isToBeActivated = isToBeActivated;
    }

    public CharactersIdentity getNpcId() {
        return npcId;
    }

    public String getImageURL() {
        return imageURL.getURL();
    }

    public Items getItemDropped() {
        return itemDropped;
    }
}


