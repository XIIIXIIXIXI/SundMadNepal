package com.example.sundmadnepal.SundNepal.domain.repository


import com.example.sundmadnepal.SundNepal.data.KeyIngredient

import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.data.RecipeKeyIngredientCrossRef
import com.example.sundmadnepal.SundNepal.data.RecipeWithKeyIngredients

import kotlinx.coroutines.flow.Flow

/**
 * [RecipeRepository] serves as the model layer for our Main screen. This allows the logic
 * to request a list of recipes.
 * This interface decides what data gets passed to the viewmodel.
 *
 * Interface is used so that we can create multiple implementations and swap them out.
 */

interface RecipeRepository {

    fun getRecipes(): Flow<List<Recipe>>

    suspend fun getRecipeByName(name: String): Recipe?

    suspend fun addRecipe(recipe: Recipe)

    suspend fun addKeyIngredient(keyIngredient: List<KeyIngredient>)

    fun getRecipeWithKeyIngredients(): Flow<List<RecipeWithKeyIngredients>>

    suspend fun insertKeyIngredient(keyIngredient: KeyIngredient)

    suspend fun insertRecipeKeyIngredientCrossRef(recipeKeyIngredientCrossRef: RecipeKeyIngredientCrossRef)

}