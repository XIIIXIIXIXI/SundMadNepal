package com.example.sundmadnepal.SundNepal.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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

    @Query("Select * FROM recipe WHERE id = :id")
    suspend fun getRecipeById(id: Int): Recipe?
}