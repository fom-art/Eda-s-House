package com.example.edashouse.model.units;

import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;

public class Witch {
    // Coordinates will have 2 values, X and Y coordinates accordingly
    private int[] coordinates;
    private String imagePath;
    private Characters characterCode;
    private ActionsConstants lastAction;
    private Items itemHeld;
    private Potions potionHeld;

    /**
     * Creates a Witch object with the specified coordinates.
     *
     * @param coordinates the initial coordinates of the Witch
     */
    public Witch(int[] coordinates) {
        imagePath = ImageURL.WITCH_FRONT.getURL();
        characterCode = Characters.WITCH;
        this.coordinates = coordinates;
    }

    /**
     * Sets the coordinates of the Witch.
     *
     * @param coordinates the coordinates to set
     */
    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Sets the image path of the Witch based on the direction.
     *
     * @param direction the direction of the Witch
     */
    public void setImage(ActionsConstants direction) {
        switch (direction) {
            case LEFT_KEY_PRESSED -> imagePath = ImageURL.WITCH_LEFT.getURL();
            case RIGHT_KEY_PRESSED -> imagePath = ImageURL.WITCH_RIGHT.getURL();
            case UP_KEY_PRESSED -> imagePath = ImageURL.WITCH_BACK.getURL();
            case DOWN_KEY_PRESSED -> imagePath = ImageURL.WITCH_FRONT.getURL();
        }
    }

    /**
     * Sets the last action performed by the Witch.
     *
     * @param action the last action performed
     */
    public void setLastAction(ActionsConstants action) {
        this.lastAction = action;
    }

    /**
     * Sets the item held by the Witch.
     *
     * @param item the item held
     */
    public void setItemHeld(Items item) {
        this.itemHeld = item;
    }

    /**
     * Sets the potion held by the Witch.
     *
     * @param potion the potion held
     */
    public void setPotionHeld(Potions potion) {
        this.potionHeld = potion;
    }

    /**
     * Gets the coordinates of the Witch.
     *
     * @return the coordinates of the Witch
     */
    public int[] getCoordinates() {
        return coordinates;
    }

    /**
     * Gets the character code of the Witch.
     *
     * @return the character code of the Witch
     */
    public Characters getCharacterCode() {
        return characterCode;
    }

    /**
     * Gets the image path of the Witch.
     *
     * @return the image path of the Witch
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Gets the last action performed by the Witch.
     *
     * @return the last action performed by the Witch
     */
    public ActionsConstants getLastAction() {
        return lastAction;
    }

    /**
     * Gets the item held by the Witch.
     *
     * @return the item held by the Witch
     */
    public Items getItemHeld() {
        return this.itemHeld;
    }

    /**
     * Gets the potion held by the Witch.
     *
     * @return the potion held by the Witch
     */
    public Potions getPotionHeld() {
        return this.potionHeld;
    }
}
