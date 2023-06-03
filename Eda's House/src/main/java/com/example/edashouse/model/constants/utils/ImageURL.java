package com.example.edashouse.model.constants.utils;

/**
 * URLs of images used in the game.
 */
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

    /**
     * Constructs an image URL with the specified URL string.
     *
     * @param url the URL of the image
     */
    ImageURL(String url) {
        this.url = url;
    }

    /**
     * Returns the URL of the image.
     *
     * @return the URL of the image
     */
    public String getURL() {
        return url;
    }

}
