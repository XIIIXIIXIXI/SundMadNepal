package com.example.sundmadnepal

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.presentation.recipe.RecipeState
import com.example.sundmadnepal.SundNepal.presentation.recipe.RecipesViewModel

@Composable
fun RecipeScreen(
    navController: NavController,
    viewModel: RecipesViewModel = hiltViewModel()
) {
    val viewmodel = viewModel.state.value
    RecipeScreenContent(viewmodel, navController)

}

@Composable
private fun RecipeScreenContent(viewmodel: RecipeState, navController: NavController) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            //RecipesPrim(viewModel.state.value.recipes, navController)

        }
    }
}

/*
@Composable
private fun RecipesPrim(recipes: List<Recipe>, navController: NavController){
    var loopCount = 1
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
    ){
        recipes.forEach{ recipes ->
            RecipesThemeCard(recipes, loopCount, navController)
            loopCount++
        }
    }
}
*/



