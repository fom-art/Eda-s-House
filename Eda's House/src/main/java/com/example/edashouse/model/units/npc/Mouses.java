package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.NPCIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Mouses extends NonPlayableCharacters {
    public Mouses() {
        setImageURL(ImageURL.MOUSE.getURL());
        setCharacter(Characters.MOUSES);
        setCharacterViewCode(Characters.MOUSES);
        setNPCId(NPCIdentity.MOUSES);
    }
}
