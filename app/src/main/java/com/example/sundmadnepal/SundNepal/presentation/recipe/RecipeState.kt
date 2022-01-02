package com.example.sundmadnepal.SundNepal.presentation.recipe

import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.domain.util.OrderType
import com.example.sundmadnepal.SundNepal.domain.util.RecipeOrder


/**
 * This data class represents the view state for the recipe screen.
 * All of this data should be formatted in a way that the recipe screen can just
 * take the information and display it.
 */
data class RecipeState(
    val recipes: List<Recipe> = emptyList(),
    val recipeOrder: RecipeOrder = RecipeOrder.Id(OrderType.Descending)

)