package com.example.sundmadnepal

//import android.graphics.Color
import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource


import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.Home.DefaultButton
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import org.intellij.lang.annotations.JdkConstants

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Column()
    {
            GardenTips(navController = navController)
    }
}


@Composable
private fun GardenTips(navController : NavController){
    var infoOpened by remember{ mutableStateOf(0)}
    val color2 = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    val color1 = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
    LazyColumn (modifier = Modifier
        .background(MaterialTheme.colors.primaryVariant)
        .fillMaxWidth()
        .fillMaxHeight(0.92f)
        .padding(10.dp,0.dp)
    ){
        item {
            Button(onClick = { infoOpened = if(infoOpened != 1) 1 else 0 }
                , colors = if(infoOpened == 1) color1 else color2,
                modifier = Modifier
                    .size(410.dp, 53.dp)
                    .padding(5.dp)) {
                Text(text = stringResource(id = R.string.profile_how_to_garden), color = Black,fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            GardenInfo(infoOpened)
        }

        item {
            Button(onClick = {infoOpened = if(infoOpened != 2) 2 else 0 },
                colors = if(infoOpened == 2) color1 else color2,
                modifier = Modifier
                    .size(410.dp, 53.dp)
                    .padding(5.dp)
            ) {
                Text(text = stringResource(id = R.string.profile_how_to_compost), color = Black,fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            CompostInfo(infoOpened)
        }
        item {
            Button(onClick = {infoOpened = if(infoOpened != 3) 3 else 0 },
                colors = if(infoOpened == 3) color1 else color2,
                modifier = Modifier
                    .size(410.dp, 53.dp)
                    .padding(5.dp)
            ) {
                Text(text = stringResource(id = R.string.profile_how_to_make_insecticides), color = Black,fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            InsecticidesInfo(infoOpened)
        }
        item {
            Button(onClick = {infoOpened = if(infoOpened != 4) 4 else 0 },
                colors = if(infoOpened == 4) color1 else color2,
                modifier = Modifier
                    .size(410.dp, 53.dp)
                    .padding(5.dp)
            ) {
                Text(text = stringResource(id = R.string.profile_suggested_vegetables), color = Black, fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            ThingToGrowInfo(infoOpened)
        }
    }
    BottomNavigationBarHome(navController = navController)
}

/*
@Composable
private fun PopUpButton(infoOpened: Int, text: String){
    Button(onClick = { infoOpeneds = if(infoOpeneds != 1) 1 else 0 }
        , colors = ButtonDefaults.buttonColors(backgroundColor = Color(193, 93, 223)),
        modifier = Modifier
            .size(410.dp, 50.dp)
            .padding(5.dp)) {
        Text(text = text, fontSize = 20.sp, textAlign = TextAlign.Center)
    }
}*/

@Composable
private fun GardenInfo(infoOpened : Int) {
    if(infoOpened == 1) {
            //Text(text = "How to make your own garden", fontSize = 25.sp)
                Text(text = stringResource(id = R.string.profile_how_to_garden_info)
                , color = MaterialTheme.colors.onBackground)
        Text(text = stringResource(id = R.string.profile_how_to_garden_prep), color = MaterialTheme.colors.onBackground)
        Image(
            painterResource(R.drawable.garden1),
            contentDescription = "Unprepared garden",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = stringResource(id = R.string.profile_how_to_garden1), color = MaterialTheme.colors.onBackground)
        Image(
            painterResource(R.drawable.gardencompost),
            contentDescription = "Compost garden",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = stringResource(id = R.string.profile_how_to_garden2), color = MaterialTheme.colors.onBackground)
        Image(
            painterResource(R.drawable.gardenwater),
            contentDescription = "Watering the garden",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = stringResource(id = R.string.profile_how_to_garden3), color = MaterialTheme.colors.onBackground)
        Text(text = stringResource(id = R.string.profile_how_to_garden4), color = MaterialTheme.colors.onBackground)
        Image(
            painterResource(R.drawable.gardenhighland1),
            contentDescription = "High land garden",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = stringResource(id = R.string.profile_how_to_garden5), color = MaterialTheme.colors.onBackground)
        Image(
            painterResource(R.drawable.gardenhighland2),
            contentDescription = "High land garden 2",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )

    }
}
@Composable
private fun CompostInfo(infoOpened : Int) {
    if(infoOpened == 2) {
        //Text(text = "How to make the Compost:", fontSize = 25.sp)
        Text(text = stringResource(id = R.string.profile_how_to_compost_size), color = MaterialTheme.colors.onBackground)
        Image(
            painterResource(R.drawable.composta),
            contentDescription = "Scaling land for compost",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = stringResource(id = R.string.profile_how_to_compost1), color = MaterialTheme.colors.onBackground)
        Image(
            painterResource(R.drawable.compostb),
            contentDescription = "Layering the compost",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = stringResource(id = R.string.profile_how_to_compost2), color = MaterialTheme.colors.onBackground)
        Image(
            painterResource(R.drawable.compostc),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = stringResource(id = R.string.profile_how_to_compost3), color = MaterialTheme.colors.onBackground)
        Image(
            painterResource(R.drawable.compostd),
            contentDescription = "Covering with soil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = stringResource(id = R.string.profile_how_to_compost4), color = MaterialTheme.colors.onBackground)
    }
}
@Composable
private fun InsecticidesInfo(infoOpened : Int) {
    if(infoOpened == 3) {
        //Text(text = "How to make organic insecticides:", fontSize = 25.sp)
        Text(
            text = stringResource(id = R.string.profile_how_to_make_insecticides_steps)
            , color = MaterialTheme.colors.onBackground)
    }
}

@Composable
private fun ThingToGrowInfo(infoOpened : Int) {
    if(infoOpened == 4) {
        //Text(text = "Suggestions for what to grow in your garden:", fontSize = 25.sp)
        Image(
            painterResource(R.drawable.spinachfield),
            contentDescription = "Spinachfield",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(225.dp)
                .offset(75.dp,20.dp)
        )
            Text(
            text = stringResource(id = R.string.profile_suggested_vegetables1)
                , color = MaterialTheme.colors.onBackground)
    }
}
