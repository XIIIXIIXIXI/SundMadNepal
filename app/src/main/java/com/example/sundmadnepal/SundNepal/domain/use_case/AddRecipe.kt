package com.example.sundmadnepal.SundNepal.domain.use_case

import com.example.sundmadnepal.SundNepal.data.InvalidRecipeException
import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.domain.repository.RecipeRepository

class AddRecipe(
    private val repository: RecipeRepository
){
    @Throws(InvalidRecipeException::class)
    suspend operator fun invoke(recipe: Recipe){
        if(recipe.name.isBlank()){
            throw InvalidRecipeException("Name of the recipe can't be empty.")
        }
        repository.addRecipe(recipe)
    }
}