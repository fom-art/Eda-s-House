package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Snakes  extends NonPlayableCharacters {
    public Snakes() {
        setImageURL(ImageURL.SNAKES_SKIN.getURL());
        setCharacterCode(Characters.SNAKES);
        setCharacterViewCode(Characters.SNAKES);
    }
}
