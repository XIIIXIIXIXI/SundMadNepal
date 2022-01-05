package com.example.sundmadnepal


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.Home.DefaultButton
import com.example.sundmadnepal.SundNepal.presentation.recipe.RecipesViewModel
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import com.example.sundmadnepal.SundNepal.presentation.util.Screen
import com.google.common.reflect.Reflection.getPackageName

@Composable
fun HomeScreen(navController: NavController, viewModel: RecipesViewModel = hiltViewModel()){
    //BottomNavigationBarHome(navController = navController)
    //HomeScreenContent(navController)

    val result = viewModel.state.value
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (result.recipes.isNotEmpty()){
            for (recipe in result.recipes){
                Text(
                    text = recipe.image,
                    fontSize = 20.sp
                )

                Image(
                    painterResource(id = LocalContext.current.resources.getIdentifier("carrot", "drawable", LocalContext.current.packageName)),
                    contentDescription = "hh",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        //.fillMaxWidth()
                        //.fillMaxHeight()
                )
            }
        } else {
            Text(
                text = "Empty Database",
                fontSize = 60.sp
            )
        }/*

        Text(
            text = "${result.recipes[3].image}",
            fontSize = 60.sp
        )*/
        BottomNavigationBarHome(navController = navController)
    }


}




@Composable
private fun HomeScreenContent(navController: NavController){
    Column(
        Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .fillMaxSize(0.9f)) {
    }

    /*
        Column(modifier = Modifier.background(MaterialTheme.colors.onSecondary)) {
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
        }*/
    }


