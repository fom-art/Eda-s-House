package com.example.edashouse.model.units;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.NPCIdentity;

/**
 * A base class for non-playable characters in the game.
 */
public abstract class NonPlayableCharacters {
    private String imageURL;
    private Characters character;
    private Integer characterViewCode;
    private boolean isToBeActivated = false;
    private NPCIdentity npcId;

    /**
     * Gets the image URL of the non-playable character.
     *
     * @return the image URL
     */
    public String getImageURL() {
        return this.imageURL;
    }

    /**
     * Gets the character type of the non-playable character.
     *
     * @return the character type
     */
    public Characters getCharacter() {
        return this.character;
    }

    /**
     * Gets the view code of the non-playable character.
     *
     * @return the view code
     */
    public Integer getCharacterViewCode() {
        return this.characterViewCode;
    }

    /**
     * Gets the activation status of the non-playable character.
     *
     * @return true if the character is to be activated, false otherwise
     */
    public boolean getIsToBeActivated() {
        return this.isToBeActivated;
    }

    /**
     * Gets the identity of the non-playable character.
     *
     * @return the identity
     */
    public NPCIdentity getNPCId() {
        return this.npcId;
    }

    /**
     * Sets the image URL of the non-playable character.
     *
     * @param imageURL the image URL to set
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Sets the character type of the non-playable character.
     *
     * @param character the character type to set
     */
    public void setCharacter(Characters character) {
        this.character = character;
    }

    /**
     * Sets the view code of the non-playable character.
     *
     * @param viewIndexes the view indexes to set
     */
    public void setCharacterViewCode(Characters viewIndexes) {
        this.characterViewCode = viewIndexes.getIndex();
    }

    /**
     * Sets the activation status of the non-playable character.
     *
     * @param isToBeActivated true if the character is to be activated, false otherwise
     */
    public void setIsToBeActivated(boolean isToBeActivated) {
        this.isToBeActivated = isToBeActivated;
    }

    /**
     * Sets the identity of the non-playable character.
     *
     * @param npcId the identity to set
     */
    public void setNPCId(NPCIdentity npcId) {
        this.npcId = npcId;
    }
}
