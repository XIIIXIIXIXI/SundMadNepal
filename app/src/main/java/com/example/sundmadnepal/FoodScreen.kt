package com.example.sundmadnepal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


/*@Composable
fun FoodScreen(navController: NavController) {
    AboutScreen(navController)
}*/

@Composable
fun AboutScreen(navController: NavController) {
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = "About", color = Color.Black, fontSize = 500.sp)
        }
        BottomNavigationBar(navController = navController)
        Text(text = "About")
    }
   /* Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            BottomNavigationBar(navController = navController)
            Text(text = "About", color = Color.Black)
        }
    }*/
}


@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    //makes backstackEntry as a state so we can recompose when we call the item.
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 5.dp
    ) {
        items.forEach {
            val selected = it.route == backStackEntry.value?.destination?.route
            //checks if the destination route is the same as "this" route item
            BottomNavigationItem(selected = selected, onClick = { onItemClick(it) },
                selectedContentColor = Color.Gray,
                unselectedContentColor = MaterialTheme.colors.primaryVariant,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = it.name
                        )

                        Text(
                            text = it.name,
                            textAlign = TextAlign.Center,
                            fontSize = 15.sp
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "About",
                        route = "AboutScreen",
                        icon = Icons.Default.Info
                    ),
                    BottomNavItem(
                        name = "Ingredients",
                        route = "IngrediensScreen",
                        icon = Icons.Default.ShoppingCart
                    ),
                    BottomNavItem(
                        name = "Steps",
                        route = "StepsScreen",
                        icon = Icons.Default.Menu
                    )
                ), navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {

    }
}