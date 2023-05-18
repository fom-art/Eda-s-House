package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.BasicCoordinates;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.ViewIndexes;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Windowsill extends NonPlayableCharacters {
    public Windowsill() {
        setCoordinates(BasicCoordinates.WINDOWSILL.getCoordinates());
        setImageURL(ImageURL.WINDOWSILL.getURL());
        setCharacterCode(Characters.WINDOWSILL);
        setCharacterViewCode(ViewIndexes.WINDOWSILL);
    }
}
