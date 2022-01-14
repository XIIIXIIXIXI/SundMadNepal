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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sundmadnepal.SundNepal.data.Cake
import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.data.RecipeWithKeyIngredientsAndSteps
import com.example.sundmadnepal.SundNepal.presentation.Home.DefaultButton
import com.example.sundmadnepal.SundNepal.presentation.recipe.Content
import com.example.sundmadnepal.SundNepal.presentation.recipe.MainPicture
import com.example.sundmadnepal.SundNepal.presentation.recipe.RecipesViewModel
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarRecipe
import com.example.sundmadnepal.SundNepal.presentation.util.Screen
import com.example.sundmadnepal.ui.theme.CollapsedHeight
import com.example.sundmadnepal.ui.theme.ExpendedHeight
import com.example.sundmadnepal.ui.theme.SundMadNepalTheme
import com.google.common.reflect.Reflection.getPackageName

/*
@Composable
fun HomeScreen(navController: NavController, viewModel: RecipesViewModel){
    val recipe = viewModel.state.value.recipeswithKey
    BottomNavigationBarHome(navController = navController)

    Box(modifier = Modifier.padding(PaddingValues(0.dp, 0.dp, 0.dp, 56.dp))) {
        TopBar(recipe)
    }
}


@Composable
private fun TopBar(recipe: List<RecipeWithKeyIngredientsAndSteps>){
    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = Color.White,
        modifier = Modifier.height(
            40.dp
        )
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Box(Modifier.height(40.dp),
            ) {
                Text(
                "My recipes",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 17.dp)
                )
            }
        }
    }
}







*/





/*
@Composable
fun HomeScreen(navController: NavController, viewModel: RecipesViewModel){
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
                text = "Home Screen",
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


*/