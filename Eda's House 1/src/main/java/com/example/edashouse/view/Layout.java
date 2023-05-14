package com.example.edashouse.view;


import com.example.edashouse.model.utils.Constants;
import com.example.edashouse.model.utils.ImageURL;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;

public class Layout {
    private HashMap<Integer, Object> objectHashMap = new HashMap<>();
    private GridPane pane;
    private Scene scene;
    private Stage stage;


    public Layout(Stage stage) {
        this.stage = stage;
        setGame();
    }


    public void setGame() {
        setPane();
        setScene();
        setStage();
    }

    private void setPane() {
        pane = new GridPane();
        pane.setPrefSize(Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(),
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue());
        pane.setGridLinesVisible(true);
        setPaneBackground();
    }

    private void setScene() {
        scene = new Scene(pane, Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(), Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue());
    }

    private void setStage() {
        stage.setTitle("Eda's House");
        stage.setScene(scene);
//        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    private void setPaneBackground() {
        Image backgroundImage = new Image(ImageURL.BACKGROUND.getURL(),Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(), Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(), false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        pane.setBackground(new Background(background));
    }














    public void receiveCharacterChanges(Character character) {
        updateCharacterChanges();
    }

    private void setObjects(GridPane layout) {

    }

    private void linkObjectsAndGrid() {

    }

    private void updateCharacterChanges() {

    }
}
