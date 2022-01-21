package com.example.sundmadnepal.SundNepal.presentation.recipe

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.R
import com.example.sundmadnepal.SundNepal.data.RecipeWithKeyIngredients
import com.example.sundmadnepal.SundNepal.presentation.Home.DefaultButton
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarAddRecipe
import com.example.sundmadnepal.SundNepal.presentation.util.Screen
import com.example.sundmadnepal.ui.theme.White

import com.example.sundmadnepal.ui.theme.*

@Composable
fun AddRecipe(viewModel: RecipesViewModel, navController: NavController) {
BottomNavigationBarAddRecipe(navController = navController)
    Box(
        modifier = Modifier
            .padding(PaddingValues(viewModel.state.value.addRecipeRecompose.dp, 0.dp, 0.dp, 56.dp))
            .background(color = AddRecipeBackground)
            .fillMaxSize()
    ) {
        AddRecipeTopBar(navController)
        RecipeNameRecipeInformation(viewModel)

        LazyColumn(contentPadding = PaddingValues(top = 300.dp)) {
            item {
                ViewKeyIngredients(viewModel, navController)
                //
            }
        }
}
}

@Composable
fun ViewKeyIngredients( viewModel: RecipesViewModel, navController: NavController) {
    Grid(items = viewModel.state.value.chosenIngredient, nColoumn = 3) { images ->
        ViewKeyIngredientCard(
            ikon = images,
            "",
            modifier = Modifier
        )
    }
    FloatingActionButton(
        onClick = {
            viewModel.setImage()
            navController.navigate(Screen.ChooseKeyIngredient.route)
        },
        modifier = Modifier.padding(top = 0.dp, start = 20.dp),
        backgroundColor = Color.Blue,
        contentColor = Color.White
    ) {
        Icon(Icons.Filled.Add, "")
    }
}

@Composable
fun ViewKeyIngredientCard(
    ikon: String,
    //undertitle: String,
    title: String,
    modifier: Modifier,
    click: (String) -> Unit = { }
) {
    Column(
        modifier = modifier.padding(bottom = 17.dp, start = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 7.dp)
                .width(80.dp)
                .height(80.dp),
            backgroundColor = Color.White,
            shape = Shapes.large,
            elevation = 0.dp
        ) {
            Image(
                painter = painterResource(
                    id = LocalContext.current.resources.getIdentifier(
                        ikon,
                        "drawable",
                        LocalContext.current.packageName
                    )
                ),
                contentDescription = null,
                modifier = Modifier.padding(17.dp)
            )
        }
        Text(title, color = MaterialTheme.colors.onBackground, fontWeight = FontWeight.Medium, fontSize = 15.sp, modifier = Modifier.width(100.dp))
        //Text(undertitle, modifier = Modifier.width(100.dp), fontSize = 15.sp, color = com.example.sundmadnepal.ui.theme.DarkGray)
    }
}


@Composable
fun AddRecipeTopBar(navController: NavController) {
    TopAppBar(
        backgroundColor = TopBar,
        modifier = Modifier.height(56.dp),
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(onClick = { navController.navigate(Screen.RecipeMenu.route) }) {
                Text(text = "Cancel", fontWeight = FontWeight.Bold, fontSize = 25.sp)

            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Save", fontWeight = FontWeight.Bold, fontSize = 27.sp)

            }
        }
    }
}

@Composable
private fun RecipeNameRecipeInformation(viewModel: RecipesViewModel) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(PaddingValues(top = 56.dp))
    ) {
        Row(horizontalArrangement = Arrangement.Start) {
            Text(text = "Recipe Name", fontSize = 20.sp)
            if (viewModel.state.value.recipeNameAccepted) {
                Icon(
                    imageVector = Icons.Filled.Verified,
                    contentDescription = null,
                    tint = Color.Green,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.Error,
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
        }
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(bottom = 10.dp)),
            secondaryModifier = 40.dp,
            singleLine = true,
            maxLines = 1,
            viewModel = viewModel,
            hint = viewModel.state.value.addRecipe.recipeName
        ) {
            viewModel.setName(it)
            viewModel.AddRecipeRecompose()
        }
        Row(horizontalArrangement = Arrangement.Start) {
            Text(text = "Description", fontSize = 20.sp)
            if (viewModel.state.value.recipeInformationAccepted) {
                Icon(
                    imageVector = Icons.Filled.Verified,
                    contentDescription = null,
                    tint = Color.Green,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.Error,
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
        }
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(top = 0.dp)),
            secondaryModifier = 80.dp,
            singleLine = false,
            maxLines = 6,
            viewModel = viewModel,
            hint = viewModel.state.value.addRecipe.information
        ) {
            viewModel.setInformation(it)
            viewModel.AddRecipeRecompose()
        }
    }
}

//this function is inspired by a function from here https://github.com/philipplackner/JetpackComposePokedex/blob/Part9-PokemonDetailScreen3/app/src/main/java/com/plcoding/jetpackcomposepokedex/pokemonlist/PokemonListScreen.kt
// line 73

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    secondaryModifier: Dp,
    hint: String = "",
    singleLine: Boolean,
    maxLines: Int,
    viewModel: RecipesViewModel,
    onSearch: (String) -> Unit = { }
) {
    val focusManager = LocalFocusManager.current
    var text by remember {
        mutableStateOf("")
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                //focusManager.clearFocus()
            },
            singleLine = singleLine,
            maxLines = maxLines,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .height(secondaryModifier)
                .shadow(5.dp, CircleShape)
                .padding(horizontal = viewModel.state.value.addRecipeRecompose.dp)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.isFocused && text.isEmpty()
                },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Go
            ),
            keyboardActions = if (text.isNotEmpty()) {
                KeyboardActions(
                    onGo = {
                        onSearch(text)
                        focusManager.clearFocus()
                        text = ""
                    }
                )
            } else {
                KeyboardActions(
                    onGo = {
                        //onSearch(text)
                        focusManager.clearFocus()
                    }
                )
            }

        )
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}

/*
@Composable
fun addKeyInfo() {
    Row(
        modifier = Modifier
            .padding(top = 280.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        AddIconColoumn(Icons.Default.Schedule)

        AddIconColoumn(Icons.Default.Bolt)
        AddIconColoumn(ikon = Icons.Default.FavoriteBorder)
    }
}

@Composable
fun AddIconColoumn(ikon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = ikon, contentDescription = null,
            modifier = Modifier.height(25.dp),
            tint = Color.Red
        )
        SearchBar(secondaryModifier = 30.dp, singleLine = true, maxLines = 1, maxWidth = 0.2f,)
    }
}*/