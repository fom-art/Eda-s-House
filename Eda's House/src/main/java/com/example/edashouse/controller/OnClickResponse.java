package com.example.edashouse.controller;

import com.example.edashouse.view.Layout;


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
        Actions actions = new Actions(layout);

    }
//
//    private void changeCharacterInfo(Character character) {
//        layout.receiveCharacterChanges(character);
//    }
}
