package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sundmadnepal.R
import com.example.sundmadnepal.SundNepal.data.Cake
import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.presentation.recipe.RecipeState
import com.example.sundmadnepal.SundNepal.presentation.recipe.RecipesViewModel
import com.example.sundmadnepal.SundNepal.presentation.util.Screen
import com.example.sundmadnepal.ui.theme.CollapsedHeight
import com.example.sundmadnepal.ui.theme.LightGray
import com.example.sundmadnepal.ui.theme.Shapes
import com.example.sundmadnepal.ui.theme.SlightlyLessLightGray
import org.checkerframework.checker.units.qual.h

@Composable
fun FavoriteScreen(
    navController: NavController,
    viewModel: RecipesViewModel
) {
    val viewmodel = viewModel.state.value

        if (viewmodel.favorites.isEmpty()){
            Column(modifier = Modifier
                .background(MaterialTheme.colors.primaryVariant)
                .fillMaxSize(), horizontalAlignment = Alignment.Start) {
                Text(
                    "Nothing added to your favorite yet",
                    fontSize = 27.sp,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 17.dp)
                )
                Text(
                    "When you add a favorite recipe it will be shown here",
                    fontSize = 27.sp,
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 17.dp)
                )}
        }else{
            FavoriteScreenContent(viewmodel, navController, viewModel)
        }



}

@Composable
private fun FavoriteScreenContent(
    viewmodel: RecipeState,
    navController: NavController,
    viewModel: RecipesViewModel
) {
    Scaffold (
        topBar = { TopCBar(viewmodel.favorites.size) } )
    {
        Surface(modifier = Modifier
            .background(MaterialTheme.colors.primaryVariant)
            .fillMaxSize()) {
                Text(
                    "Favorites",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 17.dp)
                )
            LazyColumn(modifier = Modifier.background(MaterialTheme.colors.primaryVariant)) {
                items(viewmodel.favorites.size) { recipeNumber ->
                    MainCard(
                        viewmodel.favorites[recipeNumber].recipe.image,
                        viewmodel.favorites[recipeNumber].recipe.recipeName
                    ){
                        viewModel.getSpecificRecipe(viewmodel.favorites[recipeNumber].number)
                        viewModel.InitializeFavorite(viewmodel.favorites[recipeNumber].recipe.favorite)
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

        backgroundColor = SlightlyLessLightGray,
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
            Box(){
                Image(
                    painterResource(id = LocalContext.current.resources.getIdentifier(image, "drawable", LocalContext.current.packageName)),
                    contentDescription = null,
                    modifier = Modifier.size(130.dp)
                )
                Icon(imageVector = Icons.Default.Favorite, contentDescription = null, tint = Color.Red, modifier = Modifier.size(35.dp))

            }
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
            text = "${stringResource(id = R.string.recipe_showing)} $recipes ${stringResource(id = R.string.recipe_recipes)}",
            fontSize = 23.sp,
            color = Color.White
        )
    }
}