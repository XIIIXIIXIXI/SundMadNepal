package com.example.sundmadnepal.SundNepal.presentation.recipe

import com.example.sundmadnepal.SundNepal.domain.util.RecipeOrder

/**
 * All the events that gets triggered whenever something is pressed in the UI.
 */

sealed class RecipesEvent{
    data class Order(val recipeOrder: RecipeOrder): RecipesEvent()
}
