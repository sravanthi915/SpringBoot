package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	

}
