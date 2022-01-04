package com.example.sundmadnepal.SundNepal.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception

/**
 * Define what kind of data we have
 */

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: String,
    //val keyIngrediens: List<Int>
)

class InvalidRecipeException(message: String): Exception(message)