package com.example.edashouse.model.constants;

public enum ImageURL {
    BACKGROUND("/owl_house_image.png"),
    WITCH_FRONT("/eda_forward.png"),
    WITCH_BACK("/eda_back.png"),
    WITCH_LEFT("/eda_left.png"),
    WITCH_RIGHT("/eda_right.png"),
    BUGS("/bugs.png"),
    BELLFLOWER("/bellflower.png"),
    KING("/king.png"),
    POT("/pot.png"),
    WINDOWSILL("/windowsill.png"),
    ELIXIR("/elixir.png"),
    EXPLOSION_POTION("/explosion_potion.png"),
    FORESEEING_POTION("/foreseeing_potion.png"),
    HUMANS_GARBAGE("/human's_garbage.png"),
    MIST_POTION("/mist_potion.png"),
    MOUSE("/mouse.png"),
    SNAKES_OIL("/snake's_oil.png"),
    SNAKES_SKIN("/snake's_skin.png"),
    SPIDER("/spider.png"),
    F_KEY_ICON("/f_key_icon.png");

    private String url;

    ImageURL(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
