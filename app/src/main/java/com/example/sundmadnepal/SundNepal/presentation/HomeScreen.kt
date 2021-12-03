package com.example.sundmadnepal


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
        HomeScreenScaffold(navController)
    HomeScreenContent()
}

@Composable
private fun HomeScreenScaffold(
    navController: NavController
) {

    Scaffold(
        bottomBar = {
            NepalToolBar(navController)
        }
    ) {

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
            selected = true,
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
            selected = false
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

@Composable
private fun HomeScreenContent(){
    Surface(
        color = Color.Black,
        //modifier = Modifier.fillMaxSize()
    ){

    }
    Column {
        Box(modifier = Modifier
            .border(10.dp, Color.Black)){
            Image(
                painterResource(R.drawable.lasagna),
                contentDescription = "Lasagna",
                //contentScale = ContentScale.Crop,
                modifier = Modifier
                //.fillMaxWidth()
                //.fillMaxHeight()
            )

        }
        Text(text = "Recipe of the week: Lasagna", fontSize = 30.sp)
        Text(text = "About:\n Lasagna originates from the city of Naples, Italy. \n The very first mention of lasagna is from the 14th-century.\n This recipe combines the lovely ingrediens of: garlic and tomato, to make the perfect lasagna")
    }
}

