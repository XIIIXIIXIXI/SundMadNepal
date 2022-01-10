package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.WheelchairPickup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.Home.DefaultButton
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import com.example.sundmadnepal.SundNepal.presentation.util.Screen

@Composable
fun RecipeMenu(navController: NavController){
    BottomNavigationBarHome(navController = navController)
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Cook Nepal", color = MaterialTheme.colors.primary, fontSize = 50.sp)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center   ) {

        Spacer(modifier = Modifier.height(20.dp))
        DefaultButton(
            text = "Add Recipe",
            icon = Icons.Default.Add
        ){
            //AddRecipeScreen
        }
        Spacer(modifier = Modifier.height(20.dp))
        DefaultButton(
            text = "My Recipes",
            icon = Icons.Default.Book
        ){

        }
        Spacer(modifier = Modifier.height(20.dp))
        DefaultButton(
            text = "See Recipes",
            icon = Icons.Default.WheelchairPickup
        ){
            navController.navigate(Screen.RecipeScreen.route)
        }
    }
}
