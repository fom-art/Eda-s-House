package com.example.edashouse.controller;

import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;
import javafx.scene.Scene;

/**
 * This class sets up the listeners for the scene and handles key press events.
 * The reactions to the key presses are implemented through the associated actions.
 */
public class SceneListenersSetter {
    private Scene scene;
    private MovementActions movementActions;
    private ActivationActions activationActions;
    private NonPlayableCharactersActivator npcView;
    private GameLogicHandler gameLogicHandler;

    /**
     * Constructs a new instance of SceneListenersSetter.
     *
     * @param scene   the scene to set up listeners for
     * @param layout  the game layout
     * @param npcView the view for non-playable characters
     */
    public SceneListenersSetter(Scene scene, Layout layout, NonPlayableCharactersActivator npcView) {
        this.scene = scene;
        this.gameLogicHandler = new GameLogicHandler();
        this.movementActions = new MovementActions(layout, npcView, gameLogicHandler);
        this.activationActions = new ActivationActions(layout, npcView, gameLogicHandler);
        this.npcView = npcView;
        setUp();
    }

    /**
     * Sets up the scene listeners and actions.
     */
    private void setUp() {
        setupOnKeysPressedActions();
    }

    /**
     * Sets up the key press actions for the scene.
     */
    private void setupOnKeysPressedActions() {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT -> movementActions.receiveAction(ActionsConstants.LEFT_KEY_PRESSED);
                case RIGHT -> movementActions.receiveAction(ActionsConstants.RIGHT_KEY_PRESSED);
                case UP -> movementActions.receiveAction(ActionsConstants.UP_KEY_PRESSED);
                case DOWN -> movementActions.receiveAction(ActionsConstants.DOWN_KEY_PRESSED);
                case F -> activationActions.receiveAction(ActionsConstants.F_KEY_PRESSED);
            }
        });
    }

    /**
     * Returns the game logic handler associated with the scene listeners.
     *
     * @return the game logic handler
     */
    public GameLogicHandler getGameLogicHandler() {
        return gameLogicHandler;
    }
}
