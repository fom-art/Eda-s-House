package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.NPCIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Spiders extends NonPlayableCharacters {
    public Spiders() {
        setImageURL(ImageURL.SPIDER.getURL());
        setCharacter(Characters.SPIDERS);
        setCharacterViewCode(Characters.SPIDERS);
        setNPCId(NPCIdentity.SPIDERS);
    }
}
