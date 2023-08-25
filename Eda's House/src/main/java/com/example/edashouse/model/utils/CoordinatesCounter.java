package com.example.edashouse.model.utils;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.characters_data.ActionsConstants;
import com.example.edashouse.model.constants.utils.Constants;

/**
 * Utility class for calculating coordinates and movements in the game.
 */
public class CoordinatesCounter {

    /**
     * Calculates the coordinates based on the given X and Y coordinates.
     *
     * @param coordinateX the X coordinate
     * @param coordinateY the Y coordinate
     * @return the calculated coordinates as an array [calculatedX, calculatedY]
     */
    public static int[] calculateCoordinates(int coordinateX, int coordinateY) {
        int calculatedX = (coordinateX - 1) * Constants.GRID_CELL_SIZE.getValue();
        int calculatedY = (coordinateY - 1) * Constants.GRID_CELL_SIZE.getValue();
        return new int[]{calculatedX, calculatedY};
    }

    /**
     * Calculates the coordinates based on the given coordinates array.
     *
     * @param coordinates the coordinates as an array [x, y]
     * @return the calculated coordinates as an array [calculatedX, calculatedY]
     */
    public static int[] calculateCoordinates(int[] coordinates) {
        int calculatedX = (coordinates[0] - 1) * Constants.GRID_CELL_SIZE.getValue();
        int calculatedY = (coordinates[1] - 1) * Constants.GRID_CELL_SIZE.getValue();
        return new int[]{calculatedX, calculatedY};
    }

    /**
     * Gets the next square coordinates based on the given direction and current coordinates.
     *
     * @param direction         the direction of movement
     * @param coordinates       the current coordinates
     * @param isForNPCActivation specifies if the movement is for NPC activation
     * @return the coordinates of the next square as an array [x, y]
     */
    public static int[] getNextSquareFromDirection(ActionsConstants direction, int[] coordinates, boolean isForNPCActivation) {
        GameLogicHandler gameLogicHandler = new GameLogicHandler();
        switch (direction) {
            case LEFT_KEY_PRESSED:
                return getCoordinatesFromLeft(coordinates, gameLogicHandler, isForNPCActivation);
            case RIGHT_KEY_PRESSED:
                return getCoordinatesFromRight(coordinates, gameLogicHandler, isForNPCActivation);
            case UP_KEY_PRESSED:
                return getCoordinatesFromAbove(coordinates, gameLogicHandler, isForNPCActivation);
            case DOWN_KEY_PRESSED:
                return getCoordinatesFromBelow(coordinates, gameLogicHandler, isForNPCActivation);
        }
        return null;
    }

    /**
     * Calculates the coordinates when moving left from the current coordinates.
     * If the desired new point is not a wall or an object, it returns the new coordinates.
     * Otherwise, it returns the old coordinates.
     *
     * @param oldCoordinates       the current coordinates
     * @param gameLogicHandler     the game logic handler
     * @param isForNPCActivation   specifies if the movement is for NPC activation
     * @return the new coordinates if the move is valid, otherwise the old coordinates
     */
    private static int[] getCoordinatesFromLeft(int[] oldCoordinates, GameLogicHandler gameLogicHandler, boolean isForNPCActivation) {
        int[] newCoordinates = new int[]{oldCoordinates[0] - Constants.GRID_CELL_SIZE.getValue(), oldCoordinates[1]};
        if (oldCoordinates[0] != 0) {
            if (gameLogicHandler.isObjectAtCoordinates(newCoordinates) || isForNPCActivation) {
                LoggingHandler.logInfo("MOVED LEFT");
                return newCoordinates;
            }
        }
        return oldCoordinates;
    }

    /**
     * Calculates the coordinates when moving right from the current coordinates.
     * If the desired new point is not a wall or an object, it returns the new coordinates.
     * Otherwise, it returns the old coordinates.
     *
     * @param oldCoordinates       the current coordinates
     * @param gameLogicHandler     the game logic handler
     * @param isForNPCActivation   specifies if the movement is for NPC activation
     * @return the new coordinates if the move is valid, otherwise the old coordinates
     */
    private static int[] getCoordinatesFromRight(int[] oldCoordinates, GameLogicHandler gameLogicHandler, boolean isForNPCActivation) {
        int[] newCoordinates = new int[]{oldCoordinates[0] + Constants.GRID_CELL_SIZE.getValue(), oldCoordinates[1]};
        if (oldCoordinates[0] != Constants.GRID_CELL_SIZE.getValue() * (Constants.GRID_SIZE_IN_CELLS.getValue() - 1)) {
            if (gameLogicHandler.isObjectAtCoordinates(newCoordinates) || isForNPCActivation) {
                LoggingHandler.logInfo("MOVED RIGHT");
                return newCoordinates;
            }
        }
        return oldCoordinates;
    }

    /**
     * Calculates the coordinates when moving down from the current coordinates.
     * If the desired new point is not a wall or an object, it returns the new coordinates.
     * Otherwise, it returns the old coordinates.
     *
     * @param oldCoordinates       the current coordinates
     * @param gameLogicHandler     the game logic handler
     * @param isForNPCActivation   specifies if the movement is for NPC activation
     * @return the new coordinates if the move is valid, otherwise the old coordinates
     */
    private static int[] getCoordinatesFromBelow(int[] oldCoordinates, GameLogicHandler gameLogicHandler, boolean isForNPCActivation) {
        int[] newCoordinates = new int[]{oldCoordinates[0], oldCoordinates[1] + Constants.GRID_CELL_SIZE.getValue()};
        if (oldCoordinates[1] != Constants.GRID_CELL_SIZE.getValue() * (Constants.GRID_SIZE_IN_CELLS.getValue() - 1)) {
            if (gameLogicHandler.isObjectAtCoordinates(newCoordinates) || isForNPCActivation) {
                LoggingHandler.logInfo("MOVED DOWN");
                return newCoordinates;
            }
        }
        return oldCoordinates;
    }

    /**
     * Calculates the coordinates when moving up from the current coordinates.
     * If the desired new point is not a wall or an object, it returns the new coordinates.
     * Otherwise, it returns the old coordinates.
     *
     * @param oldCoordinates       the current coordinates
     * @param gameLogicHandler     the game logic handler
     * @param isForNPCActivation   specifies if the movement is for NPC activation
     * @return the new coordinates if the move is valid, otherwise the old coordinates
     */
    private static int[] getCoordinatesFromAbove(int[] oldCoordinates, GameLogicHandler gameLogicHandler, boolean isForNPCActivation) {
        int[] newCoordinates = new int[]{oldCoordinates[0], oldCoordinates[1] - Constants.GRID_CELL_SIZE.getValue()};
        if (oldCoordinates[1] != 0) {
            if (gameLogicHandler.isObjectAtCoordinates(newCoordinates) || isForNPCActivation) {
                LoggingHandler.logInfo("MOVED UP");
                return newCoordinates;
            }
        }
        return oldCoordinates;
    }
}
