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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
import com.example.sundmadnepal.SundNepal.presentation.util.Screen

@Preview
@Composable
fun HealthChildren(/*navController: NavController*/) {
    Column() {
        Text(text = "Health information for adults",textAlign = TextAlign.Center,
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



private fun PregnancyInfo() {
    TODO("Not yet implemented")
}
