package com.example.recipico.service;

import com.example.recipico.model.Category;
import com.example.recipico.model.RecipeCategory;
import com.example.recipico.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1L, RecipeCategory.MAIN_DISH));
        categoryList.add(new Category(2L, RecipeCategory.APPETIZER_AND_SNACK));

        when(categoryRepository.findAll()).thenReturn(categoryList);

        List<Category> result = categoryService.getAllCategory();

        assertEquals(2, result.size());
        assertEquals(RecipeCategory.MAIN_DISH, result.get(0).getCategoryName());
        assertEquals(RecipeCategory.APPETIZER_AND_SNACK, result.get(1).getCategoryName());

        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testGetCategoryById() {
        Category category = new Category(1L, RecipeCategory.MAIN_DISH);

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        Category result = categoryService.getCategoryById(1L);

        assertEquals(1L, result.getCategoryId());
        assertEquals(RecipeCategory.MAIN_DISH, result.getCategoryName());

        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    void testGetCategoryById_CategoryNotFound() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> categoryService.getCategoryById(1L));

        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    void testAddCategory() {
        Category category = new Category(1L, RecipeCategory.MAIN_DISH);

        when(categoryRepository.save(category)).thenReturn(category);

        categoryService.addCategory(category);

        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void testDeleteCategoryyId() {
        Category category = new Category(1L, RecipeCategory.MAIN_DISH);

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        categoryService.deleteCategoryyId(1L);

        verify(categoryRepository, times(1)).findById(1L);
        verify(categoryRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteCategoryyId_CategoryNotFound() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> categoryService.deleteCategoryyId(1L));

        verify(categoryRepository, times(1)).findById(1L);
        verify(categoryRepository, never()).deleteById(anyLong());
    }
}
