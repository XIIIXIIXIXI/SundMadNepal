package com.example.sundmadnepal.SundNepal.presentation.recipe

import com.example.sundmadnepal.SundNepal.domain.model.Recipes

data class RecipeViewState(
    val recipesTh: List<Recipes> = emptyList()
)