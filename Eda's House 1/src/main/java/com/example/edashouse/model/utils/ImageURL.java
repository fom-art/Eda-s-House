package com.example.edashouse.model.utils;

import java.util.ResourceBundle;

public enum ImageURL {
    BACKGROUND("/owl_house_image.png");

    private String url;

    ImageURL(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
