package com.example.edashouse.model.utils;

import com.example.edashouse.model.constants.BasicCoordinates;

import java.util.Arrays;

public class GameLogicHandler {
    private BasicCoordinates[] forbiddenCoordinates;

    public GameLogicHandler() {
        setForbiddenCoordinates();
    }

    private void setForbiddenCoordinates() {
        forbiddenCoordinates = new BasicCoordinates[] {
                BasicCoordinates.BELLFLOWER,
                BasicCoordinates.BUGS,
                BasicCoordinates.HUMANS_GARBAGE,
                BasicCoordinates.KING,
                BasicCoordinates.MOUSES,
                BasicCoordinates.POT,
                BasicCoordinates.SNAKES,
                BasicCoordinates.SPIDERS,
                BasicCoordinates.WINDOWSILL,
        };
    }

    public boolean isValidMove(int[] newCoordinates) {
        boolean result = true;
        for (BasicCoordinates object: forbiddenCoordinates
             ) {
            if (Arrays.equals(object.getCoordinates(), newCoordinates)) {
                result = false;
            }
        }
        return result;
    }
}
