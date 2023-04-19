package model_view;

import model.Actions;
import model.utils.Constants;
import view.Layout;

public class OnClickResponse {
    private Layout layout;
    public OnClickResponse(Layout layout) {
        this.layout = layout;
    }

    private void onButtonClicked(Integer buttonCode) {
        switch (buttonCode) {

        }
    }

    private void initiateAction() {
        Actions actions = new Actions();
        actions.receiveAction((new Constants()).actionOne);
    }

    private void changeCharacterInfo(Character character) {
        layout.receiveCharacterChanges(character);
    }
}
