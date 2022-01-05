package com.example.sundmadnepal.SundNepal.domain.use_case

import com.example.sundmadnepal.SundNepal.data.KeyIngredient
import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.data.defaultKeyIngredient
import com.example.sundmadnepal.SundNepal.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCases @Inject constructor() : RecipeRepository{
    override fun getRecipes(): Flow<List<Recipe>> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeById(id: Int): Recipe? {
        TODO("Not yet implemented")
    }

    override suspend fun addRecipe(recipe: Recipe) {
        TODO("Not yet implemented")
    }

}