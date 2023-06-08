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
import com.example.edashouse.view.Layout;

/**
 * This class handles the actions triggered by player activation events.
 * It interacts with non-playable characters (NPCs) and performs corresponding actions.
 */
public class ActivationActions {
    private final GameLogicHandler gameLogicHandler;
    private final PlayableCharacter witch;
    private final PotLogic potLogic;

    /**
     * Constructs a new instance of ActivationActions.
     *
     * @param layout           the game layout
     * @param gameLogicHandler the game logic handler
     */
    public ActivationActions(Layout layout, GameLogicHandler gameLogicHandler) {
        this.gameLogicHandler = gameLogicHandler;
        this.witch = layout.getWitch();
        this.potLogic = new PotLogic();
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
    private void makeAnAction(NonPlayableCharacters npc) {
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
    private void pickAnItem(Items item) {
        if (witch.getPotionHeld() == null) {
            LoggingHandler.logInfo("Item picked: " + item);
            witch.setItemHeld(item);
        }
    }

    /**
     * Interacts with the pot non-playable character (NPC).
     */
    private void interactWithPot() {
        Items itemPut = witch.getItemHeld();
        if (potLogic.getPotionResult() == null && potLogic.getItemResult() == null) {
            if (itemPut != null) {
                putItemToPot(witch, itemPut);
                if (checkIfPotIsFull()) {
                    startMakingPotion();
                    potLogic.clear();
                }
            }
        } else {
            if (potLogic.getPotionResult() != null) {
                LoggingHandler.logInfo("Potion held: " + potLogic.getPotionResult());
                witch.setPotionHeld(potLogic.getPotionResult());
                potLogic.setPotionResult(null);
            } else {
                LoggingHandler.logInfo("Item held: " + potLogic.getItemResult());
                witch.setItemHeld(potLogic.getItemResult());
                potLogic.setItemResult(null);
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
    private void putItemToPot(PlayableCharacter witch, Items itemPut) {
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

    /**
     * Starts the process of making a potion with the pot non-playable character (NPC).
     */
    private void startMakingPotion() {
        PotionsLogicHandler.createPotion(potLogic);
    }
}
