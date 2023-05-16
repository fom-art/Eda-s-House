package com.example.edashouse.model.constants;

public enum ImageURL {
    BACKGROUND("/owl_house_image.png"),
    WITCH_FRONT("/eda.jpg"),
    WITCH_BACK("/eda.jpg"),
    WITCH_LEFT("/eda.jpg"),
    WITCH_RIGHT("/eda.jpg");

    private String url;

    ImageURL(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
