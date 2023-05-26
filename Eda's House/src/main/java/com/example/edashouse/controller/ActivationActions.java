package com.example.edashouse.controller;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.NPCIdentity;
import com.example.edashouse.model.constants.Potions;
import com.example.edashouse.model.units.NonPlayableCharacters;
import com.example.edashouse.model.units.Witch;
import com.example.edashouse.model.units.npc.Pot;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.model.utils.PotionsLogicHandler;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;

/**
 * This class handles the actions triggered by player activation events.
 * It interacts with non-playable characters (NPCs) and performs corresponding actions.
 */
public class ActivationActions {
    private Layout layout;
    private final GameLogicHandler gameLogicHandler;
    private NonPlayableCharactersActivator npcView;
    private Witch witch;
    private Pot pot;

    /**
     * Constructs a new instance of ActivationActions.
     *
     * @param layout            the game layout
     * @param npcView           the view of non-playable characters
     * @param gameLogicHandler  the game logic handler
     */
    public ActivationActions(Layout layout, NonPlayableCharactersActivator npcView, GameLogicHandler gameLogicHandler) {
        this.layout = layout;
        this.gameLogicHandler = gameLogicHandler;
        this.npcView = npcView;
        this.witch = layout.getWitch();
        this.pot = npcView.getPot();
    }

    /**
     * Receives an activation action and performs the corresponding action.
     *
     * @param action  the activation action
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
            makeAnAction(npc.getNPCId());
        }
    }

    /**
     * Performs the action associated with the non-playable character (NPC) identity.
     *
     * @param npcId  the NPC identity
     */
    private void makeAnAction(NPCIdentity npcId) {
        switch (npcId) {
            case BELLFLOWER, BUGS, HUMANS_GARBAGE, KING, MOUSES, SNAKES, SPIDERS -> pickAnItem(npcId);
            case POT -> interactWithPot();
            case WINDOWSILL -> sellThePotion();
        }
    }

    /**
     * Picks up an item from the non-playable character (NPC).
     *
     * @param npcIdentity  the NPC identity
     */
    private void pickAnItem(NPCIdentity npcIdentity) {
        if (witch.getPotionHeld() == null) {
            LoggingHandler.logInfo("Item picked: " + npcIdentity);
            witch.setItemHeld(npcIdentity.getNPCItem());
        }
    }

    /**
     * Interacts with the pot non-playable character (NPC).
     */
    private void interactWithPot() {
        Items itemPut = witch.getItemHeld();
        if (pot.getPotionResult() == null && pot.getItemResult() == null) {
            if (itemPut != null) {
                putItemToPot(witch, pot, itemPut);
                if (checkIfPotIsFull(pot)) {
                    startMakingPotion(pot);
                    pot.clear();
                }
            }
        } else {
            if (pot.getPotionResult() != null) {
                LoggingHandler.logInfo("Potion held: " + pot.getPotionResult());
                witch.setPotionHeld(pot.getPotionResult());
                pot.setPotionResult(null);
            } else {
                LoggingHandler.logInfo("Item held: " + pot.getItemResult());
                witch.setItemHeld(pot.getItemResult());
                pot.setItemResult(null);
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
     * @param witch     the witch character
     * @param pot       the pot non-playable character (NPC)
     * @param itemPut   the item to put into the pot
     */
    private void putItemToPot(Witch witch, Pot pot, Items itemPut) {
        LoggingHandler.logInfo("Item " + itemPut + " is put in the pot");
        witch.setItemHeld(null);
        pot.addItemToPot(itemPut);
    }

    /**
     * Checks if the pot is full with items.
     *
     * @param pot  the pot non-playable character (NPC)
     * @return true if the pot is full, false otherwise
     */
    private boolean checkIfPotIsFull(Pot pot) {
        return pot.getItemsPut().size() == 3;
    }

    /**
     * Starts the process of making a potion with the pot non-playable character (NPC).
     *
     * @param pot  the pot non-playable character (NPC)
     */
    private void startMakingPotion(Pot pot) {
        PotionsLogicHandler.createPotion(pot);
    }
}
