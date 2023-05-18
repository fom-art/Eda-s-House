package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.BasicCoordinates;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class WindowSill  extends NonPlayableCharacters {
    public WindowSill() {
        setCoordinates(BasicCoordinates.WINDOWSILL.getCoordinates());
        setImageURL(ImageURL.WINDOWSILL.getURL());
        setCharacterCode(Characters.WINDOWSILL);
    }
}
