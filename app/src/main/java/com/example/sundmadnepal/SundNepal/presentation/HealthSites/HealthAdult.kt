package com.example.sundmadnepal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome

@Composable
fun HealthAdult(navController: NavController) {
    Column() {
        Text(text = "Health information for adults",textAlign = TextAlign.Center,
            fontSize = 30.sp)
        LazyColumn {
            item {
                FemaleInfo()
            }
            item {
                MaleInfo()
            }
        }
        BottomNavigationBarHome(navController = navController)
    }
}

@Composable
private fun FemaleInfo(){
    Text(text = "Females:",fontSize = 20.sp)
    Text(text = "19–30 years ~ 2,000–2,400 calories")
    Text(text = "31–59 years ~ 1,800–2,200 calories")
    Text(text = "60+ years ~ 1,600–2,000 calories")
    Text(text = "HAJAH AHAAHHAHA HAHAHA HAAHAHHA HAH AHHAHHAHAHAHA HAHAHAH AHAHAHA HA HAHA HA H")
    Text(text = "HAJAH AHAAHHAHA HAHAHA HAAHAHHA HAH AHHAHHAHAHAHA HAHAHAH AHAHAHA HA HAHA HA H")

}


@Composable
private fun MaleInfo(){
    Text(text = "Males:",fontSize = 20.sp)
    Text(text = "19–30 years ~ 2,400–3,000 calories")
    Text(text = "31–59 years ~ 2,200–3,000 calories")
    Text(text = "60+ years ~ 2,000–2,600 calories")
    Text(text = "HAJAH AHAAHHAHA HAHAHA HAAHAHHA HAH AHHAHHAHAHAHA HAHAHAH AHAHAHA HA HAHA HA H")
    Text(text = "HAJAH AHAAHHAHA HAHAHA HAAHAHHA HAH AHHAHHAHAHAHA HAHAHAH AHAHAHA HA HAHA HA H")
    Text(text = "HAJAH AHAAHHAHA HAHAHA HAAHAHHA HAH AHHAHHAHAHAHA HAHAHAH AHAHAHA HA HAHA HA H")
    Text(text = "HAJAH AHAAHHAHA HAHAHA HAAHAHHA HAH AHHAHHAHAHAHA HAHAHAH AHAHAHA HA HAHA HA H")

}