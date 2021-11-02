package com.example.sundmadnepal

interface RecipesRepository {
    suspend fun fetchRecipes(): List<Recipes>
}