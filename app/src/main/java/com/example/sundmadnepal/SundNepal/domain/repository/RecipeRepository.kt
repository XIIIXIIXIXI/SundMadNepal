package com.example.sundmadnepal.SundNepal.domain.repository


import com.example.sundmadnepal.SundNepal.data.*

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

    fun getRecipeWithKeyIngredientsAndSteps(): Flow<List<RecipeWithKeyIngredientsAndSteps>>

    suspend fun insertKeyIngredient(keyIngredient: KeyIngredient)

    suspend fun insertRecipeKeyIngredientCrossRef(recipeKeyIngredientCrossRef: RecipeKeyIngredientCrossRef)

    suspend fun insertSteps(steps: Steps)

    fun getRecipeWithKeyIngredientsAndStepsByName(recipeName: String) :RecipeWithKeyIngredientsAndSteps

}