package com.example.sundmadnepal.SundNepal.data

import androidx.annotation.DrawableRes
import androidx.room.*
import com.example.sundmadnepal.R
import java.lang.Exception

/**
 * Define what kind of data we have
 */

@Entity(tableName = "recipe")
data class Recipe(
    @PrimaryKey(autoGenerate = false)
    val recipeName: String,
    val image: String,
    val prepTime: String,
    val energy: String,
    val healthy: String,
    val information: String,
    //@Ignore
    //val keyIngrediens: List<KeyIngredient>,
    //val steps: List<steps>
)

@Entity
data class KeyIngredients(
    @PrimaryKey(autoGenerate = false)
    val title: String,
    val image: String,
    val undertitle: Int,
    val recipeName: String
)

data class RecipeWithkeyIngredients(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipeName",
        entityColumn = "recipeName"
    )
    val keyIngredients: List<KeyIngredients>
)
//@Embedded

data class Recipe2(
    val name: String,
    val image: String,
    val prepTime: String,
    val energy: String,
    val healthy: String,
    val information: String,
    val keyIngrediens: List<KeyIngredient>,
    val steps: List<steps>
)
data class KeyIngredient(
    val image: String,
    val title: String,
    val undertitle: Int,
    val recipeName: String
)


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
        KeyIngredient("tomato", "tomato", 4,"Cake"),
        KeyIngredient("onion", "onion", 6,"Cake"),
        KeyIngredient("garlic", "g garlic", 100,"Cake"),
        KeyIngredient("spinach", "g spinach", 50,"Cake"),
        KeyIngredient("carrot", "carrot", 3,"Cake"),
        KeyIngredient("pasta", "g pasta", 250,"Cake")
    ),
    steps = listOf(
        steps(stepText = "Put the lemons in a blender and bltiz along with half of the sugar, half the ice cubes and water.", R.drawable.tomato),
        steps(stepText = "Strain the juice into a jug to get rid of any bits.", 0),
        steps(stepText = "Put the lemon pulp back into the food processor. Add the rest of the sugar, ice cubes and water and blitz again.", 0),
        steps(stepText = "Strain it into the jug with the first lot of juice and discard the pulp.", 0),
        steps(stepText = "Serve with lots of ice", R.drawable.carrot)
    )

)