package com.example.sundmadnepal.SundNepal.data

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Contains methods used for accessing the database.
 * This is HOW we like to retrieve and change the data.
 */

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecipe(recipe: Recipe)

    @Query("SELECT * FROM recipe")
    fun getRecipes(): Flow<List<Recipe>>

    @Query("Select * FROM recipe WHERE recipeName = :recipeName")
    suspend fun getRecipeByName(recipeName: String): Recipe?
/*
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertKeyIngredients(keyIngredients: KeyIngredients)*/

    @Transaction
    @Query("SELECT * FROM recipe")
    fun getRecipeWithKeyIngredients(): Flow<List<RecipeWithKeyIngredients>>

    @Transaction
    @Query("SELECT * FROM recipe")
    fun getRecipeWithKeyIngredientsAndSteps(): Flow<List<RecipeWithKeyIngredientsAndSteps>>

    @Query("SELECT * FROM recipe WHERE recipeName = :recipeName")
    fun getRecipeWithKeyIngredientsAndStepsByName(recipeName: String) :RecipeWithKeyIngredientsAndSteps


    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSteps(steps: Steps)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addKeyIngredient(keyIngredient: KeyIngredient)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipe(recipe: Recipe)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertKeyIngredient(keyIngredient: KeyIngredient)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipeKeyIngredientCrossRef(recipeKeyIngredientCrossRef: RecipeKeyIngredientCrossRef)
}