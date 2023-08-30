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
    private final Scene scene;
    private final MovementActions movementActions;
    private final ActivationActions activationActions;
    private final NonPlayableCharactersActivator npcView;
    private final GameLogicHandler gameLogicHandler;

    /**
     * Constructs a new instance of SceneListenersSetter.
     *
     * @param scene            the scene to set up listeners for
     * @param npcView          the non-playable characters activator
     * @param layout           the game layout
     * @param gameLogicHandler the game logic handler
     * @param movementActions  the movement actions
     * @param activationActions the activation actions
     */
    public SceneListenersSetter(Scene scene, NonPlayableCharactersActivator npcView, Layout layout,
                                GameLogicHandler gameLogicHandler, MovementActions movementActions,
                                ActivationActions activationActions) {
        this.scene = scene;
        this.npcView = npcView;
        this.gameLogicHandler = gameLogicHandler;
        this.movementActions = movementActions;
        this.activationActions = activationActions;
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
                case LEFT -> movementActions.receiveAction(ActionsConstants.LEFT_KEY_PRESSED, false);
                case RIGHT -> movementActions.receiveAction(ActionsConstants.RIGHT_KEY_PRESSED, false);
                case UP -> movementActions.receiveAction(ActionsConstants.UP_KEY_PRESSED, false);
                case DOWN -> movementActions.receiveAction(ActionsConstants.DOWN_KEY_PRESSED, false);
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

    /**
     * Returns the scene associated with the listeners.
     *
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Returns the movement actions instance.
     *
     * @return the movement actions
     */
    public MovementActions getMovementActions() {
        return movementActions;
    }

    /**
     * Returns the activation actions instance.
     *
     * @return the activation actions
     */
    public ActivationActions getActivationActions() {
        return activationActions;
    }

    /**
     * Returns the non-playable characters activator instance.
     *
     * @return the non-playable characters activator
     */
    public NonPlayableCharactersActivator getNpcView() {
        return npcView;
    }
}
