package com.example.sundmadnepal.SundNepal.domain.use_case

import com.example.sundmadnepal.SundNepal.domain.model.Recipes
import com.example.sundmadnepal.SundNepal.domain.model.allRecipes
import com.example.sundmadnepal.SundNepal.domain.repository.RecipesRepository

class ShowRecipes : RecipesRepository {
    override suspend fun fetchRecipes(): List<Recipes> {
        return allRecipes
    }
}