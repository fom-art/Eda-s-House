package com.example.edashouse.controller;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.model.constants.Items;
import com.example.edashouse.model.constants.NPCIdentity;
import com.example.edashouse.model.potions.Potion;
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
            case POT -> putToThePot();
            case WINDOWSILL -> sellThePotion();
        }
    }

    private void pickAnItem(NPCIdentity npcIdentity) {
        if (witch.getPotionHeld() == null) {
            LoggingHandler.logInfo("Item picked: " + npcIdentity);
            witch.setItemHeld(npcIdentity.getNPCItem());
        }
    }

    private void putToThePot() {
        Items itemPut = witch.getItemHeld();
        Potion potionPut = witch.getPotionHeld();
        if (itemPut != null) {
            putItemToPot(witch, pot, itemPut);
            if (checkIfPotIsFull(pot)) {
                startMakingPotion(pot);
                pot.clear();
            }
        }
        if (potionPut != null) {
            putPotionToPot(witch, pot, potionPut);
            if (checkIfPotIsFull(pot)) {
                startMakingPotion(pot);
                pot.clear();
            }
        }
    }

    private void sellThePotion() {
        Potion potionSold = witch.getPotionHeld();
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

    private void putPotionToPot(Witch witch, Pot pot, Potion potionPut) {
        LoggingHandler.logInfo("Potion " + potionPut + " is put in the pot");
        witch.setPotionHeld(null);
        pot.addPotionToPot(potionPut);
    }

    private boolean checkIfPotIsFull(Pot pot) {
        return pot.getPotionsPut().size() + pot.getItemsPut().size() == 0;
    }

    private void startMakingPotion(Pot pot) {
        PotionsLogicHandler.createPotion(pot);
    }
}
