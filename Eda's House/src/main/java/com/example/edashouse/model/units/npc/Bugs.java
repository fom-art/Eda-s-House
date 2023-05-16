package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Bugs extends NonPlayableCharacters {
    public Bugs() {
        setCoordinates(new int[]{

        });
        setImageURL(ImageURL.BUGS.getURL());
        setCharacterCode(Characters.BUGS);
    }
}
