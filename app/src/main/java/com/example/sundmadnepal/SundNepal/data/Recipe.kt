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
    val keyIngrediens: List<alfred>,
    val steps: List<steps>
)

data class alfred(@DrawableRes val image: Int, val title: String, val undertitle: Int)

data class steps(val stepText: String, @DrawableRes val stepImage: Int)
//this is for preview.
val Cake = Recipe2(
    name = "Cake",
    prepTime = "30 Min.",
    energy = "456 Cal",
    image = "lasagna",
    healthy = "6/10",
    information = "A freshly baked cake smothered in frosting makes an irresistible homemade dessert.",
    keyIngrediens = listOf(
        alfred(R.drawable.tomato, "tomato", 4),
        alfred(R.drawable.onion, "onion", 6),
        alfred(R.drawable.garlic, "g garlic", 100),
        alfred(R.drawable.spinach, "g spinach", 50),
        alfred(R.drawable.carrot, "carrot", 3),
        alfred(R.drawable.pasta, "g pasta", 250)
    ),
    steps = listOf(
        steps(stepText = "Put the lemons in a blender and bltiz along with half of the sugar, half the ice cubes and water.", R.drawable.tomato),
        steps(stepText = "Strain the juice into a jug to get rid of any bits.", 0),
        steps(stepText = "Put the lemon pulp back into the food processor. Add the rest of the sugar, ice cubes and water and blitz again.", 0),
        steps(stepText = "Strain it into the jug with the first lot of juice and discard the pulp.", 0),
        steps(stepText = "Serve with lots of ice", R.drawable.carrot)


    )

)