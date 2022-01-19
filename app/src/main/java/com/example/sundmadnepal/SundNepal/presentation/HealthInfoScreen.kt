import android.media.Image
import android.media.ImageReader
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import org.intellij.lang.annotations.JdkConstants
import java.util.*


@Composable
fun HealthInfoScreen(navController: NavController){
    Column(modifier = Modifier
        //.size(412.dp,600.dp)
    ) {
        HealthScreenContent(navController)
        BottomNavigationBarHome(navController = navController)
    }
}

@Composable
private fun HealthScreenContent(navController: NavController){

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.93f)
        .background(MaterialTheme.colors.primaryVariant)) {
        Text(text = "Health Information",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.width(400.dp)
        )
    Row(verticalAlignment = Alignment.CenterVertically) {
        buttonImage(navController,"healthAdult_screen", "Adult",R.drawable.adult)
        buttonImage(navController,"healthPregnant_screen", "While Pregnant",R.drawable.pregnant)
    }
        Row(verticalAlignment = Alignment.CenterVertically) {
            buttonImage(navController,"healthBaby_screen", "Baby",R.drawable.baby)
            buttonImage(navController,"healthChildren_screen", "Children",R.drawable.children)
        }
    }

}
@Composable
private fun buttonImage(navController: NavController, route : String, text : String, image : Int) {
    val padding = 10.dp
    val size = 190.dp
    Button(onClick = { navController.navigate(route) }, modifier = Modifier
        .padding(padding)
        .size(size)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            imageImport(image = image)
            Text(text = text)
        }
    }
}
@Composable
private fun imageImport(image: Int){
    val padding = 2.dp
    val size = 150.dp
    Image(
        painterResource(image),
        contentDescription = "Single",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(padding)
            .size(size)
    )
}


