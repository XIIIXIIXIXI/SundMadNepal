package com.example.sundmadnepal.SundNepal.domain.repository

import com.example.sundmadnepal.SundNepal.data.Recipe
import kotlinx.coroutines.flow.Flow

/**
 * [RecipesRepository] serves as the model layer for our Main screen. This allows the logic
 * to request a list of recipes.
 * This interface decides what data gets passed to the viewmodel.
 *
 * Interface is used so that we can create multiple implementations and swap them out.
 */

interface RecipeRepository {

    fun getRecipes(): Flow<List<Recipe>>

    suspend fun getRecipeById(id: Int): Recipe?

    suspend fun addRecipe(recipe: Recipe)
}