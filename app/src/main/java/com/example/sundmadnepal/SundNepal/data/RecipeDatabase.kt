package com.example.sundmadnepal.SundNepal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Contains the database holder and serves as the main access point for the underlying
 * connection to the app's persisted, relational data.
 */

@Database(entities = [Recipe::class, Steps::class, KeyIngredient::class, RecipeKeyIngredientCrossRef::class], version = 1)
abstract class RecipeDatabase: RoomDatabase() {

        abstract val dao: RecipeDao

}