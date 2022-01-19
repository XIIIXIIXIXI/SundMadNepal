package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.data.RecipeWithKeyIngredients
import com.example.sundmadnepal.SundNepal.presentation.util.Screen
import com.example.sundmadnepal.ui.theme.ExpendedHeight
import com.example.sundmadnepal.ui.theme.Shapes

@Composable
fun ChooseKeyIngredient(viewModel: RecipesViewModel, navController: NavController){
    Text("Choose an ingredient", fontSize = 30.sp)
Box(Modifier.padding(top = 40.dp)){
    LazyColumn(contentPadding = PaddingValues(top = 40.dp)) {
        item {
            AddKeyIngredients(viewModel, navController)
            //
        }
    }
}


}

@Composable
fun AddKeyIngredients( viewModel: RecipesViewModel, navController: NavController) {
    Grid(items = viewModel.state.value.keyImages, nColoumn = 3) { images ->
        KeyIngredientCardClick(
            ikon = images,
            "",
            modifier = Modifier
        ){
            viewModel.setChosenImage(it)
            navController.navigate(Screen.AddRecipe.route)
        }
    }
}

@Composable
fun KeyIngredientCardClick(
    ikon: String,
    //undertitle: String,
    title: String,
    modifier: Modifier,
    click: (String) -> Unit = { }
) {
    Column(
        modifier = modifier.padding(bottom = 17.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 7.dp)
                .width(100.dp)
                .height(100.dp),
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
                modifier = Modifier
                    .padding(17.dp)
                    .clickable { click(ikon) },
            )
        }
        Text(title, color = MaterialTheme.colors.onBackground, fontWeight = FontWeight.Medium, fontSize = 15.sp, modifier = Modifier.width(100.dp))
        //Text(undertitle, modifier = Modifier.width(100.dp), fontSize = 15.sp, color = com.example.sundmadnepal.ui.theme.DarkGray)
    }
}