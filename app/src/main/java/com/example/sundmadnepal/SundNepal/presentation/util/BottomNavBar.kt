package com.example.sundmadnepal.SundNepal.presentation.util

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    //makes backstackEntry as a state so we can recompose when we call the item.
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.onBackground,
        elevation = 5.dp,
    ) {
        items.forEach {
            val selected = it.route == backStackEntry.value?.destination?.route
            //checks if the destination route is the same as "this" route item
            BottomNavigationItem(selected = selected, onClick = { onItemClick(it) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = it.name
                        )

                        Text(
                            text = it.name,
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun BottomNavigationBarRecipe(navController: NavController) {
    //val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "About",
                        route = "about_screen",
                        icon = Icons.Default.Info
                    ),
                    BottomNavItem(
                        name = "Ingredients",
                        route = "ingredient_screen",
                        icon = Icons.Default.ShoppingCart
                    ),
                    BottomNavItem(
                        name = "Steps",
                        route = "steps_screen",
                        icon = Icons.Default.Menu
                    )
                ), navController,
                onItemClick = {
                    navController.navigate(it.route){
                        popUpTo(Screen.RecipeScreen.route){
                            inclusive = false
                        }
                    }
                }
            )
        }
    ) {
    }
}

@Composable
fun BottomNavigationBarHome(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = "recipeMenu_screen",
                        icon = Icons.Default.Home
                    ),
                    BottomNavItem(
                        name = "HealthInfo",
                        route = "HealthInfo_screen",
                        icon = Icons.Default.Favorite
                    ),
                    BottomNavItem(
                        name = "Profile",
                        route = "profile_screen",
                        icon = Icons.Default.Person
                    )
                ), navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
    }
}



