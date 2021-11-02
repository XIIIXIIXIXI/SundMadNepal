package com.example.sundmadnepal

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ){
        HomeScreenScaffold()
    }
}

@Composable
private fun HomeScreenScaffold() {
    Scaffold(
        bottomBar = {
            NepalToolBar()
        }
    ) { paddingValues ->
        //HomeScreenContent(paddingValues)
    }
}

@Composable
private fun NepalToolBar(){
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
    ){
        NepalToolButton(
            labelText = "Home",
            selected = true,
            icon = Icons.Default.Home
        )
        NepalToolButton(
            labelText = "Recipes",
            selected = false,
            icon = Icons.Default.Build
        )
        NepalToolButton(
            labelText = "HealthInfo",
            icon = Icons.Default.Favorite,
            selected = false
        )
        NepalToolButton(
            labelText = "Profile",
            selected = false,
            icon = Icons.Default.Person

        )
    }
}
@Composable
private fun RowScope.NepalToolButton(
    selected: Boolean,
    icon: ImageVector,
    labelText: String,
){
    BottomNavigationItem(
        selected = selected,
        onClick = { /*TODO*/ },
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


