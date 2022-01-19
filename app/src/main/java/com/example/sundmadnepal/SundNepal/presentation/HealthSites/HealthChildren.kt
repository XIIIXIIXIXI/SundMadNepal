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
fun HealthChildren(/*navController: NavController*/) {
    Column(modifier = Modifier.padding(10.dp,0.dp)) {
        Text(text = stringResource(id = R.string.healthchildren_title),textAlign = TextAlign.Center,
            fontSize = 30.sp, color = MaterialTheme.colors.onBackground)
        LazyColumn {
            item {
                GeneralInfo()
            }
            item {
                ChildrenInfo()
            }
        }
        //BottomNavigationBarHome(navController = navController)
    }
}
@Composable
private fun ChildrenInfo() {
    Text(text = stringResource(id = R.string.healthchildren_title2), fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Row() {
        Column() {
            Text(text = stringResource(id = R.string.healthchildren_age), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthchildren_age1), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthchildren_age2), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthchildren_age3), color = MaterialTheme.colors.onBackground)
        }
        Column(modifier = Modifier.padding(30.dp,0.dp,0.dp,0.dp)) {
            Text(text = stringResource(id = R.string.healthchildren_male_kcal), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthchildren_male_kcal1), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthchildren_male_kcal2), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthchildren_male_kcal3), color = MaterialTheme.colors.onBackground)
        }
        Column(modifier = Modifier.padding(40.dp,0.dp,0.dp,0.dp)) {
            Text(text = stringResource(id = R.string.healthchildren_female_kcal), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthchildren_female_kcal1), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthchildren_female_kcal2), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthchildren_female_kcal3), color = MaterialTheme.colors.onBackground)
        }
    }
    Text(text = stringResource(id = R.string.healthchildren_info), color = MaterialTheme.colors.onBackground)
    Row(Modifier.padding(75.dp,0.dp,0.dp,0.dp)) {
        Image(painter = painterResource(id = R.drawable.cleanwaterbig),
            contentDescription = "Clean water",
            Modifier.size(200.dp,200.dp)
        )
    }
    Text(text = stringResource(id = R.string.healthchildren_info1), color = MaterialTheme.colors.onBackground)
    Text(text = stringResource(id = R.string.healthchildren_info2), color = MaterialTheme.colors.onBackground)
    Text(text = stringResource(id = R.string.healthchildren_info3), color = MaterialTheme.colors.onBackground)
    Row(Modifier.padding(75.dp,0.dp,0.dp,0.dp)) {
        Image(painter = painterResource(id = R.drawable.nosnacks),
            contentDescription = "No snacks",
            Modifier.size(200.dp,200.dp)
        )
    }
    Text(text = stringResource(id = R.string.healthchildren_info4), color = MaterialTheme.colors.onBackground)
}


