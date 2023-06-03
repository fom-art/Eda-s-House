package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.utils.ImageURL;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class King extends NonPlayableCharacters {
    public King() {
        setImageURL(ImageURL.KING.getURL());
        setCharacter(Characters.KING);
        setCharacterViewCode(Characters.KING);
        setNPCId(CharactersIdentity.KING);
    }
}
