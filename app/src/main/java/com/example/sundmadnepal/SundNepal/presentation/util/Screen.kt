package com.example.sundmadnepal.SundNepal.presentation.util

sealed class Screen (val route: String){
    object RecipeScreen: Screen("recipe_screen")
    object HomeScreen: Screen("home_screen")
    object RecipeMenu: Screen("recipeMenu_screen")
}
