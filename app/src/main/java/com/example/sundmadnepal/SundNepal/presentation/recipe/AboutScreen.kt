package com.example.sundmadnepal.SundNepal.presentation.recipe


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sundmadnepal.AboutScreen
import com.example.sundmadnepal.HomeScreen
import com.example.sundmadnepal.R
import com.example.sundmadnepal.SundNepal.data.Cake
import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.data.Recipe2
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarRecipe
import com.example.sundmadnepal.SundNepal.presentation.util.Screen
import com.example.sundmadnepal.ui.theme.CollapsedHeight
import com.example.sundmadnepal.ui.theme.ExpendedHeight
import com.example.sundmadnepal.ui.theme.Shapes
import com.example.sundmadnepal.ui.theme.SundMadNepalTheme

@Composable
fun AboutScreen(recipe: Recipe2, navController: NavController){
    MainFragment(recipe = recipe, navController = navController)
}

@Composable
fun MainFragment(recipe: Recipe2, navController: NavController) {
    BottomNavigationBarRecipe(navController = navController)
    Box(modifier = Modifier.padding(PaddingValues(0.dp, 0.dp, 0.dp, 56.dp))) {
        Content(recipe)
        MainPicture()

    }
}

@Composable
fun MainPicture() {
    val pictureheight = ExpendedHeight - CollapsedHeight
    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = White,
        modifier = Modifier.height(
            ExpendedHeight
        )
    ) {
        Column() {
            Box(Modifier.height(pictureheight)) {
                Image(
                    painter = painterResource(
                        id = LocalContext.current.resources.getIdentifier(
                            Cake.image,
                            "drawable",
                            LocalContext.current.packageName
                        )
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    Pair(
                                        0.7f,
                                        Transparent
                                    ),
                                    Pair(1f, White)
                                )
                            )
                        )
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(CollapsedHeight),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    Cake.name,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 17.dp)
                )
            }
        }
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(CollapsedHeight)
            .fillMaxWidth()
            .padding(horizontal = 17.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("hi")
        Text("hi")
        Text("hi")
    }
}

@Composable
fun Content(recipe: Recipe2) {
    LazyColumn(contentPadding = PaddingValues(top = ExpendedHeight)) {
        item {
            KeyInfo(recipe)
            Information(recipe)

            KeyIngredients(recipe)
            //
        }
    }
}

@Composable
fun KeyIngredients(recipe: Recipe2) {
    Grid(items =recipe.keyIngrediens , nColoumn = 3){
        KeyIngredientCard(ikon = it.image, undertitle = it.undertitle, title = it.title, modifier = Modifier)
    }
}


@Composable
fun KeyIngredientCard(
    @DrawableRes ikon: Int,
    undertitle: String,
    title: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier.padding(bottom = 17.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(modifier = Modifier
            .padding(bottom = 7.dp)
            .width(100.dp)
            .height(100.dp),
        backgroundColor = com.example.sundmadnepal.ui.theme.LightGray,
        shape = Shapes.large,
        elevation = 0.dp
        ){
            Image(
                painterResource(id = ikon),
                contentDescription = null,
            modifier = Modifier.padding(17.dp)
            )
        }
        Text(title, fontWeight = Medium, fontSize = 15.sp, modifier = Modifier.width(100.dp))
        Text(undertitle, modifier = Modifier.width(100.dp), fontSize = 15.sp, color = com.example.sundmadnepal.ui.theme.DarkGray)
    }
}

@Composable
fun <T> Grid(items: List<T>, nColoumn: Int, content: @Composable (T) -> Unit) {
    Column(Modifier.padding(16.dp)) {
        for (n in items.indices step nColoumn) {
            Row {
                for (m in 0 until nColoumn) {
                    if (n + m < items.size) {
                        Box(
                            modifier = Modifier.weight(1f), contentAlignment = Alignment.TopCenter
                        ) {
                            content(items[n + m])
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
        
    }
}

@Composable
fun Information(recipe: Recipe2) {
    Text(recipe.information,
        modifier = Modifier.padding(horizontal = 17.dp, vertical = 17.dp),
        fontWeight = Medium)
}

@Composable
fun KeyInfo(recipe: Recipe2) {
    Row(
        modifier = Modifier
            .padding(top = 17.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconColoumn(Icons.Default.Schedule, recipe.prepTime)
        IconColoumn(Icons.Default.Bolt, recipe.energy)
        IconColoumn(ikon = Icons.Default.FavoriteBorder, text = recipe.healthy)
    }
}

@Composable
fun IconColoumn(ikon : ImageVector, text: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Icon(imageVector = ikon, contentDescription = null,
        modifier = Modifier.height(25.dp),
        tint = Red)
        Text(text, fontWeight = Bold)
    }
}


@Preview(showBackground = true, widthDp = 300, heightDp = 1400)
@Composable
fun DefaultPreview() {
    SundMadNepalTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.AboutScreen.route
        ) {
            composable(route = Screen.AboutScreen.route) {
                AboutScreen(Cake, navController = navController )
            }
            //MainFragment(Cake, navController = )
        }
    }
}