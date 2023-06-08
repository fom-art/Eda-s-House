package com.example.edashouse.controller;

import com.example.edashouse.view.ItemsPickedActivator;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main game controller class that extends the JavaFX Application class.
 * It initializes the stage and sets up the game layout.
 */
public class GameController extends Application {
    private Layout layout;
    private NonPlayableCharactersActivator npcView;
    private ItemsPickedActivator itemPickedView;
    private SceneListenersSetter sceneListenersSetter;

    /**
     * Starts the application by initializing the stage and setting up the layout.
     *
     * @param stage the primary stage for the application
     * @throws Exception if an exception occurs during the initialization process
     */
    @Override
    public void start(Stage stage) throws Exception {
        layout = new Layout(stage);
        layout.addWitch();
        npcView = new NonPlayableCharactersActivator(layout);
        itemPickedView = new ItemsPickedActivator(layout);
        sceneListenersSetter = new SceneListenersSetter(layout.getScene(), npcView, layout);
    }
}
