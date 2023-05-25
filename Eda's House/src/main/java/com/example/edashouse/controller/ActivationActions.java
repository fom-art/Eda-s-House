package com.example.edashouse.controller;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.model.constants.NPCIdentity;
import com.example.edashouse.model.potions.Potion;
import com.example.edashouse.model.units.NonPlayableCharacters;
import com.example.edashouse.model.units.Witch;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;

public class ActivationActions {
    private Layout layout;
    private final GameLogicHandler gameLogicHandler;
    private NonPlayableCharactersActivator npcView;
    private Witch witch;

    public ActivationActions(Layout layout, NonPlayableCharactersActivator npcView, GameLogicHandler gameLogicHandler) {
        this.layout = layout;
        this.gameLogicHandler = gameLogicHandler;
        this.npcView = npcView;
        this.witch = layout.getWitch();
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
            case POT -> putAnItemToThePot();
            case WINDOWSILL -> sellThePotion();
        }
    }

    private void pickAnItem(NPCIdentity npcIdentity) {
        if (witch.getPotionHeld() == null) {
            LoggingHandler.logInfo("Item picked: " + npcIdentity);
            witch.setItemHeld(npcIdentity);
        }
    }

    private void putAnItemToThePot() {
        NPCIdentity itemPut = witch.getItemHeld();
        Potion potionPut = witch.getPotionHeld();
        if (itemPut != null) {
            LoggingHandler.logInfo("Item " + itemPut + " is put in the pot");
            witch.setItemHeld(null);
        }
        if (potionPut != null) {
            LoggingHandler.logInfo("Potion " + potionPut + " is put in the pot");
            witch.setPotionHeld(null);
        }
    }

    private void sellThePotion() {
        Potion potionSold = witch.getPotionHeld();
        if (potionSold != null) {
            LoggingHandler.logInfo("Potion" + potionSold + " sold");
            witch.setPotionHeld(null);
        }
    }
}
