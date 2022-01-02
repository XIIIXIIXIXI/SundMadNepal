package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.WheelchairPickup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.Home.DefaultButton
import com.example.sundmadnepal.SundNepal.presentation.util.Screen

@Composable
fun RecipeMenu(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center   ) {
        Text(text = "Cook Nepal")
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
            navController.navigate(Screen.RecipeScreen.route)
        }
        Spacer(modifier = Modifier.height(20.dp))
        DefaultButton(
            text = "See Recipes",
            icon = Icons.Default.WheelchairPickup
        ){
            //AddRecipeScreen
        }
    }
}