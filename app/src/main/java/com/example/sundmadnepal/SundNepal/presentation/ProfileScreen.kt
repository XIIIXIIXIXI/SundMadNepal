package com.example.sundmadnepal

import android.text.Layout
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import org.intellij.lang.annotations.JdkConstants

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = { BottomNavigationBarHome(navController = navController) }) {
    }
    Column() {
        //Text(text = "Tips and Tricks",textAlign = TextAlign.Center, fontSize = 30.sp)
        GardenTips()
    }
}

@Composable
fun GardenTips(){
    var infoOpened by remember{ mutableStateOf(0)}
    LazyColumn (){
        item {
            Button(onClick = { infoOpened = if(infoOpened != 1) 1 else 0 },
                Modifier
                    .size(410.dp, 50.dp)
                    .padding(5.dp)) {
                Text(text = "How to make your own garden", fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            GardenInfo(infoOpened)
        }
        item {
            Button(onClick = {infoOpened = if(infoOpened != 2) 2 else 0 },
                Modifier
                    .size(410.dp, 50.dp)
                    .padding(5.dp)) {
                Text(text = "How to make the Compost:", fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            CompostInfo(infoOpened)
        }
        item {
            Button(onClick = {infoOpened = if(infoOpened != 3) 3 else 0 },
                Modifier
                    .size(410.dp, 50.dp)
                    .padding(5.dp)) {
                Text(text = "How to make organic insecticides:", fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            InsecticidesInfo(infoOpened)
        }
        item {
            Button(onClick = {infoOpened = if(infoOpened != 4) 4 else 0 },
                Modifier
                    .size(410.dp, 50.dp)
                    .padding(5.dp)) {
                Text(text = "Suggested Vegetables to grow:", fontSize = 20.sp, textAlign = TextAlign.Center)
            }
            ThingToGrowInfo(infoOpened)
        }
    }
}

@Composable
fun GardenInfo(infoOpened : Int) {
    if(infoOpened == 1) {
            //Text(text = "How to make your own garden", fontSize = 25.sp)
            Text(
                text = "Making your own garden means you can have a healthy life without spending lots of money\n" +
                        "Even if you only have very little space you can still grow vegetables\n"
            )
            Text(
                text = "Preparing the Soil: \n" +
                        "\n1. dig the soil to make it loose.\n" +
                        "\n2. Prepare the soil: mix compost with soil add compost in soil and leave it for 8 to 10 days.\n" +
                        "\n3. Moisturize the soil\n" +
                        "\n4. Soil be prepared in 8 to 10 days\n" +
                        "\n5. Then make a high land for the crops growing.\n"
            )

    }
}
@Composable
fun CompostInfo(infoOpened : Int) {
    if(infoOpened == 2) {
        //Text(text = "How to make the Compost:", fontSize = 25.sp)
        Text(
            text = "Compost size of 2m*2m(L*B)\n 1. to make compost we need Cow’s urine, leaves , bushes with leaves, ash and Cow dungl.\n" +
                    "\t - make pit according to how much land you have.\n" +
                    "\n" +
                    "2. put layer by layer elements in the pit, firstly, put Bushes with leaves then cow dung, then Urine and ash. repeat until the pit is full.\n" +
                    "\n" +
                    "3. Put a stick that reach the bottom  of pit and cover it with Soil.\n" +
                    "\n" +
                    "4. Your compost Pit will be ready in 30 to 35 days.\n"
        )
    }
}
@Composable
fun InsecticidesInfo(infoOpened : Int) {
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
fun ThingToGrowInfo(infoOpened : Int) {
    if(infoOpened == 4) {
        //Text(text = "Suggestions for what to grow in your garden:", fontSize = 25.sp)
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
