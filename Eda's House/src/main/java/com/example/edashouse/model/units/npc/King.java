package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.BasicCoordinates;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.ViewIndexes;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class King extends NonPlayableCharacters {
    public King() {
        setCoordinates(BasicCoordinates.KING.getCoordinates());
        setImageURL(ImageURL.KING.getURL());
        setCharacterCode(Characters.KING);
        setCharacterViewCode(ViewIndexes.KING);
    }
}
