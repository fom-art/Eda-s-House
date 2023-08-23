package com.example.edashouse.model.constants;

/**
 * Enum representing different types of potions in the game.
 */
public enum Potions {
    ELIXIR(new Items[]{Items.MOUSES, Items.SNAKES, Items.HUMANS_GARBAGE}),
    EXPLOSION_POTION(new Items[]{Items.BUGS, Items.KING, Items.SPIDERS}),
    FORESEEING_POTION(new Items[]{Items.SPIDERS, Items.SNAKES, Items.HUMANS_GARBAGE}),
    MIST_POTION(new Items[]{Items.BELLFLOWER, Items.KING, Items.SPIDERS}),
    SUSPICIOUS_POTION(new Items[]{});

    private final Items[] recipe;

    /**
     * Constructs a Potion enum with the specified recipe.
     *
     * @param recipe the recipe for the potion
     */
    Potions(Items[] recipe) {
        this.recipe = recipe;
    }

    /**
     * Gets the recipe for the potion.
     *
     * @return the recipe as an array of items
     */
    public Items[] getRecipe() {
        return recipe;
    }
}
