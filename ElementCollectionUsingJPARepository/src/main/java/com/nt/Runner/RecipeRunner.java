package com.nt.Runner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Entity.Recipe;
import com.nt.serice.RecipeBookService;
//import com.nt.Serice.RecipeBookService;

@Component
public class RecipeRunner implements CommandLineRunner {

    private final RecipeBookService service;

    public RecipeRunner(RecipeBookService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {

        // SAVE 5 SAMPLE RECIPES

        Recipe r1 = new Recipe(
                "Biryani",
                "Indian"
        );
        r1.setIngredients(Arrays.asList("Rice", "Chicken", "Spices"));
        r1.setCookingTips(new HashSet<>(
                Arrays.asList("Cook on low flame", "Use fresh spices")));

        Recipe r2 = new Recipe(
                "Pizza",
                "Italian"
        );
        r2.setIngredients(Arrays.asList("Dough", "Cheese", "Tomato Sauce"));
        r2.setCookingTips(new HashSet<>(
                Arrays.asList("Preheat oven", "Use mozzarella")));

        Recipe r3 = new Recipe(
                "Noodles",
                "Chinese"
        );
        r3.setIngredients(Arrays.asList("Noodles", "Vegetables", "Sauce"));
        r3.setCookingTips(new HashSet<>(
                Arrays.asList("Do not overcook noodles")));

        Recipe r4 = new Recipe(
                "Burger",
                "American"
        );
        r4.setIngredients(Arrays.asList("Bun", "Patty", "Cheese"));
        r4.setCookingTips(new HashSet<>(
                Arrays.asList("Toast the bun")));

        Recipe r5 = new Recipe(
                "Tacos",
                "Mexican"
        );
        r5.setIngredients(Arrays.asList("Tortilla", "Chicken", "Salsa"));
        r5.setCookingTips(new HashSet<>(
                Arrays.asList("Serve hot")));

        service.saveAllRecipes(List.of(r1, r2, r3, r4, r5));

        System.out.println("\n========== RECIPES SAVED ==========\n");

        // FETCH ALL

        System.out.println("===== ALL RECIPES =====");

        service.getAllRecipes().forEach(recipe -> {
            System.out.println("--------------------------------");
            System.out.println("ID : " + recipe.getRecipeId());
            System.out.println("Name : " + recipe.getRecipeName());
            System.out.println("Cuisine : " + recipe.getCuisine());
            System.out.println("Ingredients : " + recipe.getIngredients());
            System.out.println("Cooking Tips : " + recipe.getCookingTips());
        });

        // FIND BY ID
        System.out.println("\n===== FIND BY ID =====");

        service.getRecipeById(1L).ifPresent(recipe -> {
            System.out.println("Recipe Found:");
            System.out.println(recipe);
        });

        // UPDATE INGREDIENTS

        System.out.println("\n===== UPDATE INGREDIENTS =====");

        service.updateIngredients(
                1L,
                Arrays.asList("Rice", "Chicken", "Saffron", "Spices")
        );

        service.getRecipeById(1L).ifPresent(recipe -> {
            System.out.println("Updated Recipe:");
            System.out.println(recipe);
        });

        // DELETE

        System.out.println("\n===== DELETE RECIPE =====");

        service.deleteRecipe(5L);

        System.out.println("Recipe with ID 5 deleted.");

        System.out.println("\n===== RECIPES AFTER DELETE =====");

        service.getAllRecipes().forEach(System.out::println);
    }
}
