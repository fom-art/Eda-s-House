package view;

import model_view.Grid;

import java.util.HashMap;

public class Layout {
    HashMap<Integer, Object> objectHashMap = new HashMap<>();

    public void receiveCharacterChanges(Character character) {
        updateCharacterChanges();
    }

    public void setLayout(){
        setGrid();
        setObjects();
        linkObjectsAndGrid();
    }

    private void setGrid() {
        Grid grid = new Grid();
    }

    private void setObjects() {

    }

    private void linkObjectsAndGrid() {

    }

    private void updateCharacterChanges() {

    }
}
