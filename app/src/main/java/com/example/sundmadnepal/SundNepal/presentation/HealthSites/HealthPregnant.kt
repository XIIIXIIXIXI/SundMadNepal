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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import com.example.sundmadnepal.SundNepal.presentation.util.Screen

@Preview
@Composable
fun HealthPregnant(/*navController: NavController*/) {
    Column() {
        Text(text = "Health information for Pregnant Women",textAlign = TextAlign.Center,
            fontSize = 30.sp)
        LazyColumn {
            item {
                GeneralInfo()
            }
            item {
                PregnancyInfo()
            }
        }
        //BottomNavigationBarHome(navController = navController)
    }
}

@Composable
private fun PregnancyInfo() {
    Text(text = "Pregnancy",fontSize = 25.sp)
    Text(text = "Pregnant women should eat one more balanced meal than usual. ")

    Image(painter = painterResource(id = R.drawable.gravidlyttermave),
        contentDescription = "Check-up",
        Modifier.size(250.dp,200.dp)
    )
    Text(text = "Regular health check-ups should be done at least 4 times (4, 6, 8, 9 months) and TT vaccination should be done.")
    Image(painter = painterResource(id = R.drawable.gravidorm),
        contentDescription = "Worm",
        Modifier.size(200.dp,170.dp)
    )
    Text(text = "After 3 months of pregnancy: go to the health facility and take anti-parasitic medicine.\n")
    
    Text(text = "From the first 3 months of pregnancy to the 45th day after childbirth: one tablet of iron should be taken once.")
    Text(text = "Get enough rest. You should not work very hard, you should not lift heavy weights and you should rest in between work.")
}
