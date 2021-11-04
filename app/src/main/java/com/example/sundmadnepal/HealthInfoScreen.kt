package com.example.sundmadnepal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.NavController

@Composable
fun HealthInfoScreen(navController: NavController){
    Scaffold(
        bottomBar = {
            NepalToolBar(navController)
        }
    ){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            BottomNavigationBar(navController = navController)
            Text(text = "HealthInfo")
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
            selected = false,
            icon = Icons.Default.Build
        )
        NepalToolButton(
            navController,
            labelText = "HealthInfo",
            route = "HealthInfoScreen",
            icon = Icons.Default.Favorite,
            selected = true
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