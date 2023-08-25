package com.example.edashouse.controller;

import com.example.edashouse.model.utils.PotLogic;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.ItemsPickedActivator;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * The main game controller class that extends the JavaFX Application class.
 * It initializes the stage and sets up the game layout.
 */
public class GameController extends Application {
    private Layout layout;
    private NonPlayableCharactersActivator npcView;
    private ItemsPickedActivator itemPickedView;
    private SceneListenersSetter sceneListenersSetter;
    private boolean isTest;


    private GameLogicHandler gameLogicHandler;


    /**
     * Starts the application by initializing the stage and setting up the layout.
     *
     * @param stage the primary stage for the application
     * @throws Exception if an exception occurs during the initialization process
     */
    @Override
    public void start(Stage stage) {
        setTest(false);
        setLayout(new Layout(stage, getIfTest()));
        getLayout().addWitch(getIfTest());

        setNpcView(new NonPlayableCharactersActivator(layout, getIfTest()));
        setItemPickedView(new ItemsPickedActivator(layout, isTest));
        setGameLogicHandler(new GameLogicHandler());
        setSceneListenersSetter(new SceneListenersSetter(layout.getScene(), npcView, layout, gameLogicHandler,
                new MovementActions(layout, npcView, gameLogicHandler),
                new ActivationActions( gameLogicHandler,
                        new PotLogic(new ArrayList<>()), layout.getWitch())));
    }

    public void startForTest(Stage stage, Scene scene, GameLogicHandler gameLogicHandler) {
        setTest(true);
        setLayout(new Layout(stage, getIfTest()));
        getLayout().addWitch(getIfTest());

        setNpcView(new NonPlayableCharactersActivator(layout, getIfTest()));
        setItemPickedView(new ItemsPickedActivator(layout, isTest));
        setGameLogicHandler(gameLogicHandler);
        setSceneListenersSetter(new SceneListenersSetter(scene, npcView, layout, gameLogicHandler,
                new MovementActions(layout, npcView, gameLogicHandler),
                new ActivationActions( gameLogicHandler,
                        new PotLogic(new ArrayList<>()), layout.getWitch())));
    }

    public boolean getIfTest() {
        return this.isTest;
    }

    public void setTest(boolean test) {
        isTest = test;
    }

    public Layout getLayout() {
        return this.layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }


    public NonPlayableCharactersActivator getNpcView() {
        return this.npcView;
    }

    public void setNpcView(NonPlayableCharactersActivator npcView) {
        this.npcView = npcView;
    }


    public ItemsPickedActivator getItemPickedView() {
        return this.itemPickedView;
    }

    public void setItemPickedView(ItemsPickedActivator itemPickedView) {
        this.itemPickedView = itemPickedView;
    }


    public SceneListenersSetter getSceneListenersSetter() {
        return this.sceneListenersSetter;
    }

    public void setSceneListenersSetter(SceneListenersSetter sceneListenersSetter) {
        this.sceneListenersSetter = sceneListenersSetter;
    }

    public GameLogicHandler getGameLogicHandler() {
        return gameLogicHandler;
    }

    public void setGameLogicHandler(GameLogicHandler gameLogicHandler) {
        this.gameLogicHandler = gameLogicHandler;
    }



}
