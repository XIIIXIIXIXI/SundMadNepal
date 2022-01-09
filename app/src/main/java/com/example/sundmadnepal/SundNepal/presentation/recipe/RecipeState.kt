package com.example.sundmadnepal.SundNepal.presentation.recipe

import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.data.RecipeLocal
import com.example.sundmadnepal.SundNepal.data.RecipeWithKeyIngredients


/**
 * This data class represents the view state for the recipe screen.
 * All of this data should be formatted in a way that the recipe screen can just
 * take the information and display it.
 */
data class RecipeState(
    val recipes: List<Recipe> = emptyList(),
    val recipeswithKey: List<RecipeWithKeyIngredients> = emptyList(),
    val multiplier: Int = 1,
    val completedStep: List<Boolean> = emptyList()
)