package com.example.edashouse.view;

import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.Constants;
import com.example.edashouse.model.constants.ImageURL;
import com.example.edashouse.model.units.NonPlayableCharacters;
import com.example.edashouse.model.units.npc.*;
import com.example.edashouse.model.utils.GameLogicHandler;
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
        setActiveIcon();
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

    private void setActiveIcon() {
        //Initialize the image
        Image image = new Image(ImageURL.F_KEY_ICON.getURL());
        ImageView activeIconView = new ImageView(image);
        //Set sizes
        activeIconView.setFitWidth(Constants.ACTIVE_ICON_SIZE.getValue());
        activeIconView.setFitHeight(Constants.ACTIVE_ICON_SIZE.getValue());
        //Set coordinates
        activeIconView.setLayoutX(Characters.ACTIVE_ICON.getCoordinates()[0]);
        activeIconView.setLayoutY(Characters.ACTIVE_ICON.getCoordinates()[1]);
        //Add to Pane
        layout.getPane().getChildren().add(Characters.ACTIVE_ICON.getIndex(), activeIconView);
    }

    private void setUpNonPlayableCharacter(NonPlayableCharacters npc) {
        //Initialize the image
        Image image = new Image(npc.getImageURL());
        ImageView npcView = new ImageView(image);
        //Set sizes
        npcView.setFitWidth(Constants.GRID_CELL_SIZE.getValue());
        npcView.setFitHeight(Constants.GRID_CELL_SIZE.getValue());
        //Set coordinates
        npcView.setLayoutX(npc.getCharacter().getCoordinates()[0]);
        npcView.setLayoutY(npc.getCharacter().getCoordinates()[1]);
        //Add to Pane
        layout.getPane().getChildren().add(npc.getCharacterViewCode(), npcView);
    }

    public void setActive(Characters character) {
        int[] characterCoordinates = character.getCoordinates().clone();
        //Get new position for active icon
        int[] newActiveIconPosition = GameLogicHandler.getPositionForActiveIcon(characterCoordinates);
        //Get active icon view from pane
        ImageView activeIconView = (ImageView) layout.getPane().getChildren().get(Characters.ACTIVE_ICON.getIndex());
        //Set coordinates
        activeIconView.setLayoutX(newActiveIconPosition[0]);
        activeIconView.setLayoutY(newActiveIconPosition[1]);
    }
}
