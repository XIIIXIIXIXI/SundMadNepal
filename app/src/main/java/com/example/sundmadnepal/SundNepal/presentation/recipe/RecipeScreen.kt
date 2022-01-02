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
import com.example.sundmadnepal.SundNepal.presentation.recipe.RecipesViewModel

@Composable
fun RecipeScreen(navController: NavController,
                 viewModel: RecipesViewModel = hiltViewModel()){

        RecipeScreenScaffold(navController, viewModel)

}

@Composable
fun RecipeScreenScaffold(navController: NavController, viewModel: RecipesViewModel){
    Scaffold(
        bottomBar = {
            NepalToolBar(navController)
        }
    ){
        RecipeScreenContent(viewModel, navController)
    }
}

@Composable
private fun RecipeScreenContent(viewModel: RecipesViewModel, navController: NavController){
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ){
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

@Composable
private fun NepalToolBar(navController: NavController){
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
    ){
        NepalToolButton(
            navController,
            labelText = "Home",
            route = "HomeScreen",
            selected = false,
            icon = Icons.Default.Home
        )
        NepalToolButton(
            navController,
            labelText = "Recipes",
            route = "RecipeScreen",
            selected = true,
            icon = Icons.Default.Build
        )
        NepalToolButton(
            navController,
            labelText = "HealthInfo",
            route = "HealthInfoscreen",
            icon = Icons.Default.Favorite,
            selected = false
        )
        NepalToolButton(
            navController,
            labelText = "Profile",
            route = "ProfileScreen",
            selected = false,
            icon = Icons.Default.Person

        )
    }
}


@Composable
private fun RowScope.NepalToolButton(
    navController: NavController,
    selected: Boolean,
    route: String,
    icon: ImageVector,
    labelText: String,
){
    BottomNavigationItem(
        selected = selected,
        onClick = {
            navController.navigate(route)
        },
        icon = {
            Icon(
                icon,
                contentDescription = null,
            )
        },
        label = {
            Text(labelText)
        }
    )
}

