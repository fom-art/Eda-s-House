package com.example.edashouse.model.units;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.characters_data.CharactersIdentity;
import com.example.edashouse.model.constants.utils.ImageURL;

public class Windowsill extends NonPlayableCharacters {
    public Windowsill() {
        setImageURL(ImageURL.WINDOWSILL.getURL());
        setCharacter(Characters.WINDOWSILL);
        setCharacterViewCode(Characters.WINDOWSILL);
        setNPCId(CharactersIdentity.WINDOWSILL);
    }
}