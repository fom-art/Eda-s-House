package com.example.edashouse.controller;

import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.units.Witch;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;

import static com.example.edashouse.model.utils.CoordinatesCounter.getNextSquareFromDirection;

/**
 * Controller class that handles movement actions in the game.
 */
public class MovementActions {
    private Layout layout;
    private GameLogicHandler gameLogicHandler;
    private NonPlayableCharactersActivator npcView;

    /**
     * Constructs a new instance of MovementActions.
     *
     * @param layout            the game layout
     * @param npcView           the view of non-playable characters
     * @param gameLogicHandler  the game logic handler
     */
    public MovementActions(Layout layout, NonPlayableCharactersActivator npcView, GameLogicHandler gameLogicHandler) {
        this.layout = layout;
        this.gameLogicHandler = gameLogicHandler;
        this.npcView = npcView;
    }

    /**
     * Receives an action and performs the corresponding movement.
     *
     * @param action the action to be performed
     */
    public void receiveAction(ActionsConstants action) {
        switch (action) {
            case LEFT_KEY_PRESSED, RIGHT_KEY_PRESSED,
                    UP_KEY_PRESSED, DOWN_KEY_PRESSED -> moveHero(action);
        }
    }

    private void moveHero(ActionsConstants action) {
        Witch witch = layout.getWitch();
        int[] witchCoordinates = witch.getCoordinates();
        witch.setLastAction(action);
        int[] directionSquare = getNextSquareFromDirection(action, witchCoordinates, false);
        layout.updateWitchPosition(directionSquare);
        layout.updateWitchImage(action);
        setNPCActivation(witch);
    }

    private void setNPCActivation(Witch witch) {
        unsetNPCActivation();
        setNearestNPCActive(witch);
    }

    private void setNearestNPCActive(Witch witch) {
        ActionsConstants lastAction = witch.getLastAction();
        int[] witchCoordinates = witch.getCoordinates();
        int[] nextSquareCoordinates = getNextSquareFromDirection(lastAction, witchCoordinates, true);

        Characters nearestNPC = gameLogicHandler.getObjectFromCoordinates(nextSquareCoordinates);
        if (nearestNPC != null) {
            gameLogicHandler.setNPCActive(nearestNPC);
            npcView.setActive(nearestNPC);
        }
    }

    private void unsetNPCActivation() {
        gameLogicHandler.unSetNPCActive();
        npcView.unsetActivation();
    }
}