package com.example.sundmadnepal
/*
import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.domain.model.Recipes
import com.example.sundmadnepal.SundNepal.domain.model.allRecipes


@Composable
fun RecipesThemeCard(
    recipes: Recipes,
    thisRecipeNumber: Int,
    navController: NavController){
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier
        .background(color = MaterialTheme.colors.primaryVariant)
        .fillMaxSize()) {
        Card(
            shape = MaterialTheme.shapes.medium,
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .width(425.dp)
                .fillMaxHeight(0.45f)
                .clickable { navController.navigate("AboutScreen") }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${thisRecipeNumber}/${allRecipes.size}",
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .padding(horizontal = 16.dp),
                )
                Image(
                    painterResource(id = recipes.imageRes),
                    contentDescription = "${recipes.title}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )

            }
        }
        Text(
            text = recipes.title,
            style = MaterialTheme.typography.h2,
            fontSize = 35.sp,
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = "key Ingrediens:",
            fontSize = 20.sp,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),

        ){
            recipes.keyIngrediens.forEach{
                Image(
                    painterResource(id = it),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                )
            }
        }
    }
}*/