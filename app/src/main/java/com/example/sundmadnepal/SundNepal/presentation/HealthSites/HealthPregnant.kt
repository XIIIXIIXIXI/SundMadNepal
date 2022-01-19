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
import androidx.compose.ui.res.stringResource
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
    Column(modifier = Modifier.padding(10.dp,0.dp)) {
        Text(text = stringResource(id = R.string.healthpregnant_title),textAlign = TextAlign.Center,
            fontSize = 30.sp, color = MaterialTheme.colors.onBackground)
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
    Text(text = stringResource(id = R.string.healthpregnant_title2),fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Text(text = stringResource(id = R.string.healthpregnant_meal), color = MaterialTheme.colors.onBackground)

    Image(painter = painterResource(id = R.drawable.gravidlyttermave),
        contentDescription = "Check-up",
        Modifier.size(250.dp,200.dp)
    )
    Text(text = stringResource(id = R.string.healthpregnant_health), color = MaterialTheme.colors.onBackground)
    Image(painter = painterResource(id = R.drawable.gravidorm),
        contentDescription = "Worm",
        Modifier.size(200.dp,170.dp)
    )
    Text(text = stringResource(id = R.string.healthpregnant_health2), color = MaterialTheme.colors.onBackground)
    
    Text(text = stringResource(id = R.string.healthpregnant_iron), color = MaterialTheme.colors.onBackground)
    Text(text = stringResource(id = R.string.healthpregnant_rest), color = MaterialTheme.colors.onBackground)
}
