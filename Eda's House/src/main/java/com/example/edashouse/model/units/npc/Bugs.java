package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.BasicCoordinates;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.ViewIndexes;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Bugs extends NonPlayableCharacters {
    public Bugs() {
        setCoordinates(BasicCoordinates.BUGS.getCoordinates());
        setImageURL(ImageURL.BUGS.getURL());
        setCharacterCode(Characters.BUGS);
        setCharacterViewCode(ViewIndexes.BUGS);
    }
}
