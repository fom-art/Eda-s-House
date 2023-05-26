package com.example.edashouse.controller;

import com.example.edashouse.view.ItemsPickedActivator;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameController extends Application {
    //TODO  Implement the item carriage on View level
    //TODO  Add potion creation implementation
    //TODO  Add potion appearing animation
    //TODO  Implement some tests
    //TODO  Implement file reading
    //TODO  Add JavaDoc

    private Layout layout;
    private NonPlayableCharactersActivator npcView;
    private ItemsPickedActivator itemPickedView;
    private SceneListenersSetter sceneListenersSetter;

    @Override
    public void start(Stage stage) throws Exception {
        layout = new Layout(stage);
        layout.addWitch();
        npcView = new NonPlayableCharactersActivator(layout);
        itemPickedView = new ItemsPickedActivator(layout);
        sceneListenersSetter = new SceneListenersSetter(layout.getScene(), layout, npcView);
    }

    public Layout getLayout() {
        return layout;
    }

    public NonPlayableCharactersActivator getNpcView() {
        return npcView;
    }

    public ItemsPickedActivator getItemPickedView() {
        return itemPickedView;
    }

    public SceneListenersSetter getSceneListenersSetter() {
        return sceneListenersSetter;
    }
}
