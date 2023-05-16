package com.example.edashouse.controller;

import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.view.Layout;
import javafx.scene.Scene;

//This class contains gets the Scene, and sets it's reaction to some keys being.
//The reactions will be implementing the class Actions
public class SceneListenersSetter {
    private Scene scene;
    private Actions actions;

    public SceneListenersSetter(Scene scene, Layout layout) {
        this.scene = scene;
        this.actions = new Actions(layout);
        setUp();
    }

    private void setUp() {
        setupOnKeysPressedActions();
    }

    private void setupOnKeysPressedActions() {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT -> actions.receiveAction(ActionsConstants.LEFT_KEY_PRESSED);
                case RIGHT -> actions.receiveAction(ActionsConstants.RIGHT_KEY_PRESSED);
                case UP -> actions.receiveAction(ActionsConstants.UP_KEY_PRESSED);
                case DOWN -> actions.receiveAction(ActionsConstants.DOWN_KEY_PRESSED);
                case F -> actions.receiveAction(ActionsConstants.F_KEY_PRESSED);
                case ESCAPE -> actions.receiveAction(ActionsConstants.ESC_KEY_PRESSED);
            }
        });
    }
}
