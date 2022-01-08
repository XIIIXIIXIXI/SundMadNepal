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
    override fun getRecipeWithkeyIngredients(): Flow<List<RecipeWithkeyIngredients>>{
        return dao.getRecipeWithkeyIngredients()
    }

    override suspend fun getRecipeByName(name: String): Recipe? {
        return dao.getRecipeByName(name)
    }

    override suspend fun addRecipe(recipe: Recipe) {
        dao.addRecipe(recipe)
    }

    override suspend fun insertKeyIngrdients(keyIngredients: KeyIngredients) {
        dao.insertKeyIngredients(keyIngredients)
    }


}