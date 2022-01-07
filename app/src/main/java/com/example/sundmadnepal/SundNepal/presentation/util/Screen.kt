package com.example.sundmadnepal.SundNepal.presentation.util

sealed class Screen (val route: String){
    object RecipeScreen: Screen("recipe_screen")
    object HomeScreen: Screen("home_screen")
    object RecipeMenu: Screen("recipeMenu_screen")
    object ProfileScreen: Screen("profile_screen")
    object AboutScreen: Screen("About_screen")
    object IngredientScreen: Screen( "Ingredient_screen")
    object StepsScreen: Screen ("Steps_screen")


    object HealthInfoScreen: Screen("healthInfo_screen")
    object HealthAdult: Screen("healthAdult_screen")
    object HealthBaby: Screen("healthBaby_screen")
    object HealthChildren: Screen("healthChildren_screen")
    object HealthPregnant: Screen("healthPregnant_screen")
}
