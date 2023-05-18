package com.example.edashouse.controller;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.model.units.Witch;
import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.model.constants.Constants;
import com.example.edashouse.view.Layout;

public class Actions {
    private Layout layout;
    private GameLogicHandler gameLogicHandler;

    public Actions(Layout layout) {
        this.layout = layout;
        this.gameLogicHandler = new GameLogicHandler();
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
        switch (action) {
            case LEFT_KEY_PRESSED -> layout.updateWitch(getCoordinatesToMoveLeft(witchCoordinates), action);
            case RIGHT_KEY_PRESSED -> layout.updateWitch(getCoordinatesToMoveRight(witchCoordinates), action);
            case UP_KEY_PRESSED -> layout.updateWitch(getCoordinatesToMoveUp(witchCoordinates), action);
            case DOWN_KEY_PRESSED -> layout.updateWitch(getCoordinatesToMoveDown(witchCoordinates), action);
        }
    }

    private int[] getCoordinatesToMoveLeft(int[] oldCoordinates) {
        int[] newCoordinates = new int[] {oldCoordinates[0] - Constants.GRID_CELL_SIZE.getValue(), oldCoordinates[1]};
        //If the desired new point, is not a wall, or an object, it returns the
        //desired new coordinate, else, it returns the old coordinates, therefore
        //the character doesn't change its position
        if (
                oldCoordinates[0] != 0
                        && gameLogicHandler.isValidMove(newCoordinates)
        ) {
            LoggingHandler.logInfo("MOVED LEFT");
            return newCoordinates;
        } else {
            return oldCoordinates;
        }
    }

    private int[] getCoordinatesToMoveRight(int[] oldCoordinates) {
        int[] newCoordinates = new int[] {oldCoordinates[0] + Constants.GRID_CELL_SIZE.getValue(), oldCoordinates[1]};
        //If the desired new point, is not a wall, or an object, it returns the
        //desired new coordinate, else, it returns the old coordinates, therefore
        //the character doesn't change its position
        if (
                oldCoordinates[0] != Constants.GRID_CELL_SIZE.getValue() * (Constants.GRID_SIZE_IN_CELLS.getValue() - 1)
                && gameLogicHandler.isValidMove(newCoordinates)
        ) {
            LoggingHandler.logInfo("MOVED RIGHT");
            return newCoordinates;
        } else {
            return oldCoordinates;
        }
    }

    private int[] getCoordinatesToMoveDown(int[] oldCoordinates) {
        int[] newCoordinates = new int[] {oldCoordinates[0], oldCoordinates[1] + Constants.GRID_CELL_SIZE.getValue()};
        //If the desired new point, is not a wall, or an object, it returns the
        //desired new coordinate, else, it returns the old coordinates, therefore
        //the character doesn't change its position
        if (
                oldCoordinates[1] != Constants.GRID_CELL_SIZE.getValue() * (Constants.GRID_SIZE_IN_CELLS.getValue() - 1)
                        && gameLogicHandler.isValidMove(newCoordinates)
        ) {
            LoggingHandler.logInfo("MOVED DOWN");
            return newCoordinates;
        } else {
            return oldCoordinates;
        }
    }

    private int[] getCoordinatesToMoveUp(int[] oldCoordinates) {
        int[] newCoordinates = new int[] {oldCoordinates[0], oldCoordinates[1] - Constants.GRID_CELL_SIZE.getValue()};
        //If the desired new point, is not a wall, or an object, it returns the
        //desired new coordinate, else, it returns the old coordinates, therefore
        //the character doesn't change its position
        if (
                oldCoordinates[1] != 0
                        && gameLogicHandler.isValidMove(newCoordinates)
        ) {
            LoggingHandler.logInfo("MOVED UP");
            return newCoordinates;
        } else {
            return oldCoordinates;
        }
    }
}
