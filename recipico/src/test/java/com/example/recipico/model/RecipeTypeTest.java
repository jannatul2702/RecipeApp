package com.example.recipico.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeTypeTest {

    @Test
    void testGetType() {
        assertEquals("Default", RecipeType.DEFAULT.getType());
        assertEquals("Egg-free", RecipeType.EGG_FREE.getType());
        assertEquals("Gluten-free", RecipeType.GLUTEN_FREE.getType());
        assertEquals("Diabetic", RecipeType.DIABETIC.getType());
        assertEquals("No-sugar", RecipeType.NO_SUGAR.getType());
        assertEquals("Red-meat-free", RecipeType.RED_MEAT_FREE.getType());
        assertEquals("Vegetarian", RecipeType.VEGETARIAN.getType());
        assertEquals("Wheat-free", RecipeType.WHEAT_FREE.getType());
    }
}
