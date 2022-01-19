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
        getRecipeWithkeyIngredientsAndSteps()
        addRecipe()
    }

    //Add recipes
    fun setName(name: String){
        if (name.isNotEmpty()){
            _state.value.addRecipe = _state.value.addRecipe.copy(
                recipeName = name
            )
            _state.value = _state.value.copy(
                recipeNameAccepted = true
            )
        }
    }
    fun setInformation(name: String){
        if (name.isNotEmpty()){
            _state.value.addRecipe = _state.value.addRecipe.copy(
                information = name
            )
            _state.value = _state.value.copy(
                recipeInformationAccepted = true
            )
        }
    }












    private fun getRecipeWithkeyIngredientsAndSteps() {
        repository.getRecipeWithKeyIngredientsAndSteps()

            .onEach { recipe ->
                _state.value = _state.value.copy(
                    recipeswithKey = recipe
                )
            }
            .launchIn(viewModelScope)

        val hi = 2

    }
    fun setImage(){
        val keyImage: MutableList<String> = mutableListOf()

        for (i in _state.value.recipeswithKey.indices){
            for (image in _state.value.recipeswithKey[i].recipe.keyIngrediens.indices){
                if (_state.value.recipeswithKey[i].recipe.keyIngrediens[image].image != "0"){
                    keyImage.add(_state.value.recipeswithKey[i].recipe.keyIngrediens[image].image)
                }
            }
        }
        _state.value = _state.value.copy(
            keyImages = keyImage
        )
    }
    fun setChosenImage(ingredient: String){
        val chosenIngredient: MutableList<String> = mutableListOf()
        for (image in _state.value.chosenIngredient){
            chosenIngredient.add(image)
        }
        chosenIngredient.add(ingredient)
        _state.value = _state.value.copy(
            chosenIngredient = chosenIngredient
        )
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
        val steps: MutableList<Boolean> = mutableListOf()
        for (step in _state.value.recipeWithSteps.steps.indices){
            steps.add(false)
        }
        _state.value = _state.value.copy(
            completedStep = steps
        )
        _state.value = _state.value.copy(
            rememberRecipeNumber = number
        )

        val hi = 2
    }

    private fun addRecipe(){
        viewModelScope.launch {
            val recipe: Recipe = Recipe( recipeName = "Cake", image =  "lasagna", energy = "50", prepTime = "30min.",  healthy = "6/10",
                information = "A freshly baked cake smothered in frosting makes an irresistible homemade dessert.", favorite = 0)

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




    fun CompletedStep(stepNumber: Int){
        val steps: MutableList<Boolean> =  _state.value.completedStep
        val bol = !_state.value.completedStep[stepNumber]
        steps[stepNumber] = bol
        _state.value = _state.value.copy(
            completedStep = steps
        )
        val hi = 3
    }

    fun Recompose(){
        if (_state.value.recompose != 17){
            _state.value = _state.value.copy(
                recompose = 17
            )
        } else {
            _state.value = _state.value.copy(
                recompose = 18
            )
        }
    }
    fun AddRecipeRecompose(){
        if (_state.value.addRecipeRecompose != 1){
            _state.value = _state.value.copy(
                recompose = 1
            )
        } else {
            _state.value = _state.value.copy(
                recompose = 0
            )
        }
    }

    fun updateFavorite(recipeName: String){
        viewModelScope.launch {
            if (_state.value.isFavorite == 0){
                repository.UpdateFavorite(1, recipeName)
            }else{
                repository.UpdateFavorite(0,recipeName)
            }
        }

    }


    fun InitializeFavorite(favorite: Int){
        _state.value = _state.value.copy(
            isFavorite = favorite
        )
    }
    fun ChangeLocalFavorite(favorite: Int){
        if (favorite == 0){
            _state.value = _state.value.copy(
                isFavorite = 1
            )
        }else{
            _state.value = _state.value.copy(
                isFavorite = 0
            )
        }
    }
    fun getFavorite(){
        var favorite: MutableList<Favorite> = mutableListOf()
        for (i in _state.value.recipeswithKey.indices){
            if (_state.value.recipeswithKey[i].recipe.recipe.favorite == 1){
                    favorite.add(Favorite(_state.value.recipeswithKey[i].recipe.recipe, i))

            }
        }
        _state.value = _state.value.copy(
            favorites = favorite
        )
    }
}