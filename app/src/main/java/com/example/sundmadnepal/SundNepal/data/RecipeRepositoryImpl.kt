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


    override suspend fun getRecipeByName(name: String): Recipe? {
        return dao.getRecipeByName(name)
    }

    override suspend fun addRecipe(recipe: Recipe) {
        dao.addRecipe(recipe)
    }
    override suspend fun addKeyIngredient(keyIngredient: List<KeyIngredient>){
        for (element in keyIngredient){
            dao.addKeyIngredient(element)
        }

    }
    override  fun getRecipeWithKeyIngredients(): Flow<List<RecipeWithKeyIngredients>> {
        return dao.getRecipeWithKeyIngredients()
    }

    override suspend fun insertKeyIngredient(keyIngredient: KeyIngredient) {
        dao.insertKeyIngredient(keyIngredient)
    }

    override suspend fun insertRecipeKeyIngredientCrossRef(recipeKeyIngredientCrossRef: RecipeKeyIngredientCrossRef) {
        dao.insertRecipeKeyIngredientCrossRef(recipeKeyIngredientCrossRef)
    }


}