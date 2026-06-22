
package com.nt.Entity;

import java.util.List;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Recipe {
	
	 @Id
	 @SequenceGenerator( sequenceName = "recipeSqn" ,name = "recipeSqn" , initialValue = 1 , allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeSqn")
	 private Long recipeId;
	 
	 @NonNull
	 private String recipeName;
	 @NonNull
	 private String cuisine;
	 
	 
	 @ElementCollection(fetch = FetchType.EAGER)
	 @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
	 @Column(name = "ingredient")
	 private List<String> ingredients;
	 
	 @ElementCollection(fetch=FetchType.EAGER)
	 @CollectionTable(name = "recipe_tips", joinColumns = @JoinColumn(name = "recipe_id"))
	 @Column(name = "tip")
	 private Set<String> cookingTips;
	
}
