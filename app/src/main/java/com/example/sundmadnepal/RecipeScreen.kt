package com.example.sundmadnepal

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun RecipeScreen(navController: NavController){

    val factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T{
            val repository = inMemoryRecipeService()

                @Suppress("UNCHECKED_CAST")
                return HViewModel(
                    recipesRepository = repository
                ) as T
        }
    }

    val recipeViewModel : HViewModel = viewModel(factory = factory)

    val currentState: State<HViewState> = recipeViewModel.viewState.collectAsState()

        RecipeScreenScaffold(navController, currentState.value)

}

@Composable
fun RecipeScreenScaffold(navController: NavController, state: HViewState){
    Scaffold(
        bottomBar = {
            NepalToolBar(navController)
        }
    ){
        RecipeScreenContent(state, navController)
    }
}

@Composable
private fun RecipeScreenContent(state: HViewState, navController: NavController){
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            RecipesPrim(state.recipesTh, navController)

        }
    }
}

@Composable
private fun RecipesPrim(recipes: List<Recipes>, navController: NavController){
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