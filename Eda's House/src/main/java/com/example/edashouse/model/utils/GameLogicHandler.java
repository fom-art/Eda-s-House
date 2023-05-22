package com.example.edashouse.model.utils;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.Constants;
import com.example.edashouse.model.units.NonPlayableCharacters;
import com.example.edashouse.model.units.npc.*;

import java.util.ArrayList;
import java.util.Arrays;

public class GameLogicHandler {
    private Characters[] objectsCoordinates;
    private ArrayList<NonPlayableCharacters> npcList;

    public GameLogicHandler() {
        setForbiddenCoordinates();
        setNPCList();
    }

    private void setForbiddenCoordinates() {
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

    public boolean isValidMove(int[] newCoordinates) {
        LoggingHandler.logInfo("New coord: " + newCoordinates[0] + " " + newCoordinates[1]);
        boolean result = true;
        for (Characters forbiddenCoordinates : objectsCoordinates
        ) {
            LoggingHandler.logInfo("Object coord: " + forbiddenCoordinates.getCoordinates()[0] + " " + forbiddenCoordinates.getCoordinates()[1]);
            LoggingHandler.logInfo("Object name: " + forbiddenCoordinates.name() + " " + Arrays.equals(forbiddenCoordinates.getCoordinates(), newCoordinates));
            if (Arrays.equals(forbiddenCoordinates.getCoordinates(), newCoordinates)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public Characters getObjectFromCoordinates(int[] coordinates) {
        Characters result = null;
        for (Characters object : objectsCoordinates
        ) {
            if (Arrays.equals(object.getCoordinates(), coordinates)) {
                result = object;
                break;
            }
        }
        return result;
    }

    public static int[] getPositionForActiveIcon(int[] coordinates) {
        int[] result = coordinates.clone();

        result[0] = result[0] + ((Constants.GRID_CELL_SIZE.getValue() -
                Constants.ACTIVE_ICON_SIZE.getValue()) / 2);
        result[1] = result[1] + Constants.GRID_CELL_SIZE.getValue() / 10;

        return result;
    }

    public void setNPCActive(Characters character) {
        NonPlayableCharacters npc = npcList.get(character.getIndex());
        npc.setIsToBeActivated(true);
    }

    public void unSetNPCActive() {
        for (NonPlayableCharacters npc: npcList
             ) {
            if (npc != null){
                npc.setIsToBeActivated(false);
            }
        }
    }
}
