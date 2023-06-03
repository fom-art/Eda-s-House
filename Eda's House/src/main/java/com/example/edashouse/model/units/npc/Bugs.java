package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.utils.ImageURL;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Bugs extends NonPlayableCharacters {
    public Bugs() {
        setImageURL(ImageURL.BUGS.getURL());
        setCharacter(Characters.BUGS);
        setCharacterViewCode(Characters.BUGS);
        setNPCId(CharactersIdentity.BUGS);
    }
}
