package com.example.recipico.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCategoryTest {

    @Test
    void testGetCategoryName() {
        assertEquals("Appetizer and Snack", RecipeCategory.APPETIZER_AND_SNACK.getCategoryName());
        assertEquals("Main Dish", RecipeCategory.MAIN_DISH.getCategoryName());
        assertEquals("Side Dish", RecipeCategory.SIDE_DISH.getCategoryName());
        assertEquals("Everyday Cooking", RecipeCategory.EVERYDAY_COOKING.getCategoryName());
        assertEquals("Fruits and Vegetables", RecipeCategory.FRUITS_AND_VEGETABLES.getCategoryName());
        assertEquals("Seafood", RecipeCategory.SEAFOOD.getCategoryName());
        assertEquals("Meat and Poultry", RecipeCategory.MEAT_AND_POULTRY.getCategoryName());
        assertEquals("World Cuisine", RecipeCategory.WORLD_CUISINE.getCategoryName());
        assertEquals("Pasta and Noodles", RecipeCategory.PASTA_AND_NOODLES.getCategoryName());
        assertEquals("Dessert", RecipeCategory.DESSERT.getCategoryName());
        assertEquals("Drinks", RecipeCategory.DRINKS.getCategoryName());
        assertEquals("Breakfast and Brunch", RecipeCategory.BREAKFAST_AND_BRUNCH.getCategoryName());
        assertEquals("Salad", RecipeCategory.SALAD.getCategoryName());
        assertEquals("Soup Stews and Chili", RecipeCategory.SOUP.getCategoryName());
        assertEquals("Bread", RecipeCategory.BREAD.getCategoryName());
    }
}
