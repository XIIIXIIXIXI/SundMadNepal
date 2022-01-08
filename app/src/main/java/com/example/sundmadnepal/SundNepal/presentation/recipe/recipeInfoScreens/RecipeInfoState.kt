package com.example.sundmadnepal.SundNepal.presentation.recipe.recipeInfoScreens

/**
 * This data class represents the view state for the recipe screen.
 * All of this data should be formatted in a way that the recipe screen can just
 * take the information and display it.
 */

data class RecipeInfoState(
    val multiplier: Int = 1,
    val completedStep: List<Boolean> = emptyList()
)
