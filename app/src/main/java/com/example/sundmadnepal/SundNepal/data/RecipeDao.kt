package com.example.sundmadnepal.SundNepal.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Contains methods used for accessing the database.
 */

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecipe(recipe: Recipe)

    @Query("SELECT * FROM recipe_table ORDER BY id ASC")
    fun getRecipes(): Flow<List<Recipe>>

    @Query("Select * FROM recipe_table WHERE id = :id")
    suspend fun getRecipeById(id: Int): Recipe?
}