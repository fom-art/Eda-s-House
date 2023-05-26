package com.example.edashouse.view;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.units.NonPlayableCharacters;
import com.example.edashouse.model.units.Witch;
import com.example.edashouse.model.constants.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;
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

    /**
     * Gets the pane of the layout.
     *
     * @return the pane
     */
    public Pane getPane() {
        return this.pane;
    }

    /**
     * Gets the scene of the layout.
     *
     * @return the scene
     */
    public Scene getScene() {
        return this.scene;
    }

    /**
     * Gets the stage of the layout.
     *
     * @return the stage
     */
    public Stage getStage() {
        return this.stage;
    }

    /**
     * Gets the witch character of the layout.
     *
     * @return the witch character
     */
    public Witch getWitch() {
        return this.witch;
    }

    /**
     * Sets up the game layout.
     */
    public void setGameLayout() {
        setPane();
        setScene();
        setStage();
        test();
    }

    /**
     * Sets up the pane.
     */
    private void setPane() {
        pane = new Pane();
        pane.setPrefSize(Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(),
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue());
        setPaneBackground();
    }

    /**
     * Sets up the scene.
     */
    private void setScene() {
        scene = new Scene(pane,
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(),
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue());
    }

    /**
     * Sets up the stage.
     */
    private void setStage() {
        stage.setTitle("Eda's House");
        stage.setScene(scene);
        // I am not sure if I am going to use the full screen
        // stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    /**
     * Sets up the background for the pane.
     */
    private void setPaneBackground() {
        Image backgroundImage = new Image(ImageURL.BACKGROUND.getURL(), Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(), Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(), false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        pane.setBackground(new Background(background));
    }

    /**
     * A placeholder method for testing.
     */
    private void test() {
        // TODO: Implement the test logic
    }

    /**
     * Adds the witch character to the layout.
     */
    public void addWitch() {
        witch = new Witch(Characters.WITCH.getCoordinates());
        // Initialize the image
        Image image = new Image(witch.getImagePath());
        ImageView witchView = new ImageView(image);
        // Set sizes
        witchView.setFitWidth(Constants.GRID_CELL_SIZE.getValue());
        witchView.setFitHeight(Constants.GRID_CELL_SIZE.getValue());
        // Set coordinates
        witchView.setLayoutX(witch.getCoordinates()[0]);
        witchView.setLayoutY(witch.getCoordinates()[1]);
        // Add to Pane
        pane.getChildren().add(Characters.WITCH.getIndex(), witchView);
    }

    /**
     * Updates the position of the witch character.
     *
     * @param newCoordinates the new coordinates of the witch character
     */
    public void updateWitchPosition(int[] newCoordinates) {
        // Update the witch data
        witch.setCoordinates(newCoordinates);
        // Get witch view from pane
        ImageView witchView = (ImageView) pane.getChildren().get(Characters.WITCH.getIndex());
        // Set coordinates
        LoggingHandler.logInfo(Arrays.toString(newCoordinates));
        witchView.setLayoutX(newCoordinates[0]);
        witchView.setLayoutY(newCoordinates[1]);
    }

    /**
     * Updates the image of the witch character based on the specified direction.
     *
     * @param direction the direction of the witch character
     */
    public void updateWitchImage(ActionsConstants direction) {
        // Update the witch data
        witch.setImage(direction);
        // Get witch view from pane
        ImageView witchView = (ImageView) pane.getChildren().get(Characters.WITCH.getIndex());
        // Initialize the image
        Image image = new Image(witch.getImagePath());
        // Update the image
        witchView.setImage(image);
    }
}
