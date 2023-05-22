package com.example.edashouse.model.units;

import com.example.edashouse.model.constants.Characters;

public abstract class NonPlayableCharacters {
    private String imageURL;
    private Characters character;
    private Integer characterViewCode;
    private boolean isToBeActivated = false;


    public String getImageURL() {
        return this.imageURL;
    }

    public Characters getCharacter() {
        return this.character;
    }

    public Integer getCharacterViewCode() {
        return this.characterViewCode;
    }

    public boolean getIsToBeActivated() {
        return this.isToBeActivated;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCharacterCode(Characters character) {
        this.character = character;
    }

    public void setCharacterViewCode(Characters viewIndexes) {
        this.characterViewCode = viewIndexes.getIndex();
    }

    public void setIsToBeActivated(boolean isToBeActivated) {
        this.isToBeActivated = isToBeActivated;
    }
}
