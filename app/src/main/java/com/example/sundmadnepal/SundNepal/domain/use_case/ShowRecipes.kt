package com.example.sundmadnepal.SundNepal.domain.use_case

import com.example.sundmadnepal.SundNepal.domain.model.Recipes
import com.example.sundmadnepal.SundNepal.domain.model.allRecipes
import com.example.sundmadnepal.SundNepal.domain.repository.RecipesRepository
import javax.inject.Inject

class ShowRecipes @Inject constructor() : RecipesRepository {

    override fun fetchRecipes(): List<Recipes> {
        return allRecipes
    }
}