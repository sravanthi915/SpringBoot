package com.nt.serice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.Entity.Recipe;
import com.nt.Repository.RecipeRepository;

@Service
public class RecipeBookService {

    private final RecipeRepository repository;

    public RecipeBookService(RecipeRepository repository) {
        this.repository = repository;
    }

    // Save a recipe
    public Recipe saveRecipe(Recipe recipe) {
        return repository.save(recipe);
    }

    // Save multiple recipes
    public List<Recipe> saveAllRecipes(List<Recipe> recipes) {
        return repository.saveAll(recipes);
    }

    // Fetch all recipes
    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }

    // Find by ID
    public Optional<Recipe> getRecipeById(Long id) {
        return repository.findById(id);
    }

    // Update ingredients
    public Recipe updateIngredients(Long id, List<String> newIngredients) {
        Recipe recipe = repository.findById(id).orElseThrow(() -> 
            new RuntimeException("Recipe not found with id " + id));
        recipe.setIngredients(newIngredients);
        return repository.save(recipe);
    }

    // Delete recipe
    public void deleteRecipe(Long id) {
        repository.deleteById(id); 
    }
}
