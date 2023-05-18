package com.example.edashouse.model.constants;

public enum ImageURL {
    BACKGROUND("/owl_house_image.png"),
    WITCH_FRONT("/eda_forward.png"),
    WITCH_BACK("/eda_back.png"),
    WITCH_LEFT("/eda_left.png"),
    WITCH_RIGHT("/eda_right.png"),
    BUGS("/bugs.jpg"),
    BELLFLOWER("/bellflower.jpg"),
    ELIXIR("/elixir.jpg"),
    EXPLOSION_POTION("/explosion_potion.jpg"),
    FORESEEING_POTION("/foreseeing_potion.jpg"),
    HUMANS_GARBAGE("/human's_garbage.jpg"),
    MIST_POTION("/mist_potion.jpg"),
    MOUSE("/mouse.jpg"),
    SNAKES_OIL("/snake's_oil.jpg"),
    SNAKES_SKIN("/snake's_skin.jpg"),
    SPIDER("/spider.jpg");

    private String url;

    ImageURL(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
