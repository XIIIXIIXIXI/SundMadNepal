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
    Column(/*modifier = Modifier
        .background(MaterialTheme.colors.primaryVariant)
        .fillMaxWidth()
        .height(694.dp)
        //.fillMaxHeight()){
        .size(412.dp, 694.dp)*/)
    {
        //Text(text = "Tips and Tricks",textAlign = TextAlign.Center, fontSize = 30.sp)
        //Column() {
            GardenTips(navController = navController)
            //BottomNavigationBarHome(navController = navController)
        //}
    }
}


@Composable
private fun GardenTips(navController : NavController){
    var infoOpened by remember{ mutableStateOf(0)}
    //val color1 = ButtonDefaults.buttonColors(backgroundColor = Color(193, 93, 223))
    val color2 = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    val color1 = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
    LazyColumn (modifier = Modifier
        .background(MaterialTheme.colors.primaryVariant)
        .fillMaxWidth()
        .fillMaxHeight(0.93f)
    ){
        item {
            Button(onClick = { infoOpened = if(infoOpened != 1) 1 else 0 }
                , colors = if(infoOpened == 1) color1 else color2,
                modifier = Modifier
                    .size(410.dp, 53.dp)
                    .padding(5.dp)) {
                Text(text = "How to make your own garden", color = Black,fontSize = 20.sp, textAlign = TextAlign.Center)
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
                Text(text = "How to make the Compost:", color = Black,fontSize = 20.sp, textAlign = TextAlign.Center)
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
                Text(text = "How to make organic insecticides:", color = Black,fontSize = 20.sp, textAlign = TextAlign.Center)
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
                Text(text = "Suggested Vegetables to grow:", color = Black, fontSize = 20.sp, textAlign = TextAlign.Center)
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
            Text(
                text = "Making your own garden means you can have a healthy life without spending lots of money\n" +
                        "Even if you only have very little space you can still grow vegetables\n"
            )
        Text(text = "Preparing the Soil:")
        Image(
            painterResource(R.drawable.garden1),
            contentDescription = "Unprepared garden",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = "1. dig the soil to make it loose.")
        Image(
            painterResource(R.drawable.gardencompost),
            contentDescription = "Compost garden",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = "2. Prepare the soil: mix compost with soil add compost in soil and leave it for 8 to 10 days.")
        Image(
            painterResource(R.drawable.gardenwater),
            contentDescription = "Watering the garden",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = "3. Moisturize the soil\n")
        Text(text = "4. Soil be prepared in 8 to 10 days")
        Image(
            painterResource(R.drawable.gardenhighland1),
            contentDescription = "High land garden",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = "5. Then make a high land for the crops growing.\n")
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
        Text(text = "Compost size of 2m*2m(L*B)\n ")
        Image(
            painterResource(R.drawable.composta),
            contentDescription = "Scaling land for compost",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = "1. to make compost we need Cow’s urine, leaves , bushes with leaves, ash and Cow dungl.\n" +
                    "\t - make pit according to how much land you have.")
        Image(
            painterResource(R.drawable.compostb),
            contentDescription = "Layering the compost",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = "2. put layer by layer elements in the pit, firstly, put Bushes with leaves then cow dung, then Urine and ash. repeat until the pit is full.")
        Image(
            painterResource(R.drawable.compostc),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = "3. Put a stick that reach the bottom  of pit and cover it with Soil.")
        Image(
            painterResource(R.drawable.compostd),
            contentDescription = "Covering with soil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(10.dp)
                .size(175.dp)
        )
        Text(text = "4. Your compost Pit will be ready in 30 to 35 days.\n")
    }
}
@Composable
private fun InsecticidesInfo(infoOpened : Int) {
    if(infoOpened == 3) {
        //Text(text = "How to make organic insecticides:", fontSize = 25.sp)
        Text(
            text = "First make it in 50 liter drum\n" +
                    "It will be useful for all season vegetables  and use it by mixing 7 liter of water in 1 liter organic insecticides\n"
                    + "\ncollect Sweet , bitter , spicy , sour which have this taste. \n" +
                    "Like : Garlic , onion , Chilli , bones, Salt.\n" +
                    "\nWhat amount you need according to that you can make it. Like if you need 10 liter then you can add half gram of ingredients with Cow’s urine. \n" +
                    "\n" +
                    "Put all of ingredients in drum and cover it.\n" +
                    "\n" +
                    "After 4 to 5 days open the drum and move the liquid  with a stick.\n" +
                    "\n" +
                    "your Organic Insecticides will be ready to use in 25 to 30 days.\n"
        )
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
                .scale(1.3f)
                .offset(65.dp,40.dp)
        )
            Text(
            text = "Sarg: It is healthy and easy and grows all year around.\n" +
                    "\n" +
                    "Pumpkin: Rich in vitamin A\n" +
                    "\n" +
                    "Onion: Needed for most foods. Needs frequent watering.\n" +
                    "\n" +
                    "Cauliflower : it helps in Heart disease. It has Choline and Sulforaphane.\n" +
                    "\n" +
                    "Cabbage : It is rich in Vitamin K.\n" +
                    "\n" +
                    "Bitter gourd : It helps in lowering blood pressure.\n" +
                    "\n" +
                    "Tomato : it is rich in Vitamin A and C\n" +
                    "\n" +
                    "Carrot : It is rich in Vitamin A\n" +
                    "\n" +
                    "Cucumber : it is rich in Vitamin K\n" +
                    "\n" +
                    "Eggplant : it is rich in minerals and fibers\n"
        )
    }
}
