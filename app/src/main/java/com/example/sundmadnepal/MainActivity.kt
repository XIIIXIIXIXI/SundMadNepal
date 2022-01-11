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
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sundmadnepal.SundNepal.presentation.recipe.*
import com.example.sundmadnepal.SundNepal.presentation.util.Screen
import com.example.sundmadnepal.ui.theme.SundMadNepalTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SundMadNepalTheme {



                    val navController = rememberNavController()
                val viewModel: RecipesViewModel = hiltViewModel()
                            NavHost(navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ){

                            composable(route = Screen.HomeScreen.route) {
                                HomeScreen(navController, viewModel)
                            }

                            composable(route = Screen.RecipeScreen.route) {
                                RecipeScreen(navController = navController, viewModel)
                            }
                            composable(route = Screen.RecipeMenu.route) {
                                RecipeMenu(navController = navController)
                            }
                            composable(route = Screen.AboutScreen.route){
                                AboutScreen(navController = navController, viewModel)
                            }
                                composable(route = Screen.IngredientScreen.route){
                                    IngredientScreen(viewModel, navController)
                                }
                                composable(route = Screen.StepsScreen.route){
                                    StepsScreen(viewModel, navController)
                                }

                            composable(route = Screen.ProfileScreen.route) {
                                ProfileScreen(navController = navController)
                            }

                            // Health Screens
                            composable(route = Screen.HealthInfoScreen.route) {
                                HealthInfoScreen(navController = navController)
                            }
                            composable(route = Screen.HealthAdult.route) {
                                HealthAdult(/*navController = navController*/)
                            }

                            composable(route = Screen.HealthBaby.route) {
                                HealthBaby(/*navController = navController*/)
                            }

                            composable(route = Screen.HealthChildren.route) {
                                HealthChildren(/*navController = navController*/)
                            }
                            composable(route = Screen.HealthPregnant.route) {
                                HealthPregnant(/*navController = navController*/)
                            }

                    }
                }
            }
        }
    }


/*
val navController = rememberNavController()

                NavHost(navController, "HomeScreen"){
                    composable("HomeScreen"){
                        HomeScreen(navController = navController)
                    }
                    composable("RecipeScreen"){backStackEntry ->
                        val view = hiltViewModel<HViewModel>()
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
 */