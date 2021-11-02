package com.example.sundmadnepal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HViewModel(
    private val recipesRepository: RecipesRepository,
) : ViewModel() {

    private val _viewState = MutableStateFlow(HViewState())
    val viewState: StateFlow<HViewState> = _viewState

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