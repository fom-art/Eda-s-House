package com.example.edashouse.model.utils;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;

import java.util.ArrayList;
import java.util.Arrays;

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

    private static Potions getPotionFromIngredients(Items[] ingredients) {
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

    private static Items[] getArrayFromList(ArrayList<Items> list) {
        return new Items[]{list.get(0), list.get(1), list.get(2)};
    }

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
