package com.example.edashouse.model.utils;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Utility class for handling the logic related to potion creation and ingredients.
 */
public class PotionsLogicHandler {

    /**
     * Creates a potion based on the items present in the Pot object.
     *
     * @param potLogic the Pot object containing the items
     */
    public static void createPotion(PotLogic potLogic) {
        LoggingHandler.logInfo("Potion is to be made");
        Items[] ingredientsArray = getArrayFromList(potLogic.getItemsPut());

        Potions potion = getPotionFromIngredients(ingredientsArray);
        Items snakeOilSlot;

        if (potion == null) {
            snakeOilSlot = createSnakesOilFromIngredients(ingredientsArray);
            if (snakeOilSlot != null) {
                potLogic.setItemResult(snakeOilSlot);
            } else {
                potLogic.setPotionResult(Potions.SUSPICIOUS_POTION);
            }
        } else {
            potLogic.setPotionResult(potion);
        }
    }

    /**
     * Determines the potion that can be created from the given ingredients.
     *
     * @param ingredients the array of items representing the ingredients
     * @return the potion created from the ingredients, or null if no valid potion can be created
     */
    public static Potions getPotionFromIngredients(Items[] ingredients) {
        Arrays.sort(ingredients);
        Potions result = null;
        for (Potions potion : Potions.values()) {
            Arrays.sort(potion.getRecipe());
            if (Arrays.equals(potion.getRecipe(), ingredients)) {
                result = potion;
                break;
            }
        }
        return result;
    }

    /**
     * Converts an ArrayList of Items into an array of Items.
     *
     * @param list the ArrayList of Items
     * @return the array of Items
     */
    private static Items[] getArrayFromList(ArrayList<Items> list) {
        return new Items[]{list.get(0), list.get(1), list.get(2)};
    }

    /**
     * Creates Snakes Oil item from the given ingredients if possible.
     *
     * @param ingredients the array of items representing the ingredients
     * @return the Snakes Oil item if it can be created, or null otherwise
     */
    private static Items createSnakesOilFromIngredients(Items[] ingredients) {
        Items[] snakesOilRecipe = new Items[]{Items.SPIDERS, Items.SNAKES, Items.BELLFLOWER};
        Arrays.sort(snakesOilRecipe);
        Arrays.sort(ingredients);
        if (Arrays.equals(snakesOilRecipe, ingredients)) {
            return Items.SNAKES_OIL;
        } else {
            return null;
        }
    }
}
