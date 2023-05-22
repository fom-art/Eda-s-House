package com.example.edashouse.controller;

import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameController extends Application {
    //TODO  Good reference https://github.com/smowgli/space-runner-game-javafx/blob/main/src/view/GameViewManager.java
    //TODO  Add interactions with objects
    //TODO  Add objectsOnActivatedActions
    //TODO  Add itemHeld for a witch
    //TODO  Do refactoring, especially related to CVM

    private Layout layout;
    private NonPlayableCharactersActivator npcView;

    @Override
    public void start(Stage stage) throws Exception {
        layout = new Layout(stage);
        layout.addWitch();
        npcView = new NonPlayableCharactersActivator(layout);
        SceneListenersSetter scene = new SceneListenersSetter(layout.getScene(), layout, npcView);
    }
}
