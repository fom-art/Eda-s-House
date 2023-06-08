package com.example.edashouse.model.units;

import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;

import java.util.ArrayList;

public class PotLogic {
    ArrayList<Items> items;
    Potions potionResult;
    Items itemResult;

    public PotLogic() {
        items = new ArrayList<>();
    }

    public void addItemToPot(Items item) {
        items.add(item);
    }

    public ArrayList<Items> getItemsPut() {
        return this.items;
    }

    public void clear() {
        items = new ArrayList<>();
    }

    public void setPotionResult(Potions potionResult) {
        this.potionResult = potionResult;
    }

    public void setItemResult(Items itemResult) {
        this.itemResult = itemResult;
    }

    public Items getItemResult() {
        return itemResult;
    }

    public Potions getPotionResult() {
        return potionResult;
    }
}
