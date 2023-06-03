package com.example.edashouse.model.utils;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.utils.Constants;
import com.example.edashouse.model.units.NonPlayableCharacters;
import com.example.edashouse.model.units.Pot;
import com.example.edashouse.model.units.Windowsill;
import com.example.edashouse.model.units.npc.*;

import java.util.ArrayList;
import java.util.Arrays;

public class GameLogicHandler {
    private Characters[] objectsCoordinates;
    private ArrayList<NonPlayableCharacters> npcList;

    /**
     * Constructs a GameLogicHandler object and initializes the forbidden coordinates and NPC list.
     */
    public GameLogicHandler() {
        setForbiddenCoordinates();
        setNPCList();
    }

    private void setForbiddenCoordinates() {
        // Set the forbidden coordinates for objects in the game
        objectsCoordinates = new Characters[]{
                Characters.BELLFLOWER,
                Characters.BUGS,
                Characters.HUMANS_GARBAGE,
                Characters.KING,
                Characters.MOUSES,
                Characters.POT,
                Characters.SNAKES,
                Characters.SPIDERS,
                Characters.WINDOWSILL,
        };
    }

    private void setNPCList() {
        // Initialize the NPC list with corresponding NPCs for each character
        npcList = new ArrayList<>();
        npcList.add(0, null);
        npcList.add(Characters.BELLFLOWER.getIndex(), new BellFlower());
        npcList.add(Characters.BUGS.getIndex(), new Bugs());
        npcList.add(Characters.HUMANS_GARBAGE.getIndex(), new HumansGarbage());
        npcList.add(Characters.KING.getIndex(), new King());
        npcList.add(Characters.MOUSES.getIndex(), new Mouses());
        npcList.add(Characters.POT.getIndex(), new Pot());
        npcList.add(Characters.SNAKES.getIndex(), new Snakes());
        npcList.add(Characters.SPIDERS.getIndex(), new Spiders());
        npcList.add(Characters.WINDOWSILL.getIndex(), new Windowsill());
    }

    /**
     * Checks if the new coordinates are a valid move.
     *
     * @param newCoordinates the new coordinates to check
     * @return true if the move is valid, false otherwise
     */
    public boolean isValidMove(int[] newCoordinates) {
        LoggingHandler.logInfo("New coord: " + newCoordinates[0] + " " + newCoordinates[1]);
        boolean result = true;
        for (Characters forbiddenCoordinates : objectsCoordinates) {
            LoggingHandler.logInfo("Object coord: " + forbiddenCoordinates.getCoordinates()[0] + " " + forbiddenCoordinates.getCoordinates()[1]);
            LoggingHandler.logInfo("Object name: " + forbiddenCoordinates.name() + " " + Arrays.equals(forbiddenCoordinates.getCoordinates(), newCoordinates));
            if (Arrays.equals(forbiddenCoordinates.getCoordinates(), newCoordinates)) {
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
    public Characters getObjectFromCoordinates(int[] coordinates) {
        Characters result = null;
        for (Characters object : objectsCoordinates) {
            if (Arrays.equals(object.getCoordinates(), coordinates)) {
                result = object;
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
    public void setNPCActive(Characters character) {
        NonPlayableCharacters npc = npcList.get(character.getIndex());
        npc.setIsToBeActivated(true);
    }

    /**
     * Unsets the active state for all NPC characters.
     */
    public void unSetNPCActive() {
        for (NonPlayableCharacters npc : npcList) {
            if (npc != null) {
                npc.setIsToBeActivated(false);
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
        for (NonPlayableCharacters npc : npcList) {
            if (npc != null && npc.getIsToBeActivated()) {
                result = npc;
            }
        }
        return result;
    }
}
