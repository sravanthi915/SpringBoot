package com.nt.serice;

import java.util.List;
import java.util.Optional;

import com.nt.Entity.Recipe;

public interface IServiceInterface {

	public Recipe saveRecipe(Recipe recipe);

	public List<Recipe> saveAllRecipes(List<Recipe> recipes);

	public List<Recipe> getAllRecipes();

	public Optional<Recipe> getRecipeById(Long id);

	public Recipe updateIngredients(Long id, List<String> newIngredients);

	public void deleteRecipe(Long id);

}
