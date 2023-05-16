package com.example.edashouse.controller;

import com.example.edashouse.model.utils.GameLogicHandler;
import com.example.edashouse.model.units.Witch;
import com.example.edashouse.model.constants.ActionsConstants;
import com.example.edashouse.model.constants.Constants;
import com.example.edashouse.view.Layout;

public class Actions {
    private GameLogicHandler gameLogicHandler = new GameLogicHandler();
    private Layout layout;

    public Actions(Layout layout) {
        this.layout = layout;
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
        if (oldCoordinates[0] != 0)
        {
            oldCoordinates[0] = oldCoordinates[0] - Constants.GRID_CELL_SIZE.getValue();
        }
        return oldCoordinates;
    }

    private int[] getCoordinatesToMoveRight(int[] oldCoordinates) {
        if (oldCoordinates[0] != Constants.GRID_CELL_SIZE.getValue() * (Constants.GRID_SIZE_IN_CELLS.getValue() - 1))
        {
            oldCoordinates[0] = oldCoordinates[0] + Constants.GRID_CELL_SIZE.getValue();
        }
        return oldCoordinates;
    }

    private int[] getCoordinatesToMoveDown(int[] oldCoordinates) {
        if (
                oldCoordinates[1] != Constants.GRID_CELL_SIZE.getValue() * (Constants.GRID_SIZE_IN_CELLS.getValue() - 1))
        {
            oldCoordinates[1] = oldCoordinates[1] + Constants.GRID_CELL_SIZE.getValue();
        }
        return oldCoordinates;
    }

    private int[] getCoordinatesToMoveUp(int[] oldCoordinates) {
        if (oldCoordinates[1] != 0)
        {
            oldCoordinates[1] = oldCoordinates[1] - Constants.GRID_CELL_SIZE.getValue();
        }
        return oldCoordinates;
    }

}
