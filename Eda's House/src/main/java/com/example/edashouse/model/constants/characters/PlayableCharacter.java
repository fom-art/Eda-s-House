package com.example.edashouse.model.constants.characters;

import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.constants.characters_data.Coordinates;
import com.example.edashouse.model.constants.utils.ImageURL;

/**
 * Constants representing the playable character in the game.
 */
public enum PlayableCharacter {
    WITCH(Coordinates.WITCH.getCoordinates(), CharactersIdentity.WITCH,
            ActionsConstants.DOWN_KEY_PRESSED,
            ImageURL.WITCH_FRONT, ImageURL.WITCH_BACK,
            ImageURL.WITCH_LEFT, ImageURL.WITCH_RIGHT);

    private int[] coordinates;
    private final CharactersIdentity charactersIdentity;
    private String currentImageURL;
    private Items itemHeld;
    private ActionsConstants lastAction;
    private Potions potionHeld;
    private final String imageFrontURL;
    private final String imageBackURL;
    private final String imageLeftURL;
    private final String imageRightURL;

    /**
     * Constructs a playable character with the specified coordinates, identity, last action, and image URLs.
     *
     * @param coordinates        the coordinates of the playable character
     * @param charactersIdentity the identity of the playable character
     * @param lastAction         the last action performed by the playable character
     * @param imageFrontURL      the URL of the front-facing image of the playable character
     * @param imageBackURL       the URL of the back-facing image of the playable character
     * @param imageLeftURL       the URL of the left-facing image of the playable character
     * @param imageRightURL      the URL of the right-facing image of the playable character
     */
    PlayableCharacter(int[] coordinates, CharactersIdentity charactersIdentity,
                      ActionsConstants lastAction,
                      ImageURL imageFrontURL, ImageURL imageBackURL,
                      ImageURL imageLeftURL, ImageURL imageRightURL) {
        this.coordinates = coordinates;
        this.charactersIdentity = charactersIdentity;
        this.itemHeld = null;
        this.lastAction = lastAction;
        this.potionHeld = null;
        this.imageFrontURL = imageFrontURL.getURL();
        this.imageBackURL = imageBackURL.getURL();
        this.imageLeftURL = imageLeftURL.getURL();
        this.imageRightURL = imageRightURL.getURL();
        this.currentImageURL = imageFrontURL.getURL();
    }

    /**
     * Returns the coordinates of the playable character.
     *
     * @return the coordinates of the playable character
     */
    public int[] getCoordinates() {
        return coordinates;
    }

    /**
     * Returns the identity of the playable character.
     *
     * @return the identity of the playable character
     */
    public CharactersIdentity getCharactersIdentity() {
        return charactersIdentity;
    }

    /**
     * Returns the URL of the current image of the playable character.
     *
     * @return the URL of the current image of the playable character
     */
    public String getCurrentImageURL() {
        return currentImageURL;
    }

    /**
     * Sets the coordinates of the playable character.
     *
     * @param coordinates the coordinates to set
     */
    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Sets the current image URL of the playable character.
     *
     * @param currentImageURL the current image URL to set
     */
    public void setCurrentImageURL(ImageURL currentImageURL) {
        this.currentImageURL = currentImageURL.getURL();
    }

    /**
     * Sets the current image URL of the playable character.
     *
     * @param currentImageURL the current image URL to set
     */
    public void setCurrentImageURL(String currentImageURL) {
        this.currentImageURL = currentImageURL;
    }

    /**
     * Returns the item held by the playable character.
     *
     * @return the item held by the playable character
     */
    public Items getItemHeld() {
        return itemHeld;
    }

    /**
     * Sets the item held by the playable character.
     *
     * @param itemHeld the item held to set
     */
    public void setItemHeld(Items itemHeld) {
        this.itemHeld = itemHeld;
    }

    /**
     * Returns the last action performed by the playable character.
     *
     * @return the last action performed by the playable character
     */
    public ActionsConstants getLastAction() {
        return lastAction;
    }

    /**
     * Sets the last action performed by the playable character.
     *
     * @param lastAction the last action to set
     */
    public void setLastAction(ActionsConstants lastAction) {
        this.lastAction = lastAction;
    }

    /**
     * Returns the potion held by the playable character.
     *
     * @return the potion held by the playable character
     */
    public Potions getPotionHeld() {
        return potionHeld;
    }

    /**
     * Sets the potion held by the playable character.
     *
     * @param potionHeld the potion held to set
     */
    public void setPotionHeld(Potions potionHeld) {
        this.potionHeld = potionHeld;
    }

    /**
     * Sets the current image URL of the playable character based on the provided action.
     *
     * @param action the action to set the image URL for
     */
    public void setImageURLFromAction(ActionsConstants action) {
        switch (action) {
            case DOWN_KEY_PRESSED -> setCurrentImageURL(imageFrontURL);
            case UP_KEY_PRESSED -> setCurrentImageURL(imageBackURL);
            case LEFT_KEY_PRESSED -> setCurrentImageURL(imageLeftURL);
            case RIGHT_KEY_PRESSED -> setCurrentImageURL(imageRightURL);
        }
    }
    public String getImageURLFromAction(ActionsConstants action) {
        switch (action) {
            case DOWN_KEY_PRESSED -> {
                return imageFrontURL;
            }
            case UP_KEY_PRESSED -> {
                return imageBackURL;
            }
            case LEFT_KEY_PRESSED -> {
                return imageLeftURL;
            }
            case RIGHT_KEY_PRESSED -> {
                return imageRightURL;
            }
        }
        return null;
    }
}
