package com.example.sundmadnepal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.data.Cake
import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.presentation.recipe.RecipeState
import com.example.sundmadnepal.SundNepal.presentation.recipe.RecipesViewModel
import com.example.sundmadnepal.SundNepal.presentation.util.Screen
import com.example.sundmadnepal.ui.theme.LightGray
import com.example.sundmadnepal.ui.theme.Shapes
import com.example.sundmadnepal.ui.theme.SlightlyLessLightGray

@Composable
fun RecipeScreen(
    navController: NavController,
    viewModel: RecipesViewModel
) {
    val viewmodel = viewModel.state.value
    RecipeScreenContent(viewmodel, navController, viewModel)

}

@Composable
private fun RecipeScreenContent(viewmodel: RecipeState, navController: NavController, viewModel: RecipesViewModel) {
    LazyColumn() {
        items(viewmodel.recipeswithKey.size) { recipe ->
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,

                modifier = if (recipe % 2 == 0 && recipe != viewmodel.recipeswithKey.size) {
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = { viewModel.getSpecificRecipe(recipe)
                                    navController.navigate(Screen.AboutScreen.route) }
                            )
                        }
                } else {
                    Modifier
                        .fillMaxWidth()
                        .background(SlightlyLessLightGray)
                        .padding(vertical = 10.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = {viewModel.getSpecificRecipe(recipe)
                                    navController.navigate(Screen.AboutScreen.route) }
                            )
                        }
                }
            ) {

                Column(
                    modifier = Modifier
                        .padding(bottom = 0.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .padding(PaddingValues(end = 15.dp))
                            .width(100.dp)
                            .height(100.dp),
                        backgroundColor = LightGray,
                        shape = Shapes.large,
                        elevation = 0.dp
                    ) {
                        Image(
                            painterResource(id = LocalContext.current.resources.getIdentifier(viewmodel.recipeswithKey[recipe].recipe.recipe.image, "drawable", LocalContext.current.packageName)),
                            contentDescription = null,
                            modifier = Modifier.padding(0.dp)
                        )

                    }

                }
                Text(
                    text = viewmodel.recipeswithKey[recipe].recipe.recipe.recipeName,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
            }
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



