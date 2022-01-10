package com.example.sundmadnepal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
@Preview
@Composable
fun HealthAdult(/*navController: NavController*/) {
    Column() {
        Text(text = "Health information for adults",textAlign = TextAlign.Center,
            fontSize = 30.sp)
        LazyColumn {
            item { 
                GeneralInfo()
            }
            item {
                FemaleInfo()
            }
            item {
                MaleInfo()
            }
        }
        //BottomNavigationBarHome(navController = navController)
    }
}
@Composable
private fun GeneralInfo(){
    Row() {
        Image(painter = painterResource(id = R.drawable.unbalanceddiet),
            contentDescription = "unbalanced diet",
            Modifier.size(170.dp,170.dp)
        )
        Image(painter = painterResource(id = R.drawable.balanceddiet),
            contentDescription = "balanced diet",
            Modifier.size(170.dp,170.dp)
        )
    }
    Text(text = "To ensure a healthy and nutritional diet, Your meals throughout the day should resemble the picture with the checkmark above.\n " +
            "Eat at least four types of food every day (including grains and legumes, nuts, vegetables and livestock sources (milk, eggs, fish, meat).")
}

@Composable
private fun FemaleInfo(){
    Image(painter = painterResource(id = R.drawable.woman),
        contentDescription = "Woman",
        Modifier.size(120.dp)
    )
    Text(text = "Females:",fontSize = 20.sp)

    Text(text = "Females differ to the males in that the amount of calories required on a daily basis is lower than their male counterparts. Please follow the amount described below for optimal health-benefits:")
    Text(text = "19–30 years ~ 2,000–2,400 calories")
    Text(text = "31–59 years ~ 1,800–2,200 calories")
    Text(text = "60+ years ~ 1,600–2,000 calories")
    Text(text = "Furthermore females should keep prioritize foods which contain Vitamin A and Iron")
    Image(painter = painterResource(id = R.drawable.vitamina),
        contentDescription = "vitaminA",
        Modifier
            .width(500.dp)
            .height(200.dp)

    )
    Text(text = "Vitamin A dense foods:\n Green Vegetables: Spinach, Chamsur, Radish Leaf, Beet Munta, Zucchini, Latte, Bethe, Poi Greens etc.\n" +
            "Fruits and vegetables: ripe mangoes, nuts, carrots, ripe peas, haluwaved etc.\n" +
            "From the forest and around the water: Neuro, Stinging nettle, Aldo, Simrayo Jaluko etc.\n" +
            "Animal food: liver, eggs, small fish, milk etc.\n")
    Image(painter = painterResource(id = R.drawable.iron),
        contentDescription = "iron",
        Modifier
            .width(500.dp)
            .height(200.dp)
            .scale(1.4f, 1f)
    )
    // https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.yummytoddlerfood.com%2Firon-rich-foods-for-kids%2F&psig=AOvVaw2GOByfgq1wFEqewaBniNY8&ust=1641550741008000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKDi7pjznPUCFQAAAAAdAAAAABAD
    Text(text = "Iron dense foods include:\n" +
            "Green vegetables, " +
            "Beans (found more in sprouts), " +
            "Gundruk, " +
            "Kodo, " +
            "Beaten rice, " +
            "Cauliflower leaves " +
            "Bananas, Meat, Eggs, Fish.\n" +
            "As well as Food cooked in an iron pot"
            )
}


@Composable
private fun MaleInfo(){
    Image(painter = painterResource(id = R.drawable.man),
        contentDescription = "man",
        Modifier.size(120.dp)
    )
    Text(text = "Males:",fontSize = 20.sp)
    Text(text = "19–30 years ~ 2,400–3,000 calories")
    Text(text = "31–59 years ~ 2,200–3,000 calories")
    Text(text = "60+ years ~ 2,000–2,600 calories\n")

    Text(text = "Furthermore it's common for the average male to be these essential elements:")
    Text("Vitamin D, Magnesium, Vitamin B12 and Potassium\n")
    Text("Vitamin D reduces inflammation and strengthens the skeleton, the vitamin is produced when spending time in the sun but can be supplemented by adding oily fish, meats, eggs and dairy to your diet.\n")
    Text(text = "Magnesium is another common element is which many males are lacking. Low levels of magnesium may increase your risk of heart disease, magnesium dense foods include: spinach, nuts, seeds and whole grains\n")
    Text(text = "Vitamin B12 is used for DNA synthesis, energy production, and nerve function. Food sources dense in B12 include: Meats, Fish and dairy products\n")
    Text(text = "Potassium benefits nerve function and muscle contraction, Potassium rich foods include: Vegetables, milk, yogurt, beans, nuts and fish such as: Tuna, Halibut, Cod and Trout")
}