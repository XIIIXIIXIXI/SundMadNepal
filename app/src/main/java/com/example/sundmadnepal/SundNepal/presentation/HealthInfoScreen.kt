import android.media.Image
import android.media.ImageReader
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import com.example.sundmadnepal.R
import org.intellij.lang.annotations.JdkConstants
import java.util.*


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
        HealthScreenContent()
    }
}


@Composable
private fun HealthScreenContent(){

    Column() {
        Text(text = "Health Information",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.width(400.dp)
        )
    Row(verticalAlignment = Alignment.CenterVertically) {
        imageImport(image = R.drawable.adult)
        imageImport(image = R.drawable.pregnant)
    }
        Row(){
            Text("Adult",modifier = Modifier
                .absolutePadding(80.dp,0.dp,80.dp))
            Text("While pregnant",modifier = Modifier
                .absolutePadding(60.dp))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            imageImport(image = R.drawable.baby)
            imageImport(image = R.drawable.children)
        }
        Row(){
            Text("Baby",modifier = Modifier
                .absolutePadding(75.dp,0.dp,75.dp))
            Text("Children",modifier = Modifier
                .absolutePadding(100.dp))
        }
    }

}

@Composable
private fun imageImport(image: Int){
    val padding = 12.dp
    val size = 180.dp
    Image(
        painterResource(image),
        contentDescription = "Single",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(padding)
            .size(size)
    )
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

/*
@Composable
private fun HealthScreenContent(navController: NavController){
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ){

    }
}*/

