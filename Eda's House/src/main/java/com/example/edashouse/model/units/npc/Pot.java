package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.BasicCoordinates;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Pot  extends NonPlayableCharacters {
    public Pot() {
        setCoordinates(BasicCoordinates.POT.getCoordinates());
        setImageURL(ImageURL.POT.getURL());
        setCharacterCode(Characters.POT);
    }
}
