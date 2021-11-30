package com.example.sundmadnepal.SundNepal.domain.repository

import com.example.sundmadnepal.SundNepal.domain.model.Recipes

interface RecipesRepository {
     fun fetchRecipes(): List<Recipes>
}