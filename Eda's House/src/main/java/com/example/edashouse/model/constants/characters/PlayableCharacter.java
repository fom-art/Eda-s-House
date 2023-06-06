package com.example.edashouse.model.constants.characters;

import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.constants.characters_data.Coordinates;
import com.example.edashouse.model.constants.utils.ImageURL;

public enum PlayableCharacter {
    WITCH(Coordinates.WITCH.getCoordinates(), CharactersIdentity.WITCH, ImageURL.WITCH_FRONT, ActionsConstants.DOWN_KEY_PRESSED);

    private final int[] coordinates;
    private final CharactersIdentity charactersIdentity;
    private ImageURL imageURL;
    private Items itemHeld;
    private ActionsConstants lastAction;
    private Potions potionHeld;

    PlayableCharacter(int[] coordinates, CharactersIdentity charactersIdentity, ImageURL imageURL, ActionsConstants lastAction) {
        this.coordinates = coordinates;
        this.charactersIdentity = charactersIdentity;
        this.imageURL = imageURL;
        this.itemHeld = null;
        this.lastAction = lastAction;
        this.potionHeld = null;
    }


    public int[] getCoordinates() {
        return coordinates;
    }

    public CharactersIdentity getCharactersIdentity() {
        return charactersIdentity;
    }

    public ImageURL getImageURL() {
        return imageURL;
    }

    public void setImageURL(ImageURL imageURL) {
        this.imageURL = imageURL;
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
}
