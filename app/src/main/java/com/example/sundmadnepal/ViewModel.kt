package com.example.sundmadnepal

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sundmadnepal.SundNepal.domain.repository.RecipesRepository
import com.example.sundmadnepal.SundNepal.presentation.recipe.RecipeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HViewModel @Inject constructor(
    private val recipesRepository: RecipesRepository,
) : ViewModel() {

    private val _stateRecipe = mutableStateOf(RecipeViewState())
    val stateRecipe: State<RecipeViewState> = _stateRecipe

    init {
        fetchRecipes()
    }

    private fun fetchRecipes(){
        _stateRecipe.value = _stateRecipe.value.copy(
            recipesTh = recipesRepository.fetchRecipes()
        )
    }
}