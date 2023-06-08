package com.example.edashouse.model.constants.characters;

import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.constants.characters_data.Coordinates;
import com.example.edashouse.model.constants.utils.ImageURL;

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


    public int[] getCoordinates() {
        return coordinates;
    }

    public CharactersIdentity getCharactersIdentity() {
        return charactersIdentity;
    }

    public String getCurrentImageURL() {
        return currentImageURL;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setCurrentImageURL(ImageURL currentImageURL) {
        this.currentImageURL = currentImageURL.getURL();
    }

    public void setCurrentImageURL(String currentImageURL) {
        this.currentImageURL = currentImageURL;
    }

    public Items getItemHeld() {
        return itemHeld;
    }

    public void setItemHeld(Items itemHeld) {
        this.itemHeld = itemHeld;
    }

    public ActionsConstants getLastAction() {
        return lastAction;
    }

    public void setLastAction(ActionsConstants lastAction) {
        this.lastAction = lastAction;
    }

    public Potions getPotionHeld() {
        return potionHeld;
    }

    public void setPotionHeld(Potions potionHeld) {
        this.potionHeld = potionHeld;
    }

    public void setImageURLFromAction(ActionsConstants action) {
        switch (action) {
            case DOWN_KEY_PRESSED -> {
                setCurrentImageURL(imageFrontURL);
            }
            case UP_KEY_PRESSED -> {
                setCurrentImageURL(imageBackURL);
            }
            case LEFT_KEY_PRESSED -> {
                setCurrentImageURL(imageLeftURL);
            }
            case RIGHT_KEY_PRESSED -> {
                setCurrentImageURL(imageRightURL);
            }
        }
    }
}
