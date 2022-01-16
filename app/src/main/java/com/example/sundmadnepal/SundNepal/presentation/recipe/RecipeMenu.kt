package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.R
import com.example.sundmadnepal.SundNepal.presentation.Home.DefaultButton
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import com.example.sundmadnepal.SundNepal.presentation.util.ImageCover
import com.example.sundmadnepal.SundNepal.presentation.util.Screen
import com.example.sundmadnepal.ui.theme.Purple200
import com.example.sundmadnepal.ui.theme.green

@Composable
fun RecipeMenu(navController: NavController, viewModel: RecipesViewModel) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primaryVariant),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text =  stringResource(id = R.string.recipe_menu_title), color = MaterialTheme.colors.primary, fontSize = 45.sp)
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.primaryVariant)
                    .fillMaxWidth()
                    .height(543.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                DefaultButton(
                    text =  stringResource(id = R.string.recipe_menu_see_recipes),
                    icon = Icons.Default.Book
                ) {
                    navController.navigate(Screen.RecipeScreen.route) {

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                DefaultButton(
                    text = stringResource(id = R.string.recipe_menu_add_recipe),
                    icon = Icons.Default.Add
                ) {
                    //AddRecipeScreen
                }
                Spacer(modifier = Modifier.height(20.dp))
                DefaultButton(
                    text =  stringResource(id = R.string.recipe_menu_my_recipes),
                    icon = Icons.Default.BookmarkAdded
                ) {

                }
                Spacer(modifier = Modifier.height(20.dp))
                DefaultButton(
                    text = stringResource(id = R.string.recipe_menu_favorite_recipes),
                    icon = Icons.Default.Favorite
                ) {
                    viewModel.getFavorite()
                    navController.navigate(Screen.FavoriteScreen.route)
                }
            }
            BottomNavigationBarHome(navController = navController)
        }
}


