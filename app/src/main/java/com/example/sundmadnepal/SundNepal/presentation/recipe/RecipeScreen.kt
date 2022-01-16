package com.example.sundmadnepal

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import org.checkerframework.checker.units.qual.h

@Composable
fun RecipeScreen(
    navController: NavController,
    viewModel: RecipesViewModel
) {
    val viewmodel = viewModel.state.value
    RecipeScreenContent(viewmodel, navController, viewModel)

}

@Composable
private fun RecipeScreenContent(
    viewmodel: RecipeState,
    navController: NavController,
    viewModel: RecipesViewModel
) {
    Scaffold (
        topBar = { TopCBar(viewmodel.recipeswithKey.size) } )
    {
        Surface {
            LazyColumn(modifier = Modifier.background(MaterialTheme.colors.primaryVariant)) {
                items(viewmodel.recipeswithKey.size) { recipeNumber ->
                    MainCard(
                        viewmodel.recipeswithKey[recipeNumber].recipe.recipe.image,
                        viewmodel.recipeswithKey[recipeNumber].recipe.recipe.recipeName
                    ){
                        viewModel.getSpecificRecipe(recipeNumber)
                        viewModel.InitializeFavorite(viewmodel.recipeswithKey[recipeNumber].recipe.recipe.favorite)
                        navController.navigate(Screen.AboutScreen.route)
                    }
                }
            }
        }
    }
}

@Composable
private fun MainCard(
    image: String,
    title: String,
    onClick: () -> Unit){
    Card(

        backgroundColor = MaterialTheme.colors.onSurface,
        elevation = 7.dp,
        shape = RoundedCornerShape(21.dp),
        modifier = Modifier
            .padding(15.dp)
            .height(150.dp)
            .fillMaxWidth()
            .clickable { onClick.invoke() },
        border = BorderStroke(3.dp, Color.Gray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 19.dp, end = 19.dp, top = 11.dp, bottom = 11.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painterResource(id = LocalContext.current.resources.getIdentifier(image, "drawable", LocalContext.current.packageName)),
                contentDescription = null,
                modifier = Modifier.size(130.dp)
            )
            Spacer(modifier = Modifier.width(19.dp))
            Text(text = title, modifier = Modifier.fillMaxWidth().padding(end = 11.dp), fontSize = 19.sp, color = MaterialTheme.colors.onBackground)
        }
    }
}

@Composable
private fun TopCBar(recipes: Int) {
    TopAppBar(
        backgroundColor = Color.DarkGray,
        contentPadding = PaddingValues(start = 19.dp),
    ) {
        Text(
            text = "Showing $recipes recipes",
            fontSize = 23.sp,
            color = Color.White
        )
    }
}


/*
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

*/

