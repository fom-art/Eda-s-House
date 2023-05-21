package com.example.edashouse.model.utils;

import com.example.edashouse.LoggingHandler;
import com.example.edashouse.model.constants.Characters;
import com.example.edashouse.model.constants.Constants;

import java.util.Arrays;

public class GameLogicHandler {
    private Characters[] objectsCoordinates;

    public GameLogicHandler() {
        setForbiddenCoordinates();
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
        int[] result = coordinates;

        result[0] = result[0] + ((Constants.GRID_CELL_SIZE.getValue() -
                Constants.ACTIVE_ICON_SIZE.getValue()) / 2);
        result[1] = result[1] + Constants.GRID_CELL_SIZE.getValue() / 10;

        return result;
    }
}
