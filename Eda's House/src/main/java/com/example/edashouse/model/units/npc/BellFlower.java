package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.BasicCoordinates;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class BellFlower extends NonPlayableCharacters {
    public BellFlower() {
        setCoordinates(BasicCoordinates.BELLFLOWER.getCoordinates());
        setImageURL(ImageURL.BELLFLOWER.getURL());
        setCharacterCode(Characters.BELLFLOWER);
    }
}
