package com.example.edashouse.controller;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.Potions;
import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
import com.example.edashouse.model.constants.characters.PlayableCharacter;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.units.PotLogic;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.model.utils.PotionsLogicHandler;

/**
 * This class handles the actions triggered by player activation events.
 * It interacts with non-playable characters (NPCs) and performs corresponding actions.
 */
public record ActivationActions(GameLogicHandler gameLogicHandler, PotLogic potLogic, PlayableCharacter witch) {

    /**
     * Constructs a new instance of ActivationActions.
     *
     * @param gameLogicHandler the game logic handler
     */
    public ActivationActions {
    }

    /**
     * Receives an activation action and performs the corresponding action.
     *
     * @param action the activation action
     */
    public void receiveAction(ActionsConstants action) {
        switch (action) {
            case F_KEY_PRESSED -> activateNPC();
        }
    }

    /**
     * Activates the non-playable character (NPC) and performs the associated action.
     */
    private void activateNPC() {
        NonPlayableCharacters npc = gameLogicHandler.getNPCToBeActivated();
        if (npc != null) {
            makeAnAction(npc);
        }
    }

    /**
     * Performs the action associated with the non-playable character (NPC) identity.
     *
     * @param npc the non-playable character to perform the action
     */
    public void makeAnAction(NonPlayableCharacters npc) {
        switch (npc) {
            case BELLFLOWER, BUGS, HUMANS_GARBAGE, KING, MOUSES, SNAKES, SPIDERS -> pickAnItem(npc.getItemDropped());
            case POT -> interactWithPot();
            case WINDOWSILL -> sellThePotion();
        }
    }

    /**
     * Picks up an item from the non-playable character (NPC).
     *
     * @param item the item to pick up
     */
    public void pickAnItem(Items item) {
        if (witch.getPotionHeld() == null) {
            LoggingHandler.logInfo("Item picked: " + item);
            witch.setItemHeld(item);
        }
    }

    /**
     * Interacts with the pot non-playable character (NPC).
     */
    public void interactWithPot() {
        Items itemHeldByWitch = witch.getItemHeld();
        if (verifyItemPreparationStatus()) {
            if (isNextResultPotion()) {
                takePotionFromPot();
            } else {
                takeItemFromPot();
            }
        } else {
            if (verifyWitchHoldsAnItem(itemHeldByWitch)) {
                putItemToPot(witch, itemHeldByWitch);
                if (checkIfPotIsFull()) {
                    startMakingPotion();
                    potLogic.clear();
                }
            }
        }
    }

    /**
     * Sells the potion held by the witch.
     */
    private void sellThePotion() {
        Potions potionSold = witch.getPotionHeld();
        if (potionSold != null) {
            LoggingHandler.logInfo("Potion " + potionSold + " sold");
            witch.setPotionHeld(null);
        }
    }

    /**
     * Puts an item into the pot.
     *
     * @param witch   the witch character
     * @param itemPut the item to put into the pot
     */
    public void putItemToPot(PlayableCharacter witch, Items itemPut) {
        LoggingHandler.logInfo("Item " + itemPut + " is put in the pot");
        witch.setItemHeld(null);
        potLogic.addItemToPot(itemPut);
    }

    /**
     * Checks if the pot is full with items.
     *
     * @return true if the pot is full, false otherwise
     */
    private boolean checkIfPotIsFull() {
        return potLogic.getItemsPut().size() == 3;
    }

    private boolean verifyItemPreparationStatus() {
        return potLogic.getPotionResult() != null || potLogic.getItemResult() != null;
    }

    private boolean isNextResultPotion() {
        return potLogic.getPotionResult() != null;
    }

    private void takePotionFromPot() {
        LoggingHandler.logInfo("Potion held: " + potLogic.getPotionResult());
        witch.setPotionHeld(potLogic.getPotionResult());
        potLogic.setPotionResult(null);
    }

    private void takeItemFromPot() {
        LoggingHandler.logInfo("Item held: " + potLogic.getItemResult());
        witch.setItemHeld(potLogic.getItemResult());
        potLogic.setItemResult(null);
    }

    private boolean verifyWitchHoldsAnItem(Items itemHeldByWitch) {
        return itemHeldByWitch != null;
    }

    /**
     * Starts the process of making a potion with the pot non-playable character (NPC).
     */
    private void startMakingPotion() {
        PotionsLogicHandler.createPotion(potLogic);
    }

}
