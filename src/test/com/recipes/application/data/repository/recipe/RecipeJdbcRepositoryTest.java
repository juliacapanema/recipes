package com.recipes.application.data.repository.recipe;

import com.recipes.application.data.model.Recipe.Recipe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeJdbcRepositoryTest {

    private RecipeJdbcRepository repository;

    @BeforeEach
    void setUpRepository() {
        repository = new RecipeJdbcRepository();
    }

    @Test
    void shouldReturnRecipeWhenExists() throws SQLException {
        // Arrange
        Recipe recipe = new Recipe(
                "Receita Teste",
                "description",
                "ingrediente",
                "image",
                "steps",
                false
        );

        repository.save(recipe);

        // Act
        Long recipeId = recipe.getId();
        Recipe result = repository.findById(recipeId);

        // Assert
        assertNotNull(result);
        assertEquals(recipeId, result.getId());
    }

    @Test
    void shouldReturnNullWhenRecipeDoesNotExist() throws SQLException {
        // Arrange
        long nonExistingRecipeId = -1L;

        // Act
        Recipe result = repository.findById(nonExistingRecipeId);

        // Assert
        assertNull(result);
    }

    @Test
    void shouldReturnListOfRecipes() throws SQLException {
        // Act
        List<Recipe> result = repository.findAll();

        // Assert
        assertNotNull(result);
        // Add more assertions based on your specific requirements
    }

    @Test
    void shouldInsertRecipeIntoDatabase() throws SQLException {
        // Arrange
        Recipe recipeToSave = new Recipe(
                "Receita Teste",
                "description",
                "ingrediente",
                "image",
                "steps",
                false
        );

        // Act
        repository.save(recipeToSave);

        // Assert
        // Check if the recipe was inserted successfully and assert accordingly
    }

    @Test
    void shouldUpdateRecipeInDatabase() throws SQLException {
        // Arrange
        Recipe existingRecipe = new Recipe(); // Set necessary properties for an existing recipe

        // Act
        repository.update(existingRecipe);

        // Assert
        // Check if the recipe was updated successfully and assert accordingly
    }

    @Test
    void shouldDeleteRecipeFromDatabase() throws SQLException {
        // Arrange
        long recipeIdToDelete = 1L;

        // Act
        repository.delete(recipeIdToDelete);

        // Assert
        // Check if the recipe was deleted successfully and assert accordingly
    }

    @Test
    void shouldReturnListOfFavoriteRecipes() throws SQLException {
        // Act
        List<Recipe> result = repository.findAllFavorites();

        // Assert
        assertNotNull(result);
        // Add more assertions based on your specific requirements
    }
}