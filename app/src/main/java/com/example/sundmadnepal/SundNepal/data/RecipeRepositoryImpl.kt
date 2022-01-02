package com.example.sundmadnepal.SundNepal.data

import com.example.sundmadnepal.SundNepal.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 *
 */


class RecipeRepositoryImpl(
    private val dao: RecipeDao
): RecipeRepository {

    override fun getRecipes(): Flow<List<Recipe>> {
        return dao.getRecipes()
    }

    override suspend fun getRecipeById(id: Int): Recipe? {
        return dao.getRecipeById(id)
    }

    override suspend fun addRecipe(recipe: Recipe) {
        dao.addRecipe(recipe)
    }
}