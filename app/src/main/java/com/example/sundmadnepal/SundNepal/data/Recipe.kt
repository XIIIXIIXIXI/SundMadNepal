package com.example.sundmadnepal.SundNepal.data

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sundmadnepal.R
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
    //val keyIngrediens: List<alfred>
)

data class Recipe2(
    val name: String,
    val image: String,
    val prepTime: String,
    val energy: String,
    val healthy: String,
    val information: String,
    val keyIngrediens: List<alfred>
)

data class alfred(@DrawableRes val image: Int, val title: String, val undertitle: String)
//this is for preview.
val Cake = Recipe2(
    name = "Cake",
    prepTime = "30 Min.",
    energy = "456 Cal",
    image = "lasagna",
    healthy = "6/10",
    information = "A freshly baked cake smothered in frosting makes an irresistible homemade dessert.",
    keyIngrediens = listOf(
        alfred(R.drawable.eggs, "eggs", "4"),
        alfred(R.drawable.onion, "onion", "6"),
        alfred(R.drawable.garlic, "garlic", "100g"),
        alfred(R.drawable.spinach, "spinach", "50g"),
        alfred(R.drawable.carrot, "carrot", "3"),
        alfred(R.drawable.pasta, "pasta", "250g")
    )

)