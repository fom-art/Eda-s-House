package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.NPCIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Bugs extends NonPlayableCharacters {
    public Bugs() {
        setImageURL(ImageURL.BUGS.getURL());
        setCharacter(Characters.BUGS);
        setCharacterViewCode(Characters.BUGS);
        setNPCId(NPCIdentity.BUGS);
    }
}
