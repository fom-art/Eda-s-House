package com.example.edashouse.controller;

import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;
import javafx.scene.Scene;

//This class contains gets the Scene, and sets it's reaction to some keys being.
//The reactions will be implementing the class Actions
public class SceneListenersSetter {
    private Scene scene;
    private MovementActions movementActions;
    private ActivationActions activationActions;
    private NonPlayableCharactersActivator npcView;
    private GameLogicHandler gameLogicHandler;

    public SceneListenersSetter(Scene scene, Layout layout, NonPlayableCharactersActivator npcView) {
        this.scene = scene;
        this.gameLogicHandler = new GameLogicHandler();
        this.movementActions = new MovementActions(layout, npcView, gameLogicHandler);
        this.activationActions = new ActivationActions(layout, npcView, gameLogicHandler);
        this.npcView = npcView;
        setUp();
    }

    private void setUp() {
        setupOnKeysPressedActions();
    }

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
}
