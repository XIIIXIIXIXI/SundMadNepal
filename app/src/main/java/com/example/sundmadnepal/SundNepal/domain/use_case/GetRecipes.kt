package com.example.sundmadnepal.SundNepal.domain.use_case


import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.domain.repository.RecipeRepository
import com.example.sundmadnepal.SundNepal.domain.util.OrderType
import com.example.sundmadnepal.SundNepal.domain.util.RecipeOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetRecipes(
    private val repository: RecipeRepository
) {
    operator fun invoke(
        recipeOrder: RecipeOrder = RecipeOrder.Id(OrderType.Descending)
    ): Flow<List<Recipe>> {
        return repository.getRecipes().map { recipes ->
            when(recipeOrder.orderType){
                is OrderType.Ascending -> {
                    when (recipeOrder) {
                        is RecipeOrder.Id -> recipes.sortedBy { it.id }
                        is RecipeOrder.Title -> recipes.sortedBy { it.name.lowercase() }
                    }
                }
                is OrderType.Descending -> {
                    when (recipeOrder) {
                        is RecipeOrder.Id -> recipes.sortedByDescending { it.id }
                        is RecipeOrder.Title -> recipes.sortedByDescending { it.name.lowercase() }
                    }
                }
            }
        }
    }
}