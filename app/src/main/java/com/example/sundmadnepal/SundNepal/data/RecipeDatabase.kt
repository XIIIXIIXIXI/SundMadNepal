package com.example.sundmadnepal.SundNepal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Contains the database holder and serves as the main access point for the underlying
 * connection to the app's persisted, relational data.
 */

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {

        abstract val recipeDao: RecipeDao

        companion object {
                const  val DATABASE_NAME = "recipes_db"
        }
}