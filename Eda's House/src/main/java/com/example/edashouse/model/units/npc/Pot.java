package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.NPCIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Pot  extends NonPlayableCharacters {
    public Pot() {
        setImageURL(ImageURL.POT.getURL());
        setCharacter(Characters.POT);
        setCharacterViewCode(Characters.POT);
        setNPCId(NPCIdentity.POT);
    }
}
