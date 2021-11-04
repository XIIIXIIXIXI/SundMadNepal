import android.media.Image
import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import androidx.navigation.compose.composable
import com.example.sundmadnepal.AboutScreen
import com.example.sundmadnepal.HViewState
import com.example.sundmadnepal.R


@Composable
fun HealthInfoScreen(navController: NavController){

        HealthScreenScaffold(navController)
}

@Composable
private fun HealthScreenScaffold(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            NepalToolBar(navController)
        }
    ) {
        HealthScreenContent(navController)
    }
}
@Preview
@Composable
private fun HealthScreenContent(navController: NavController){
    val padding = 12.dp
    val size = 180.dp
    Column() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painterResource(R.drawable.adult),
            contentDescription = "dada",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(padding)
                .size(size)
        )
        Image(
            painterResource(R.drawable.pregnant),
            contentDescription = "dada",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(padding)
                .size(size)
        )
    }
        Row(){
            Text("Hey",modifier = Modifier
                .absolutePadding(90.dp,0.dp,75.dp));
            Text("Hey",modifier = Modifier
                .absolutePadding(100.dp));
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painterResource(R.drawable.baby),
            contentDescription = "dada",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(padding)
                .size(size)
        )
            Image(
                painterResource(R.drawable.children),
            contentDescription = "dada",
            contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(padding)
                    .size(size)
            )
        }
        Row(){
            Text("Hey",modifier = Modifier
                .absolutePadding(90.dp,0.dp,75.dp));
            Text("Hey",modifier = Modifier
                .absolutePadding(100.dp));
        }
    }

}
@Composable
private fun AdultScreenScaffold(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            NepalToolBar(navController)
        }
    ) {

    }
}

@Composable
private fun NepalToolBar(navController: NavController){
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
    ){
        NepalToolButton(
            navController,
            labelText = "Home",
            route = "HomeScreen",
            selected = false,
            icon = Icons.Default.Home
        )
        NepalToolButton(
            navController,
            labelText = "Recipes",
            route = "RecipeScreen",
            selected = false,
            icon = Icons.Default.Build
        )
        NepalToolButton(
            navController,
            labelText = "HealthInfo",
            route = "HealthInfoScreen",
            icon = Icons.Default.Favorite,
            selected = true
        )
        NepalToolButton(
            navController,
            labelText = "Profile",
            route = "ProfileScreen",
            selected = false,
            icon = Icons.Default.Person

        )
    }
}
@Composable
private fun RowScope.NepalToolButton(
    navController: NavController,
    selected: Boolean,
    route: String,
    icon: ImageVector,
    labelText: String,
){
    BottomNavigationItem(
        selected = selected,
        onClick = {
            navController.navigate(route)
                  },
        icon = {
            Icon(
                icon,
                contentDescription = null,
            )
        },
        label = {
            Text(labelText)
        }
    )
}

@Composable
private fun HealthScreenContent(){
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ){

    }
}

