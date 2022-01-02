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

}