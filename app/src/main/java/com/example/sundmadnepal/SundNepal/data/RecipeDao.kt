package com.example.sundmadnepal.SundNepal.data

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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertKeyIngredients(keyIngredients: KeyIngredients)

    @Transaction
    @Query("SELECT * FROM recipe")
    fun getRecipeWithkeyIngredients(): Flow<List<RecipeWithkeyIngredients>>
}