package com.example.sundmadnepal

class inMemoryRecipeService : RecipesRepository {
    override suspend fun fetchRecipes(): List<Recipes> {
        return allRecipes
    }
}