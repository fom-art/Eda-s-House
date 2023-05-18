package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.BasicCoordinates;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.ViewIndexes;
import com.example.edashouse.model.units.NonPlayableCharacters;

public class Spiders extends NonPlayableCharacters {
    public Spiders() {
        setCoordinates(BasicCoordinates.SPIDERS.getCoordinates());
        setImageURL(ImageURL.SPIDER.getURL());
        setCharacterCode(Characters.SPIDERS);
        setCharacterViewCode(ViewIndexes.SPIDERS);
    }
}
