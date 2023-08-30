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
                new ActivationActions(gameLogicHandler,
                        new PotLogic(new ArrayList<>()), layout.getWitch())));
    }

    /**
     * Starts the application for testing purposes by initializing the stage, scene, and game logic handler.
     *
     * @param stage           the primary stage for the application
     * @param scene           the scene for the application
     * @param gameLogicHandler the game logic handler
     */
    public void startForTest(Stage stage, Scene scene, GameLogicHandler gameLogicHandler) {
        setTest(true);
        setLayout(new Layout(stage, getIfTest()));
        getLayout().addWitch(getIfTest());

        setNpcView(new NonPlayableCharactersActivator(layout, getIfTest()));
        setItemPickedView(new ItemsPickedActivator(layout, isTest));
        setGameLogicHandler(gameLogicHandler);
        setSceneListenersSetter(new SceneListenersSetter(scene, npcView, layout, gameLogicHandler,
                new MovementActions(layout, npcView, gameLogicHandler),
                new ActivationActions(gameLogicHandler,
                        new PotLogic(new ArrayList<>()), layout.getWitch())));
    }

    /**
     * Gets the testing status of the controller.
     *
     * @return true if the controller is in test mode, false otherwise
     */
    public boolean getIfTest() {
        return this.isTest;
    }

    /**
     * Sets the testing status of the controller.
     *
     * @param test true to enable test mode, false otherwise
     */
    public void setTest(boolean test) {
        isTest = test;
    }

    /**
     * Gets the layout of the game.
     *
     * @return the game layout
     */
    public Layout getLayout() {
        return this.layout;
    }

    /**
     * Sets the layout of the game.
     *
     * @param layout the game layout
     */
    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    /**
     * Gets the NonPlayableCharactersActivator view.
     *
     * @return the NonPlayableCharactersActivator view
     */
    public NonPlayableCharactersActivator getNpcView() {
        return this.npcView;
    }

    /**
     * Sets the NonPlayableCharactersActivator view.
     *
     * @param npcView the NonPlayableCharactersActivator view
     */
    public void setNpcView(NonPlayableCharactersActivator npcView) {
        this.npcView = npcView;
    }

    /**
     * Gets the ItemsPickedActivator view.
     *
     * @return the ItemsPickedActivator view
     */
    public ItemsPickedActivator getItemPickedView() {
        return this.itemPickedView;
    }

    /**
     * Sets the ItemsPickedActivator view.
     *
     * @param itemPickedView the ItemsPickedActivator view
     */
    public void setItemPickedView(ItemsPickedActivator itemPickedView) {
        this.itemPickedView = itemPickedView;
    }

    /**
     * Gets the SceneListenersSetter instance.
     *
     * @return the SceneListenersSetter instance
     */
    public SceneListenersSetter getSceneListenersSetter() {
        return this.sceneListenersSetter;
    }

    /**
     * Sets the SceneListenersSetter instance.
     *
     * @param sceneListenersSetter the SceneListenersSetter instance
     */
    public void setSceneListenersSetter(SceneListenersSetter sceneListenersSetter) {
        this.sceneListenersSetter = sceneListenersSetter;
    }

    /**
     * Gets the GameLogicHandler instance.
     *
     * @return the GameLogicHandler instance
     */
    public GameLogicHandler getGameLogicHandler() {
        return gameLogicHandler;
    }

    /**
     * Sets the GameLogicHandler instance.
     *
     * @param gameLogicHandler the GameLogicHandler instance
     */
    public void setGameLogicHandler(GameLogicHandler gameLogicHandler) {
        this.gameLogicHandler = gameLogicHandler;
    }
}
