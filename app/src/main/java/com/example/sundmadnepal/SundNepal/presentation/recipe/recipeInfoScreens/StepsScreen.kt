package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.data.Cake
import com.example.sundmadnepal.SundNepal.data.RecipeWithKeyIngredients
import com.example.sundmadnepal.SundNepal.data.RecipeWithKeyIngredientsAndSteps
import com.example.sundmadnepal.SundNepal.data.Steps
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarRecipe
import com.example.sundmadnepal.ui.theme.LightGray
import com.example.sundmadnepal.ui.theme.Shapes
import com.example.sundmadnepal.ui.theme.SlightlyLessLightGray


@Composable
fun StepsScreen(viewModel: RecipesViewModel, navController: NavController) {
    val viewmodel = viewModel.state.value.recipeWithSteps
    SMainFragment(viewmodel, navController, viewModel)
}

@Composable
fun SMainFragment(viewmodel: RecipeWithKeyIngredientsAndSteps, navController: NavController, viewModel: RecipesViewModel) {
    BottomNavigationBarRecipe(navController = navController)
    Box(modifier = Modifier.padding(PaddingValues(0.dp, 0.dp, 0.dp, 38.dp))) {
        SContent(viewmodel, viewModel)
    }
}

@Composable
fun SContent(viewmodel: RecipeWithKeyIngredientsAndSteps, viewModel: RecipesViewModel) {
    LazyColumn(modifier = Modifier.padding(bottom = viewModel.state.value.recompose.dp)) {
        items(viewmodel.steps.size) { counter ->
        if (viewModel.state.value.completedStep[counter] == false) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,

                modifier = if (counter % 2 == 0 && counter != viewmodel.steps.size) {
                    Modifier
                        .fillMaxWidth()
                        .background(SlightlyLessLightGray)
                        .padding(vertical = 10.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = { viewModel.CompletedStep(counter)
                                viewModel.Recompose()}
                            )
                        }
                } else {
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = { viewModel.CompletedStep(counter)
                                    viewModel.Recompose()}
                            )
                        }
                }
            ) {
                stepToDo(viewmodel, counter)
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(Color.Black.copy(0.6f))
                        .padding(vertical = 10.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = { viewModel.CompletedStep(counter)
                                    viewModel.Recompose()}
                            )
                        }
            ) {
                stepToDo(viewmodel, counter)
            }
        }
        }
    }
}

@Composable
fun stepToDo(viewmodel: RecipeWithKeyIngredientsAndSteps, counter: Int){
    if (viewmodel.steps[counter].stepImage == "0") {
        Text(
            text = "${counter}.",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        Text(
            text = viewmodel.steps[counter].stepText,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )
    }
    if (viewmodel.steps[counter].stepImage != "0") {
        Column(
            modifier = Modifier
                .padding(top = 0.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${counter}.",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
        }
        Column(Modifier.width(222.dp)) {
            Text(
                text = viewmodel.steps[counter].stepText,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )
        }
        Column(
            modifier = Modifier
                .padding(bottom = 0.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .padding(PaddingValues(end = 15.dp))
                    .width(100.dp)
                    .height(100.dp),
                backgroundColor = LightGray,
                shape = Shapes.large,
                elevation = 0.dp
            ) {
                Image(
                    painter = painterResource(id = LocalContext.current.resources.getIdentifier(viewmodel.steps[counter].stepImage, "drawable", LocalContext.current.packageName)),
                    contentDescription = null,
                    modifier = Modifier.padding(15.dp)
                )
            }

        }

    }

}
