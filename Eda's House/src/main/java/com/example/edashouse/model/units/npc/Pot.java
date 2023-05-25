package com.example.edashouse.model.units.npc;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.NPCIdentity;
import com.example.edashouse.model.potions.Potion;
import com.example.edashouse.model.units.NonPlayableCharacters;

import java.util.ArrayList;

public class Pot  extends NonPlayableCharacters {
    ArrayList<Potion> potions;
    ArrayList<Items> items;
    Potion potionResult;
    Items itemResult;

    public Pot() {
        potions = new ArrayList<>();
        items = new ArrayList<>();
        setImageURL(ImageURL.POT.getURL());
        setCharacter(Characters.POT);
        setCharacterViewCode(Characters.POT);
        setNPCId(NPCIdentity.POT);
    }

    public void addPotionToPot(Potion potion) {
        potions.add(potion);
    }

    public void addItemToPot(Items item) {
        items.add(item);
    }

    public ArrayList<Potion> getPotionsPut() {
        return this.potions;
    }

    public ArrayList<Items> getItemsPut() {
        return this.items;
    }

    public void clear() {
        potions = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void setPotionResult(Potion potionResult) {
        this.potionResult = potionResult;
    }

    public void setItemResult(Items itemResult) {
        this.itemResult = itemResult;
    }

    public Items getItemResult() {
        return itemResult;
    }

    public Potion getPotionResult() {
        return potionResult;
    }
}
