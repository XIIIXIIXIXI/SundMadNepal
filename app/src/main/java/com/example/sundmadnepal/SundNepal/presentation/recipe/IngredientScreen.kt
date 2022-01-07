package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sundmadnepal.SundNepal.data.Cake
import com.example.sundmadnepal.ui.theme.SlightlyLessLightGray


@Composable
fun IngredientScreen(viewModel: RecipesViewModel = hiltViewModel()){
    IMainFragment(viewModel)
}

@Composable
fun IMainFragment(viewModel: RecipesViewModel){
    Box(){
        IContent(viewModel)
        ScaleBar(viewModel)
    }
}
@Composable
fun IContent(viewModel: RecipesViewModel) {
    LazyColumn(contentPadding = PaddingValues(top = 100.dp)){
        items(Cake.keyIngrediens.size){
            val undertitle = Cake.keyIngrediens[it].undertitle * viewModel.state.value.multiplier
            Row(horizontalArrangement = Arrangement.Start,
                modifier = if (it % 2 == 0 && it != Cake.keyIngrediens.size){
                    Modifier
                        .fillMaxWidth()
                        .background(SlightlyLessLightGray)
                        .padding(vertical = 10.dp)
                }else{
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                }) {
                Text(
                    undertitle.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 15.dp)
                )
                Text(
                    Cake.keyIngrediens[it].title,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }
    }
}

@Composable
fun ScaleBar(viewmodel: RecipesViewModel) {
    Row(
        modifier = Modifier
            .padding(top = 17.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        IconButton(onClick = { viewmodel.ServingsMultiplier(-1) },
        ) {
            Icon(
                imageVector = Icons.Default.RemoveCircle, contentDescription = null,
                modifier = Modifier.height(25.dp),
                tint = Color.Black
            )
        }
        Text(text = "Servings: ${viewmodel.state.value.multiplier}",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 5.dp)
        )

        IconButton(onClick = { viewmodel.ServingsMultiplier(1) }) {
            Icon(
                imageVector = Icons.Default.AddCircle, contentDescription = null,
                modifier = Modifier.height(25.dp),
                tint = Color.Black,
            )
        }
    }
}


