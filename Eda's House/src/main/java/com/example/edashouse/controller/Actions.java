package com.example.edashouse.controller;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.Constants;
import com.example.edashouse.model.units.Witch;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.view.Layout;
import com.example.edashouse.view.NonPlayableCharactersActivator;

public class Actions {
    private Layout layout;
    private GameLogicHandler gameLogicHandler;
    private NonPlayableCharactersActivator npcView;

    public Actions(Layout layout, NonPlayableCharactersActivator npcView) {
        this.layout = layout;
        this.gameLogicHandler = new GameLogicHandler();
        this.npcView = npcView;
    }

    public void receiveAction(ActionsConstants action) {
        switch (action) {
            case LEFT_KEY_PRESSED, RIGHT_KEY_PRESSED,
                    UP_KEY_PRESSED, DOWN_KEY_PRESSED -> moveHero(action);
        }
    }

    private void moveHero(ActionsConstants action) {
        Witch witch = layout.getWitch();
        int[] witchCoordinates = witch.getCoordinates();
        witch.setLastAction(action);
        int[] directionSquare = getNextSquareFromDirection(action, witchCoordinates);
        if (gameLogicHandler.isValidMove(directionSquare)) {
            layout.updateWitchPosition(directionSquare);
        }
        layout.updateWitchImage(action);
        setNPCActivation(witch);
    }

    private void setNPCActivation(Witch witch) {
        unsetNPCActivation();
        setNearestNPCActive(witch);
    }

    private int[] getCoordinatesFromLeft(int[] oldCoordinates) {
        int[] newCoordinates = new int[]{oldCoordinates[0] - Constants.GRID_CELL_SIZE.getValue(), oldCoordinates[1]};
        //If the desired new point, is not a wall, or an object, it returns the
        //desired new coordinate, else, it returns the old coordinates, therefore
        //the character doesn't change its position
        if (
                oldCoordinates[0] != 0
        ) {
            LoggingHandler.logInfo("MOVED LEFT");
            return newCoordinates;
        } else {
            return oldCoordinates;
        }
    }

    private int[] getCoordinatesFromRight(int[] oldCoordinates) {
        int[] newCoordinates = new int[]{oldCoordinates[0] + Constants.GRID_CELL_SIZE.getValue(), oldCoordinates[1]};
        //If the desired new point, is not a wall, or an object, it returns the
        //desired new coordinate, else, it returns the old coordinates, therefore
        //the character doesn't change its position
        if (
                oldCoordinates[0] != Constants.GRID_CELL_SIZE.getValue() * (Constants.GRID_SIZE_IN_CELLS.getValue() - 1)
        ) {
            LoggingHandler.logInfo("MOVED RIGHT");
            return newCoordinates;
        } else {
            return oldCoordinates;
        }
    }

    private int[] getCoordinatesFromBelow(int[] oldCoordinates) {
        int[] newCoordinates = new int[]{oldCoordinates[0], oldCoordinates[1] + Constants.GRID_CELL_SIZE.getValue()};
        //If the desired new point, is not a wall, or an object, it returns the
        //desired new coordinate, else, it returns the old coordinates, therefore
        //the character doesn't change its position
        if (
                oldCoordinates[1] != Constants.GRID_CELL_SIZE.getValue() * (Constants.GRID_SIZE_IN_CELLS.getValue() - 1)
        ) {
            LoggingHandler.logInfo("MOVED DOWN");
            return newCoordinates;
        } else {
            return oldCoordinates;
        }
    }

    private int[] getCoordinatesFromAbove(int[] oldCoordinates) {
        int[] newCoordinates = new int[]{oldCoordinates[0], oldCoordinates[1] - Constants.GRID_CELL_SIZE.getValue()};
        //If the desired new point, is not a wall, or an object, it returns the
        //desired new coordinate, else, it returns the old coordinates, therefore
        //the character doesn't change its position
        if (
                oldCoordinates[1] != 0
        ) {
            LoggingHandler.logInfo("MOVED UP");
            return newCoordinates;
        } else {
            return oldCoordinates;
        }
    }

    private void setNearestNPCActive(Witch witch) {
        ActionsConstants lastAction = witch.getLastAction();
        int[] witchCoordinates = witch.getCoordinates();
        int[] nextSquareCoordinates = getNextSquareFromDirection(lastAction, witchCoordinates);

        Characters nearestNPC = gameLogicHandler.getObjectFromCoordinates(nextSquareCoordinates);
        if (nearestNPC != null) {
            npcView.setActive(nearestNPC);
        }
    }

    private void unsetNPCActivation() {
        npcView.unsetActivation();
    }

    private int[] getNextSquareFromDirection(ActionsConstants direction, int[] coordinates) {
        switch (direction) {
            case LEFT_KEY_PRESSED -> {
                return getCoordinatesFromLeft(coordinates);
            }
            case RIGHT_KEY_PRESSED -> {
                return getCoordinatesFromRight(coordinates);
            }
            case UP_KEY_PRESSED -> {
                return getCoordinatesFromAbove(coordinates);
            }
            case DOWN_KEY_PRESSED -> {
                return getCoordinatesFromBelow(coordinates);
            }
        }
        return null;
    }
}
