package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        //addRecipe()
        getRecipeWithkeyIngredientsAndSteps()
        //getRecipeWithKeyIngredientsAndStepsByName("Vegetable Lasagna")
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
/*
            val steps = listOf(
                Stepss( 0, "Put the lemons in a blender and bltiz along with half of the sugar, half the ice cubes and water.", "tomato", "Cake"),
                Stepss(0,"Strain the juice into a jug to get rid of any bits.", "0", "Cake"),
                Stepss(0,"Put the lemon pulp back into the food processor. Add the rest of the sugar, ice cubes and water and blitz again.", "0", "Cake"),
                Stepss(0,"Strain it into the jug with the first lot of juice and discard the pulp.", "0", "Cake"),
                Stepss(0,"Serve with lots of ice", "carrot", "Cake")
            )
            steps.forEach{repository.insertSteps(it)}*/
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
         /*viewModelScope.launch {
             val steps = listOf(
                 Stepss(
                     0,
                     "Put the lemons in a blender and bltiz along with half of the sugar, half the ice cubes and water.",
                     "tomato",
                     "Cake"
                 ),
                 Stepss(0, "Strain the juice into a jug to get rid of any bits.", "0", "Cake"),
                 Stepss(
                     0,
                     "Put the lemon pulp back into the food processor. Add the rest of the sugar, ice cubes and water and blitz again.",
                     "0",
                     "Cake"
                 ),
                 Stepss(
                     0,
                     "Strain it into the jug with the first lot of juice and discard the pulp.",
                     "0",
                     "Cake"
                 ),
                 Stepss(0, "Serve with lots of ice", "carrot", "Cake")
             )
             steps.forEach { repository.insertSteps(it) }
         }*/
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
    private fun getRecipeWithkeyIngredientsAndSteps() {
        repository.getRecipeWithKeyIngredientsAndSteps()

            .onEach { recipe ->
                _state.value = _state.value.copy(
                    recipeswithKey = recipe
                )
            }
            .launchIn(viewModelScope)
    }

    fun getSpecificRecipe(number: Int){
        _state.value = _state.value.copy(
            recipe = _state.value.recipeswithKey[number].recipe
        )
        val keyWithImage: MutableList<KeyIngredient> = mutableListOf()
            _state.value.recipe.keyIngrediens.forEach { keyIngredient ->
            if (keyIngredient.image != "0"){
               keyWithImage.add(keyIngredient)
            }
        }
        _state.value = _state.value.copy(
            keyIngredientsWithImage = keyWithImage
        )
        _state.value = _state.value.copy(
            recipeWithSteps = _state.value.recipeswithKey[number]
        )
        val hi = number
    }


/*
    private fun getRecipeWithKeyIngredientsAndStepsByName(name: String) {
      val recipe =  repository.getRecipeWithKeyIngredientsAndStepsByName(name)
        _state.value = _state.value.copy(
            recipe = recipe
        )
    }*/
}