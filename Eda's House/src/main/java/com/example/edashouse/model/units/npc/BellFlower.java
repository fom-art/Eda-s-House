package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.utils.ImageURL;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class BellFlower extends NonPlayableCharacters {
    public BellFlower() {
        setImageURL(ImageURL.BELLFLOWER.getURL());
        setCharacter(Characters.BELLFLOWER);
        setCharacterViewCode(Characters.BELLFLOWER);
        setNPCId(CharactersIdentity.BELLFLOWER);
    }
}
