package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class BellFlower extends NonPlayableCharacters {
    public BellFlower() {
        setImageURL(ImageURL.BELLFLOWER.getURL());
        setCharacterCode(Characters.BELLFLOWER);
        setCharacterViewCode(Characters.BELLFLOWER);
    }

}
