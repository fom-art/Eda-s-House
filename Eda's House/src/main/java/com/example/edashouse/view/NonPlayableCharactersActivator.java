package com.example.edashouse.view;

import com.example.edashouse.model.constants.Constants;
import com.example.edashouse.model.units.NonPlayableCharacters;
import com.example.edashouse.model.units.npc.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NonPlayableCharactersActivator {
    private Layout layout;

    public NonPlayableCharactersActivator(Layout layout) {
        this.layout = layout;
        setUpNPCharacters();
    }

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
    }

    private void setUpBellflower() {
        setUpNonPlayableCharacter(new BellFlower());
    }

    private void setUpBugs() {
        setUpNonPlayableCharacter(new Bugs());
    }

    private void setUpHumansGarbage() {
        setUpNonPlayableCharacter(new HumansGarbage());
    }

    private void setUpKing() {
        setUpNonPlayableCharacter(new King());
    }

    private void setUpMouses() {
        setUpNonPlayableCharacter(new Mouses());
    }

    private void setUpPot() {
        setUpNonPlayableCharacter(new Pot());
    }

    private void setUpSnakes() {
        setUpNonPlayableCharacter(new Snakes());
    }

    private void setUpSpiders() {
        setUpNonPlayableCharacter(new Spiders());
    }

    private void setUpWindowSill() {
        setUpNonPlayableCharacter(new Windowsill());
    }

    private void setUpNonPlayableCharacter(NonPlayableCharacters npc) {
        //Initialize the image
        Image image = new Image(npc.getImageURL());
        ImageView npcView = new ImageView(image);
        //Set sizes
        npcView.setFitWidth(Constants.GRID_CELL_SIZE.getValue());
        npcView.setFitHeight(Constants.GRID_CELL_SIZE.getValue());
        //Set coordinates
        npcView.setLayoutX(npc.getCoordinates()[0]);
        npcView.setLayoutY(npc.getCoordinates()[1]);
        //Add to Pane
        layout.getPane().getChildren().add(npc.getCharacterViewCode(), npcView);
    }
}
