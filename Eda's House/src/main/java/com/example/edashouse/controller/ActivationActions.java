package com.example.edashouse.controller;

import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.model.constants.NPCIdentity;
import com.example.edashouse.model.units.NonPlayableCharacters;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;

public class ActivationActions {
    private Layout layout;
    private GameLogicHandler gameLogicHandler;
    private NonPlayableCharactersActivator npcView;

    public ActivationActions(Layout layout, NonPlayableCharactersActivator npcView, GameLogicHandler gameLogicHandler) {
        this.layout = layout;
        this.gameLogicHandler = gameLogicHandler;
        this.npcView = npcView;
    }

    public void receiveAction(ActionsConstants action) {
        switch (action) {
            case F_KEY_PRESSED -> activateNPC();
        }
    }

    private void activateNPC() {
        NonPlayableCharacters npc = gameLogicHandler.getNPCToBeActivated();
        if (npc != null){
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

    }

    private void putAnItemToThePot() {

    }

    private void sellThePotion() {

    }
}
