package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.utils.ImageURL;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Snakes  extends NonPlayableCharacters {
    public Snakes() {
        setImageURL(ImageURL.SNAKES_SKIN.getURL());
        setCharacter(Characters.SNAKES);
        setCharacterViewCode(Characters.SNAKES);
        setNPCId(CharactersIdentity.SNAKES);
    }
}
