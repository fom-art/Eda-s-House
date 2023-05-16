package com.example.edashouse.model.units;

import com.example.edashouse.model.constants.Characters;

public abstract class NonPlayableCharacters {
    private int[] coordinates;
    private String imageURL;
    private Characters characterCode;

    public int[] getCoordinates() {
        return this.coordinates;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Characters getCharacterCode() {
        return this.characterCode;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCharacterCode(Characters characterCode) {
        this.characterCode = characterCode;
    }
}
