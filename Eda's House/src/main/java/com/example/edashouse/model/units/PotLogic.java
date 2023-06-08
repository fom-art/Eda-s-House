package com.example.edashouse.model.units;

import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;

import java.util.ArrayList;

/**
 * Represents the logic for a pot in the game.
 */
public class PotLogic {
    ArrayList<Items> items;
    Potions potionResult;
    Items itemResult;

    /**
     * Constructs a PotLogic object.
     */
    public PotLogic() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the pot.
     *
     * @param item the item to add
     */
    public void addItemToPot(Items item) {
        items.add(item);
    }

    /**
     * Returns the items that have been put into the pot.
     *
     * @return the items put into the pot
     */
    public ArrayList<Items> getItemsPut() {
        return this.items;
    }

    /**
     * Clears the pot, removing all items.
     */
    public void clear() {
        items = new ArrayList<>();
    }

    /**
     * Sets the resulting potion of the pot.
     *
     * @param potionResult the resulting potion
     */
    public void setPotionResult(Potions potionResult) {
        this.potionResult = potionResult;
    }

    /**
     * Sets the resulting item of the pot.
     *
     * @param itemResult the resulting item
     */
    public void setItemResult(Items itemResult) {
        this.itemResult = itemResult;
    }

    /**
     * Returns the resulting item of the pot.
     *
     * @return the resulting item
     */
    public Items getItemResult() {
        return itemResult;
    }

    /**
     * Returns the resulting potion of the pot.
     *
     * @return the resulting potion
     */
    public Potions getPotionResult() {
        return potionResult;
    }
}
