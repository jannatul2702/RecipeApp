package com.example.recipico.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifficultyTest {

    @Test
    void testGetLabel() {
        assertEquals("Easy", Difficulty.EASY.getLabel());
        assertEquals("Moderate", Difficulty.MODERATE.getLabel());
        assertEquals("Hard", Difficulty.HARD.getLabel());
    }
}
