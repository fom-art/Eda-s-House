package com.example.edashouse.model.constants.characters;

import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.constants.characters_data.Coordinates;
import com.example.edashouse.model.constants.utils.ImageURL;


/**
 * Constants representing different characters in the game.
 */
public enum NonPlayableCharacters {
    BELLFLOWER(Coordinates.BELLFLOWER.getCoordinates(),  CharactersIdentity.BELLFLOWER, ImageURL.BELLFLOWER),
    BUGS(Coordinates.BUGS.getCoordinates(),  CharactersIdentity.BUGS, ImageURL.BUGS),
    HUMANS_GARBAGE(Coordinates.HUMANS_GARBAGE.getCoordinates(),  CharactersIdentity.HUMANS_GARBAGE, ImageURL.HUMANS_GARBAGE),
    KING(Coordinates.KING.getCoordinates(),  CharactersIdentity.KING, ImageURL.KING),
    MOUSES(Coordinates.MOUSES.getCoordinates(),  CharactersIdentity.MOUSES, ImageURL.MOUSE),
    POT(Coordinates.POT.getCoordinates(),  CharactersIdentity.POT, ImageURL.POT),
    SNAKES(Coordinates.SNAKES.getCoordinates(),  CharactersIdentity.SNAKES, ImageURL.SNAKES_SKIN),
    SPIDERS(Coordinates.SPIDERS.getCoordinates(),  CharactersIdentity.SPIDERS, ImageURL.SPIDER),
    WINDOWSILL(Coordinates.WINDOWSILL.getCoordinates(),  CharactersIdentity.WINDOWSILL, ImageURL.WINDOWSILL);

    private final int[] coordinates;
    private final CharactersIdentity npcId;
    private final ImageURL imageURL;
    private boolean isToBeActivated;

    /**
     * Constructs a character with the specified coordinates and index.
     *
     * @param coordinates the coordinates of the character
     * @param npcId
     * @param imageURL
     */
    NonPlayableCharacters(int[] coordinates, CharactersIdentity npcId, ImageURL imageURL) {
        this.coordinates = coordinates;
        this.npcId = npcId;
        this.imageURL = imageURL;
        isToBeActivated = false;
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
    }


