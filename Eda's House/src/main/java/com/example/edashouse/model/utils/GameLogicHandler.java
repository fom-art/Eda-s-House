package com.example.edashouse.model.utils;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.characters.NonPlayableCharacters;
import com.example.edashouse.model.constants.utils.Constants;

import java.util.Arrays;

/**
 * Utility class for handling game logic related to character interactions and positions.
 */
public class GameLogicHandler {

    /**
     * Checks if there is an object at the specified coordinates.
     *
     * @param newCoordinates the new coordinates to check
     * @return true if an object exists at the coordinates, false otherwise
     */
    public boolean isObjectAtCoordinates(int[] newCoordinates) {
        LoggingHandler.logInfo("New coord: " + newCoordinates[0] + " " + newCoordinates[1]);
        boolean result = true;
        for (NonPlayableCharacters npc : NonPlayableCharacters.values()) {
            LoggingHandler.logInfo("Object coord: " + npc.getCoordinates()[0] + " " + npc.getCoordinates()[1]);
            LoggingHandler.logInfo("Object name: " + npc.name() + " " + Arrays.equals(npc.getCoordinates(), newCoordinates));
            if (Arrays.equals(npc.getCoordinates(), newCoordinates)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Retrieves the object at the given coordinates.
     *
     * @param coordinates the coordinates to check
     * @return the object at the coordinates, or null if no object exists
     */
    public NonPlayableCharacters getObjectFromCoordinates(int[] coordinates) {
        NonPlayableCharacters result = null;
        for (NonPlayableCharacters npc : NonPlayableCharacters.values()) {
            if (Arrays.equals(npc.getCoordinates(), coordinates)) {
                result = npc;
                break;
            }
        }
        return result;
    }

    /**
     * Calculates the position for the active icon based on the given coordinates.
     *
     * @param coordinates the coordinates to calculate the position for
     * @return the position for the active icon as an array [x, y]
     */
    public static int[] getPositionForActiveIcon(int[] coordinates) {
        int[] result = coordinates.clone();

        result[0] = result[0] + ((Constants.GRID_CELL_SIZE.getValue() -
                Constants.ACTIVE_ICON_SIZE.getValue()) / 2);
        result[1] = result[1] + Constants.GRID_CELL_SIZE.getValue() / 10;

        return result;
    }

    /**
     * Sets the specified NPC character as active for activation.
     *
     * @param character the NPC character to set as active
     */
    public void setNPCActive(NonPlayableCharacters character) {
        character.setToBeActivated(true);
    }

    /**
     * Unsets the active state for all NPC characters.
     */
    public void unSetNPCActive() {
        for (NonPlayableCharacters npc : NonPlayableCharacters.values()) {
            if (npc != null) {
                npc.setToBeActivated(false);
            }
        }
    }

    /**
     * Retrieves the NPC character that is marked for activation.
     *
     * @return the NPC character to be activated, or null if no character is marked for activation
     */
    public NonPlayableCharacters getNPCToBeActivated() {
        NonPlayableCharacters result = null;
        for (NonPlayableCharacters npc : NonPlayableCharacters.values()) {
            if (npc != null && npc.isToBeActivated()) {
                result = npc;
            }
        }
        return result;
    }
}
