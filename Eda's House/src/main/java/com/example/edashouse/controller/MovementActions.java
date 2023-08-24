package com.example.edashouse.controller;

import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
import com.example.edashouse.model.constants.characters.PlayableCharacter;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;

import static com.example.edashouse.model.utils.CoordinatesCounter.getNextSquareFromDirection;

/**
 * Controller class that handles movement actions in the game.
 */
public record MovementActions(Layout layout, NonPlayableCharactersActivator npcView,
                              GameLogicHandler gameLogicHandler) {
    /**
     * Constructs a new instance of MovementActions.
     *
     * @param layout           the game layout
     * @param npcView          the view of non-playable characters
     * @param gameLogicHandler the game logic handler
     */
    public MovementActions {
    }

    /**
     * Receives an action and performs the corresponding movement.
     *
     * @param action the action to be performed
     */
    public void receiveAction(ActionsConstants action, boolean isTest) {
        switch (action) {
            case LEFT_KEY_PRESSED, RIGHT_KEY_PRESSED,
                    UP_KEY_PRESSED, DOWN_KEY_PRESSED -> moveHero(action, isTest);
        }
    }

    /**
     * Moves the playable character in the specified direction.
     *
     * @param action the direction of the movement
     */
    private void moveHero(ActionsConstants action, boolean isTest) {
        PlayableCharacter witch = layout().getWitch();
        int[] witchCoordinates = witch.getCoordinates();
        witch.setLastAction(action);
        int[] directionSquare = getNextSquareFromDirection(action, witchCoordinates, false);
        layout().updateWitchPosition(directionSquare);
        layout().updateWitchImage(action, isTest);
        setNPCActivation(witch);
    }

    /**
     * Sets the nearest non-playable character (NPC) as active based on the playable character's position.
     *
     * @param witch the playable character
     */
    private void setNPCActivation(PlayableCharacter witch) {
        unsetNPCActivation();
        setNearestNPCActive(witch);
    }

    /**
     * Sets the nearest non-playable character (NPC) as active based on the playable character's position and last action.
     *
     * @param witch the playable character
     */
    private void setNearestNPCActive(PlayableCharacter witch) {
        ActionsConstants lastAction = witch.getLastAction();
        int[] witchCoordinates = witch.getCoordinates();
        int[] nextSquareCoordinates = getNextSquareFromDirection(lastAction, witchCoordinates, true);

        NonPlayableCharacters nearestNPC = gameLogicHandler().getObjectFromCoordinates(nextSquareCoordinates);
        if (nearestNPC != null) {
            gameLogicHandler().setNPCActive(nearestNPC);
            npcView().setActive(nearestNPC);
        }
    }

    /**
     * Unsets the active non-playable character (NPC) and updates the view.
     */
    private void unsetNPCActivation() {
        gameLogicHandler().unSetNPCActive();
        npcView().unsetActivation();
    }
}
