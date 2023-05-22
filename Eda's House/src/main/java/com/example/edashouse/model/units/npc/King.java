package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.NPCIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class King extends NonPlayableCharacters {
    public King() {
        setImageURL(ImageURL.KING.getURL());
        setCharacter(Characters.KING);
        setCharacterViewCode(Characters.KING);
        setNPCId(NPCIdentity.KING);
    }
}
