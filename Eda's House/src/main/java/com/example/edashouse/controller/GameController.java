package com.example.edashouse.controller;

import com.example.edashouse.view.ItemsPickedActivator;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameController extends Application {
    //TODO  Add itemHeld implementation for a witch
    //TODO  Extend the Pot functionality
    //TODO  Add throwing items in Pot
    //TODO  Add potion logic
    //TODO  Add potion creation implementation
    //TODO  Add potion appearing animation
    //TODO  Implement some tests
    //TODO  Implement file reading
    //TODO  Add JavaDoc

    private Layout layout;
    private NonPlayableCharactersActivator npcView;
    private ItemsPickedActivator itemPickedView;

    @Override
    public void start(Stage stage) throws Exception {
        layout = new Layout(stage);
        layout.addWitch();
        npcView = new NonPlayableCharactersActivator(layout);
        itemPickedView = new ItemsPickedActivator(layout);
        SceneListenersSetter scene = new SceneListenersSetter(layout.getScene(), layout, npcView);
    }
}
