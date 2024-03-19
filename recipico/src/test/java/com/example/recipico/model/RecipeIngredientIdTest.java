package com.example.recipico.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeIngredientIdTest {

    @Test
    void testEquals() {
        RecipeIngredientId id1 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id2 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id3 = new RecipeIngredientId(3L, 4L);

        assertEquals(id1, id2); // Same recipeId and ingredientId
        assertNotEquals(id1, id3); // Different recipeId and ingredientId
        assertNotEquals(id2, null); // Null comparison
        assertNotEquals(id1, new Object()); // Different class comparison
    }

    @Test
    void testHashCode() {
        RecipeIngredientId id1 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id2 = new RecipeIngredientId(1L, 2L);
        RecipeIngredientId id3 = new RecipeIngredientId(3L, 4L);

        assertEquals(id1.hashCode(), id2.hashCode()); // Same recipeId and ingredientId
        assertNotEquals(id1.hashCode(), id3.hashCode()); // Different recipeId and ingredientId
    }
}
