package com.example.edashouse.view;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.utils.Constants;
import com.example.edashouse.model.constants.utils.ImageURL;
import com.example.edashouse.model.units.NonPlayableCharacters;
import com.example.edashouse.model.units.Pot;
import com.example.edashouse.model.units.Windowsill;
import com.example.edashouse.model.units.npc.*;
import com.example.edashouse.model.utils.GameLogicHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NonPlayableCharactersActivator {
    private Layout layout;
    private Pot pot;

    public NonPlayableCharactersActivator(Layout layout) {
        this.layout = layout;
        setUpNPCharacters();
    }

    /**
     * Gets the pot character.
     *
     * @return the pot character
     */
    public Pot getPot() {
        return this.pot;
    }

    /**
     * Sets up the non-playable characters.
     */
    private void setUpNPCharacters() {
        setUpBellflower();
        setUpBugs();
        setUpHumansGarbage();
        setUpKing();
        setUpMouses();
        setUpPot();
        setUpSnakes();
        setUpSpiders();
        setUpWindowSill();
        setActiveIcon();
    }

    /**
     * Sets up the bellflower character.
     */
    private void setUpBellflower() {
        setUpNonPlayableCharacter(new BellFlower());
    }

    /**
     * Sets up the bugs character.
     */
    private void setUpBugs() {
        setUpNonPlayableCharacter(new Bugs());
    }

    /**
     * Sets up the humans' garbage character.
     */
    private void setUpHumansGarbage() {
        setUpNonPlayableCharacter(new HumansGarbage());
    }

    /**
     * Sets up the king character.
     */
    private void setUpKing() {
        setUpNonPlayableCharacter(new King());
    }

    /**
     * Sets up the mice characters.
     */
    private void setUpMouses() {
        setUpNonPlayableCharacter(new Mouses());
    }

    /**
     * Sets up the pot character.
     */
    private void setUpPot() {
        pot = new Pot();
        setUpNonPlayableCharacter(pot);
    }

    /**
     * Sets up the snake characters.
     */
    private void setUpSnakes() {
        setUpNonPlayableCharacter(new Snakes());
    }

    /**
     * Sets up the spider characters.
     */
    private void setUpSpiders() {
        setUpNonPlayableCharacter(new Spiders());
    }

    /**
     * Sets up the window sill character.
     */
    private void setUpWindowSill() {
        setUpNonPlayableCharacter(new Windowsill());
    }

    /**
     * Sets up the active icon.
     */
    private void setActiveIcon() {
        // Initialize the image
        Image image = new Image(ImageURL.F_KEY_ICON.getURL());
        ImageView activeIconView = new ImageView(image);
        // Set sizes
        activeIconView.setFitWidth(Constants.ACTIVE_ICON_SIZE.getValue());
        activeIconView.setFitHeight(Constants.ACTIVE_ICON_SIZE.getValue());
        // Set coordinates
        activeIconView.setLayoutX(Characters.ACTIVE_ICON.getCoordinates()[0]);
        activeIconView.setLayoutY(Characters.ACTIVE_ICON.getCoordinates()[1]);
        // Add to Pane
        layout.getPane().getChildren().add(Characters.ACTIVE_ICON.getIndex(), activeIconView);
    }

    /**
     * Sets up a non-playable character.
     *
     * @param npc the non-playable character
     */
    private void setUpNonPlayableCharacter(NonPlayableCharacters npc) {
        // Initialize the image
        Image image = new Image(npc.getImageURL());
        ImageView npcView = new ImageView(image);
        // Set sizes
        npcView.setFitWidth(Constants.GRID_CELL_SIZE.getValue());
        npcView.setFitHeight(Constants.GRID_CELL_SIZE.getValue());
        // Set coordinates
        npcView.setLayoutX(npc.getCharacter().getCoordinates()[0]);
        npcView.setLayoutY(npc.getCharacter().getCoordinates()[1]);
        // Add to Pane
        layout.getPane().getChildren().add(npc.getCharacterViewCode(), npcView);
    }

    /**
     * Sets the specified character as active and updates the active icon position.
     *
     * @param character the character to set as active
     */
    public void setActive(Characters character) {
        int[] characterCoordinates = character.getCoordinates().clone();
        // Get new position for active icon
        int[] newActiveIconPosition = GameLogicHandler.getPositionForActiveIcon(characterCoordinates);
        // Get active icon view from pane
        ImageView activeIconView = (ImageView) layout.getPane().getChildren().get(Characters.ACTIVE_ICON.getIndex());
        // Set coordinates
        activeIconView.setLayoutX(newActiveIconPosition[0]);
        activeIconView.setLayoutY(newActiveIconPosition[1]);
    }

    /**
     * Unsets the character activation and resets the active icon position.
     */
    public void unsetActivation() {
        // Get active icon view from pane
        ImageView activeIconView = (ImageView) layout.getPane().getChildren().get(Characters.ACTIVE_ICON.getIndex());
        // Set coordinates
        activeIconView.setLayoutX(Characters.ACTIVE_ICON.getCoordinates()[0]);
        activeIconView.setLayoutY(Characters.ACTIVE_ICON.getCoordinates()[1]);
    }
}
