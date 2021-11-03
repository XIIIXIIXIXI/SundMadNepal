package com.example.sundmadnepal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sundmadnepal.ui.theme.SundMadNepalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SundMadNepalTheme {
                val navController = rememberNavController()

                NavHost(navController, "HomeScreen"){
                    composable("HomeScreen"){
                        HomeScreen(navController = navController)
                    }
                    composable("RecipeScreen"){
                        RecipeScreen(navController)
                    }
                    /*composable("FoodScreen"){
                        FoodScreen(navController)
                    }*/
                    composable("AboutScreen"){
                        AboutScreen(navController)
                    }
                    composable("IngrediensScreen"){
                        IngrediensScreen(navController)
                    }
                    composable("StepsScreen"){
                        StepsScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SundMadNepalTheme {
        Greeting("Android")
    }
}