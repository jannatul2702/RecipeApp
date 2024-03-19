package com.example.recipico.service;

import com.example.recipico.model.Ingredient;
import com.example.recipico.repository.IngredientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class IngredientServiceImplTest {

    @Mock
    private IngredientRepository ingredientRepository;

    @InjectMocks
    private IngredientServiceImpl ingredientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllIngredients() {
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient(1L, "Salt"));
        ingredientList.add(new Ingredient(2L, "Pepper"));

        when(ingredientRepository.findAll()).thenReturn(ingredientList);

        List<Ingredient> result = ingredientService.getAllIngredients();

        assertEquals(2, result.size());
        assertEquals("Salt", result.get(0).getIngredientName());
        assertEquals("Pepper", result.get(1).getIngredientName());

        verify(ingredientRepository, times(1)).findAll();
    }

    @Test
    void testGetIngredientById() {
        Ingredient ingredient = new Ingredient(1L, "Salt");

        when(ingredientRepository.findById(1L)).thenReturn(Optional.of(ingredient));

        Ingredient result = ingredientService.getIngredientById(1L);

        assertEquals(1L, result.getIngredientId());
        assertEquals("Salt", result.getIngredientName());

        verify(ingredientRepository, times(1)).findById(1L);
    }

    @Test
    void testGetIngredientById_IngredientNotFound() {
        when(ingredientRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> ingredientService.getIngredientById(1L));

        verify(ingredientRepository, times(1)).findById(1L);
    }

    @Test
    void testAddIngredient() {
        Ingredient ingredient = new Ingredient(1L, "Salt");

        when(ingredientRepository.save(ingredient)).thenReturn(ingredient);

        ingredientService.addIngredient(ingredient);

        verify(ingredientRepository, times(1)).save(ingredient);
    }

    @Test
    void testDeleteIngredientyId() {
        Ingredient ingredient = new Ingredient(1L, "Salt");

        when(ingredientRepository.findById(1L)).thenReturn(Optional.of(ingredient));

        ingredientService.deleteIngredientyId(1L);

        verify(ingredientRepository, times(1)).findById(1L);
        verify(ingredientRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteIngredientyId_IngredientNotFound() {
        when(ingredientRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> ingredientService.deleteIngredientyId(1L));

        verify(ingredientRepository, times(1)).findById(1L);
        verify(ingredientRepository, never()).deleteById(anyLong());
    }
}
