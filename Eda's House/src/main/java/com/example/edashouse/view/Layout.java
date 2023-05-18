package com.example.edashouse.view;


import com.example.edashouse.model.units.NonPlayableCharacters;
import com.example.edashouse.model.units.Witch;
import com.example.edashouse.model.constants.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;

public class Layout {
    private HashMap<Characters, NonPlayableCharacters> npcHashMap = new HashMap<>();
    private Witch witch;
    private Pane pane;
    private Scene scene;
    private final Stage stage;


    public Layout(Stage stage) {
        this.stage = stage;
        setGameLayout();
    }

    public Pane getPane() {
        return this.pane;
    }

    public Scene
    getScene() {
        return this.scene;
    }

    public Stage getStage() {
        return this.stage;
    }

    public Witch getWitch() {
        return this.witch;
    }


    public void setGameLayout() {
        setPane();
        setScene();
        setStage();
        test();
    }

    private void setPane() {
        pane = new Pane();
        pane.setPrefSize(Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(),
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue());
        setPaneBackground();
    }

    private void setScene() {
        scene = new Scene(pane,
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(),
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue());
    }

    private void setStage() {
        stage.setTitle("Eda's House");
        stage.setScene(scene);
        //I am not sure if I am going to use the full screen
//        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    private void setPaneBackground() {
        Image backgroundImage = new Image(ImageURL.BACKGROUND.getURL(), Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(), Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(), false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        pane.setBackground(new Background(background));
    }


    private void test() {

    }

    public void addWitch() {
        witch = new Witch(BasicCoordinates.WITCH_DEFAULT.getCoordinates());
        //Initialize the image
        Image image = new Image(witch.getImagePath());
        ImageView witchView = new ImageView(image);
        //Set sizes
        witchView.setFitWidth(Constants.GRID_CELL_SIZE.getValue());
        witchView.setFitHeight(Constants.GRID_CELL_SIZE.getValue());
        //Set coordinates
        witchView.setLayoutX(witch.getCoordinates()[0]);
        witchView.setLayoutY(witch.getCoordinates()[1]);
        //Add to Pane
        pane.getChildren().add(ViewIndexes.WITCH_VIEW.getValue(), witchView);
    }

    public void updateWitch(int[] newCoordinates, ActionsConstants direction) {
        //Update the witch data
        witch.setImage(direction);
        witch.setCoordinates(newCoordinates);
        //Get witch view from pane
        ImageView witchView = (ImageView) pane.getChildren().get(ViewIndexes.WITCH_VIEW.getValue());
        //Set coordinates
        witchView.setLayoutX(newCoordinates[0]);
        witchView.setLayoutY(newCoordinates[1]);
        //Initialize the image
        Image image = new Image(witch.getImagePath());
        //Update the image
        witchView.setImage(image);
    }
}
