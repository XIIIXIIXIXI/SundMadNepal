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
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import org.intellij.lang.annotations.JdkConstants
import java.util.*


@Composable
fun HealthInfoScreen(navController: NavController){
        //HealthScreenContent()
        BottomNavigationBarHome(navController = navController)

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


