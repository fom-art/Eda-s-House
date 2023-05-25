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

public class ActivationActions {
    private Layout layout;
    private final GameLogicHandler gameLogicHandler;
    private NonPlayableCharactersActivator npcView;
    private Witch witch;
    private Pot pot;

    public ActivationActions(Layout layout, NonPlayableCharactersActivator npcView, GameLogicHandler gameLogicHandler) {
        this.layout = layout;
        this.gameLogicHandler = gameLogicHandler;
        this.npcView = npcView;
        this.witch = layout.getWitch();
        this.pot = npcView.getPot();
    }

    public void receiveAction(ActionsConstants action) {
        switch (action) {
            case F_KEY_PRESSED -> activateNPC();
        }
    }

    private void activateNPC() {
        NonPlayableCharacters npc = gameLogicHandler.getNPCToBeActivated();
        if (npc != null) {
            makeAnAction(npc.getNPCId());
        }
    }

    private void makeAnAction(NPCIdentity npcId) {
        switch (npcId) {
            case BELLFLOWER,
                    BUGS,
                    HUMANS_GARBAGE,
                    KING,
                    MOUSES,
                    SNAKES,
                    SPIDERS -> pickAnItem(npcId);
            case POT -> interactWithPot();
            case WINDOWSILL -> sellThePotion();
        }
    }

    private void pickAnItem(NPCIdentity npcIdentity) {
        if (witch.getPotionHeld() == null) {
            LoggingHandler.logInfo("Item picked: " + npcIdentity);
            witch.setItemHeld(npcIdentity.getNPCItem());
        }
    }

    private void interactWithPot() {
        Items itemPut = witch.getItemHeld();
        if (pot.getPotionResult() == null && pot.getItemResult() == null){
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

    private void sellThePotion() {
        Potions potionSold = witch.getPotionHeld();
        if (potionSold != null) {
            LoggingHandler.logInfo("Potion" + potionSold + " sold");
            witch.setPotionHeld(null);
        }
    }

    private void putItemToPot(Witch witch, Pot pot, Items itemPut) {
        LoggingHandler.logInfo("Item " + itemPut + " is put in the pot");
        witch.setItemHeld(null);
        pot.addItemToPot(itemPut);
    }

    private boolean checkIfPotIsFull(Pot pot) {
        return pot.getItemsPut().size() == 3;
    }

    private void startMakingPotion(Pot pot) {
        PotionsLogicHandler.createPotion(pot);
    }
}
