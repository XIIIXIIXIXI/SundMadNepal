package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sundmadnepal.SundNepal.domain.repository.RecipeRepository
import com.example.sundmadnepal.SundNepal.domain.use_case.RecipeUseCases
import com.example.sundmadnepal.SundNepal.domain.util.OrderType
import com.example.sundmadnepal.SundNepal.domain.util.RecipeOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val recipeUseCases: RecipeUseCases
): ViewModel(){

    private val _state = mutableStateOf(RecipeState())
    val state: State<RecipeState> = _state

    private var getRecipesJob: Job? = null

    init {
        getRecipes(RecipeOrder.Id(OrderType.Descending))
    }
    /**
     * this function will trigger get triggered from the UI
     */
    fun onEvent(event: RecipesEvent){
        when (event) {
            is RecipesEvent.Order -> {
                //checks if the order is already what is requested, The class is for checking the recipe order class is the same
                if(state.value.recipeOrder::class == event.recipeOrder::class &&
                        state.value.recipeOrder.orderType == event.recipeOrder.orderType){
                    return
                }
                getRecipes(event.recipeOrder)
            }
            //is .. etc
        }
    }

    /**
     * Without [getRecipesJob] every single time we call this function we get a new
     * instance of that flow because we call [getRecipes] function every single time.
     *
     */
    private fun getRecipes(recipeOrder: RecipeOrder){
        getRecipesJob?.cancel()
        getRecipesJob = recipeUseCases.getRecipes(recipeOrder)
            .onEach { recipe ->
                _state.value = state.value.copy(
                    recipes = recipe,
                    recipeOrder = recipeOrder
                )
            }
            .launchIn(viewModelScope)
    }
}