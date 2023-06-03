package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.utils.ImageURL;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Spiders extends NonPlayableCharacters {
    public Spiders() {
        setImageURL(ImageURL.SPIDER.getURL());
        setCharacter(Characters.SPIDERS);
        setCharacterViewCode(Characters.SPIDERS);
        setNPCId(CharactersIdentity.SPIDERS);
    }
}
