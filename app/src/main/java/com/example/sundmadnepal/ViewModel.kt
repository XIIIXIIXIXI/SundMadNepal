package com.example.sundmadnepal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sundmadnepal.SundNepal.domain.repository.RecipesRepository
import com.example.sundmadnepal.SundNepal.presentation.RecipeViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HViewModel(
    private val recipesRepository: RecipesRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow(RecipeViewState())
    val viewState: StateFlow<RecipeViewState> = _viewState

    init {
        fetchRecipes()
    }

    private fun fetchRecipes(){
        viewModelScope.launch {
            val recipes = recipesRepository.fetchRecipes()

            _viewState.value = _viewState.value.copy(
                recipesTh = recipes
            )
        }
    }
}