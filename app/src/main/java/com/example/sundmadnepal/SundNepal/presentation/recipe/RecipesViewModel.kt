package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.data.RecipeRepositoryImpl
import com.example.sundmadnepal.SundNepal.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    private val repository: RecipeRepository
): ViewModel(){

    private val _state = mutableStateOf(RecipeState())
    val state: State<RecipeState> = _state


    init {
        getRecipes()
    }
    /**
     * this function will trigger get triggered from the UI
     */
    /*
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
*/
    /**
     * Without [getRecipesJob] every single time we call this function we get a new
     * instance of that flow because we call [getRecipes] function every single time.
     *
     */
    private fun addRecipe(){
        viewModelScope.launch {
            val recipe: Recipe = Recipe(0, "lasagna", 24)
            repository.addRecipe(recipe)
        }
    }

    private fun getRecipes() {
            repository.getRecipes()
            .onEach { recipe ->
                _state.value = _state.value.copy(
                    recipes = recipe
                )
            }
            .launchIn(viewModelScope)
    }
}