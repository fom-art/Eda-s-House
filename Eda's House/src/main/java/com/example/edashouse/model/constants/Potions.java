package com.example.edashouse.model.constants;

public enum Potions {
    ELIXIR(new Items[]{Items.MOUSES, Items.SNAKES_OIL, Items.HUMANS_GARBAGE}),
    EXPLOSION_POTION(new Items[]{Items.BUGS, Items.KING, Items.SPIDERS}),
    FORESEEING_POTION(new Items[]{Items.SPIDERS, Items.SNAKES_OIL, Items.HUMANS_GARBAGE}),
    MIST_POTION(new Items[]{Items.BUGS, Items.KING, Items.SPIDERS}),
    SUSPICIOUS_POTION(new Items[]{});

    private final Items[] recipe;

    Potions(Items[] recipe) {
        this.recipe = recipe;
    }

    public Items[] getRecipe() {
        return recipe;
    }
}
