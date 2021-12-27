package com.example.sundmadnepal.SundNepal.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception

@Entity(tableName = "recipe_table")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: Int,
    val keyIngrediens: List<Int>
)

class InvalidRecipeException(message: String): Exception(message)