package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sundmadnepal.R
import com.example.sundmadnepal.SundNepal.data.*

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
        addRecipe()
        getRecipeWithkeyIngredients()
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
            val recipe: Recipe = Recipe( recipeName = "Cake", image =  "R.drawable.lasagna", energy = "50", prepTime = "30min.",  healthy = "6/10",
                information = "A freshly baked cake smothered in frosting makes an irresistible homemade dessert.")

               val keyIngredient = listOf(
                    KeyIngredient("tomato", "tomato", 4,"Cake"),
                    KeyIngredient("onion", "onion", 6,"Cake"),
                    KeyIngredient("garlic", "g garlic", 100,"Cake"),
                    KeyIngredient("spinach", "g spinach", 50,"Cake"),
                    KeyIngredient("carrot", "carrot", 3,"Cake"),
                    KeyIngredient("pasta", "g pasta", 250,"Cake")
                )
            repository.addRecipe(recipe)
            keyIngredient.forEach{repository.insertKeyIngredient(it)}
            val recipeKeyIngredientRelations = listOf(
                RecipeKeyIngredientCrossRef("Cake", "tomato"),
                RecipeKeyIngredientCrossRef("Cake", "onion"),
                RecipeKeyIngredientCrossRef("Cake", "garlic"),
                RecipeKeyIngredientCrossRef("Cake", "spinach"),
                RecipeKeyIngredientCrossRef("Cake", "carrot"),
                RecipeKeyIngredientCrossRef("Cake", "pasta")

            )
            recipeKeyIngredientRelations.forEach{repository.insertRecipeKeyIngredientCrossRef(it)}
                /*steps = listOf(
                    steps(stepText = "Put the lemons in a blender and bltiz along with half of the sugar, half the ice cubes and water.", R.drawable.tomato),
                    steps(stepText = "Strain the juice into a jug to get rid of any bits.", 0),
                    steps(stepText = "Put the lemon pulp back into the food processor. Add the rest of the sugar, ice cubes and water and blitz again.", 0),
                    steps(stepText = "Strain it into the jug with the first lot of juice and discard the pulp.", 0),
                    steps(stepText = "Serve with lots of ice", R.drawable.carrot)
                )*/


           /* for (element in keyIngredients){
                repository.insertKeyIngrdients(element)
            }*/

        }
    }


     fun ServingsMultiplier(increment: Int){
         val multiplier = _state.value.multiplier + increment

         if (multiplier == 0 && increment < 0){
             return
         }
        _state.value = _state.value.copy(
            multiplier = multiplier
        )
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
    private fun getRecipeWithkeyIngredients() {
        repository.getRecipeWithKeyIngredients()

            .onEach { recipe ->
                _state.value = _state.value.copy(
                    recipeswithKey = recipe
                )
            }
            .launchIn(viewModelScope)
    }
}