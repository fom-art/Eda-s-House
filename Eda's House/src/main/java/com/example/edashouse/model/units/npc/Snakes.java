package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.BasicCoordinates;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.ViewIndexes;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Snakes  extends NonPlayableCharacters {
    public Snakes() {
        setCoordinates(BasicCoordinates.SNAKES.getCoordinates());
        setImageURL(ImageURL.SNAKES_SKIN.getURL());
        setCharacterCode(Characters.SNAKES);
        setCharacterViewCode(ViewIndexes.SNAKES);
    }
}
