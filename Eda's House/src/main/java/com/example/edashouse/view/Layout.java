package com.example.edashouse.view;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.characters.PlayableCharacter;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.constants.utils.Constants;
import com.example.edashouse.model.constants.utils.ImageURL;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Represents the layout of the game, including the pane, scene, and stage.
 */
public class Layout {
    private PlayableCharacter witch;
    private Pane pane;
    private Scene scene;
    private final Stage stage;

    /**
     * Constructs a Layout object for the game.
     *
     * @param stage  the main stage for the game
     * @param isTest indicates whether the layout is for testing purposes
     */
    public Layout(Stage stage, boolean isTest) {
        this.stage = stage;
        setGameLayout(isTest);
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
    public PlayableCharacter getWitch() {
        return this.witch;
    }

    /**
     * Sets up the game layout, including the pane, scene, and stage.
     *
     * @param isTest indicates whether the layout is for testing purposes
     */
    public void setGameLayout(boolean isTest) {
        setPane(isTest);
        if (!isTest) {
            setScene();
            setStage();
        }
    }

    /**
     * Sets up the pane for the game layout.
     *
     * @param isTest indicates whether the layout is for testing purposes
     */
    private void setPane(boolean isTest) {
        pane = new Pane();
        pane.setPrefSize(Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(),
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue());
        if (!isTest) {
            setPaneBackground();
        }
    }

    /**
     * Sets up the scene for the game layout.
     */
    private void setScene() {
        scene = new Scene(pane,
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(),
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue());
    }

    /**
     * Sets up the stage for the game layout.
     */
    private void setStage() {
        stage.setTitle("Eda's House");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    /**
     * Sets up the background image for the pane.
     *
     * @throws RuntimeException if there is an issue setting up the background
     */
    public void setPaneBackground() throws RuntimeException {
        Image backgroundImage = new Image(ImageURL.BACKGROUND.getURL(),
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(),
                Constants.GRID_CELL_SIZE.getValue() * Constants.GRID_SIZE_IN_CELLS.getValue(), false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        pane.setBackground(new Background(background));
    }

    /**
     * Adds the witch character to the layout.
     *
     * @param isTest indicates whether the layout is for testing purposes
     */
    public void addWitch(boolean isTest) {
        witch = PlayableCharacter.WITCH;
        // Initialize the image
        ImageView witchView;
        if (!isTest) {
            Image image = new Image(getWitch().getCurrentImageURL());
            witchView = new ImageView(image);
        } else {
            witchView = new ImageView();
        }
        // Set sizes
        witchView.setFitWidth(Constants.GRID_CELL_SIZE.getValue());
        witchView.setFitHeight(Constants.GRID_CELL_SIZE.getValue());
        // Set coordinates
        witchView.setLayoutX(getWitch().getCoordinates()[0]);
        witchView.setLayoutY(getWitch().getCoordinates()[1]);
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
        getWitch().setCoordinates(newCoordinates);
        getWitch().setCurrentImageURL("Hueta");
        // Get witch view from pane
        ImageView witchView = (ImageView) getPane().getChildren().get(Characters.WITCH.getIndex());
        // Set coordinates
        LoggingHandler.logInfo(Arrays.toString(newCoordinates));
        witchView.setLayoutX(newCoordinates[0]);
        witchView.setLayoutY(newCoordinates[1]);
    }

    /**
     * Updates the image of the witch character based on the specified direction.
     *
     * @param direction the direction of the witch character
     * @param isTest    indicates whether the layout is for testing purposes
     */
    public void updateWitchImage(ActionsConstants direction, boolean isTest) {
        // Update the witch data
        getWitch().setImageURLFromAction(direction);
        // Get witch view from pane
        ImageView witchView = (ImageView) getPane().getChildren().get(Characters.WITCH.getIndex());
        if (!isTest) {
            // Initialize the image
            Image image = new Image(getWitch().getCurrentImageURL());
            // Update the image
            witchView.setImage(image);
        }
    }
}
