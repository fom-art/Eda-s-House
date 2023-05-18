package com.example.edashouse.model.units;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ViewIndexes;

public abstract class NonPlayableCharacters {
    private int[] coordinates;
    private String imageURL;
    private Characters characterCode;
    private Integer characterViewCode;

    public int[] getCoordinates() {
        return this.coordinates;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public Characters getCharacterCode() {
        return this.characterCode;
    }

    public Integer getCharacterViewCode() {
        return this.characterViewCode;
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

    public void setCharacterViewCode(ViewIndexes viewIndexes) {
        this.characterViewCode = viewIndexes.getValue();
    }
}
