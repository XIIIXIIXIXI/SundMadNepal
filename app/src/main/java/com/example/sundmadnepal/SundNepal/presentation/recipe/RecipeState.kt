package com.example.sundmadnepal.SundNepal.presentation.recipe

import com.example.sundmadnepal.SundNepal.data.*


/**
 * This data class represents the view state for the recipe screen.
 * All of this data should be formatted in a way that the recipe screen can just
 * take the information and display it.
 */
data class RecipeState(
    //Main parent viewStates
    val recipes: List<Recipe> = emptyList(),
    val recipeswithKey: List<RecipeWithKeyIngredientsAndSteps> = emptyList(),


    //Used for faster calls for specific items in a recipe.
    val fillerRecipe: Recipe = Recipe("","","","","","", 0),
    val fillerKeyIngredients: List<KeyIngredient> = emptyList(),
    val fillerSteps: List<Steps> = emptyList(),
    val recipe: RecipeWithKeyIngredients = RecipeWithKeyIngredients(fillerRecipe, fillerKeyIngredients),
    val keyIngredientsWithImage: MutableList<KeyIngredient> = mutableListOf(),
    val recipeWithSteps: RecipeWithKeyIngredientsAndSteps = RecipeWithKeyIngredientsAndSteps(recipe,fillerSteps),
    val favorites: MutableList<Favorite> = mutableListOf(),

    //Add recipe
    var addRecipe: Recipe = Recipe("Choose a name..", "defaultImage", "0", "0", "0/10", "Choose a fitting description for your recipe", 0),
    val keyImages: MutableList<String> = mutableListOf(),
    val chosenIngredient: MutableList<String> = mutableListOf(),

    //UI
    val completedStep: MutableList<Boolean> = mutableListOf(),
    val multiplier: Int = 1,
    val recompose: Int = 17,
    val addRecipeRecompose: Int = 1,
    val rememberRecipeNumber: Int = 0,
    val isFavorite: Int = 0,

    //UI Add recipe
    val recipeNameAccepted: Boolean = false,
    val recipeInformationAccepted: Boolean = false,
    )