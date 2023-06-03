package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.utils.ImageURL;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class HumansGarbage extends NonPlayableCharacters {
    public HumansGarbage() {
        setImageURL(ImageURL.HUMANS_GARBAGE.getURL());
        setCharacter(Characters.HUMANS_GARBAGE);
        setCharacterViewCode(Characters.HUMANS_GARBAGE);
        setNPCId(CharactersIdentity.HUMANS_GARBAGE);
    }
}
