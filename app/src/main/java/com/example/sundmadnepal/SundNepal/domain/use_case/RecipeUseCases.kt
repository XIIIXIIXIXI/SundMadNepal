package com.example.sundmadnepal.SundNepal.domain.use_case

/**
 * Class for single feature use cases to make the viewModel constructor more clean
 */

data class RecipeUseCases(
    val getRecipes: GetRecipes,
    val addRecipe: AddRecipe
)
