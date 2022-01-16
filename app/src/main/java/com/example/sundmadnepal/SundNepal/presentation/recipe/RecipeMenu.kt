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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.Home.DefaultButton
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import com.example.sundmadnepal.SundNepal.presentation.util.ImageCover
import com.example.sundmadnepal.SundNepal.presentation.util.Screen
import com.example.sundmadnepal.ui.theme.green

@Composable
fun RecipeMenu(navController: NavController, viewModel: RecipesViewModel) {
        BottomNavigationBarHome(navController = navController)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primaryVariant),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Healthy Food Nepal", color = MaterialTheme.colors.primary, fontSize = 45.sp)
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.primaryVariant)
                    .fillMaxWidth()
                    .height(627.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                DefaultButton(
                    text = "See Recipes",
                    icon = Icons.Default.Book
                ) {
                    navController.navigate(Screen.RecipeScreen.route) {

                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                DefaultButton(
                    text = "Add Recipe",
                    icon = Icons.Default.Add
                ) {
                    //AddRecipeScreen
                }
                Spacer(modifier = Modifier.height(20.dp))
                DefaultButton(
                    text = "My Recipes",
                    icon = Icons.Default.BookmarkAdded
                ) {

                }
                Spacer(modifier = Modifier.height(20.dp))
                DefaultButton(
                    text = "Favorite Recipes",
                    icon = Icons.Default.Favorite
                ) {
                    viewModel.getFavorite()
                    navController.navigate(Screen.FavoriteScreen.route)
                }
            }
        }
}


