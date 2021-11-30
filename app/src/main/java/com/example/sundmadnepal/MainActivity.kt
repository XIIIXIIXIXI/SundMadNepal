package com.example.sundmadnepal

import HealthInfoScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sundmadnepal.ui.theme.SundMadNepalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SundMadNepalTheme {
                val navController = rememberNavController()
                val view = hiltViewModel<HViewModel>()
                NavHost(navController, "HomeScreen"){
                    composable("HomeScreen"){
                        HomeScreen(navController = navController)
                    }
                    composable("RecipeScreen"){
                        RecipeScreen(navController, view)
                    }
                    composable("HealthInfoScreen"){
                        HealthInfoScreen(navController)
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
                    composable("HealthInfoScreen"){
                        HealthInfoScreen(navController)
                    }
                    composable("ProfileScreen"){
                        ProfileScreen(navController)
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