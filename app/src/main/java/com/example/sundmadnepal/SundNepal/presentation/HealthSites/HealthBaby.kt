package com.example.sundmadnepal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
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
import org.intellij.lang.annotations.JdkConstants

@Preview
@Composable
fun HealthBaby(/*navController: NavController*/) {
    Column(modifier = Modifier.padding(10.dp,0.dp)) {
        Text(text = stringResource(id = R.string.healthbaby_title),textAlign = TextAlign.Center,
            fontSize = 30.sp, color = MaterialTheme.colors.onBackground)
        LazyColumn {
            item {
                GeneralInfo()
            }
            item {
                NationalImmunization()
            }
            item {
                FirstPeriod()
            }
            item {
                SecondPeriod()
            }
            item {
                ThirdPeriod()
            }
            item {
                FourthPeriod()
            }
        }
        //BottomNavigationBarHome(navController = navController)
    }
}
@Composable
private fun NationalImmunization() {
    Text(text = stringResource(id = R.string.healthbaby_nationalimmunization), fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Row(verticalAlignment = Alignment.CenterVertically, /*modifier = Modifier.size(400.dp,200.dp)*/) {
        Column(Modifier
            .padding(10.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text(text = stringResource(id = R.string.healthbaby_vaccine), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine1), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine2), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine3), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine4), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine5), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine6), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine7), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine8), color = MaterialTheme.colors.onBackground)

        }
        Column(Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp)) {
            Text(text = stringResource(id = R.string.healthbaby_vaccine_age), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine_age1), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine_age2), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine_age3), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine_age4), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine_age5), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine_age6), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine_age7), color = MaterialTheme.colors.onBackground)
            Text(text = stringResource(id = R.string.healthbaby_vaccine_age8), color = MaterialTheme.colors.onBackground)
        }
    }
}

@Composable
private fun FirstPeriod() {
    Text(text = stringResource(id = R.string.healthbaby_firstperiod_title), fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.gotohealthpost),
            contentDescription = "Go do health inspection",
            Modifier
                .size(250.dp, 200.dp)
                .scale(1.5f)
        )
    }
    Text(text = stringResource(id = R.string.healthbaby_firstperiod), color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.firstmonths),
            contentDescription = "breastfeeding",
            Modifier
                .size(250.dp, 200.dp)
                .scale(1.5f)
        )
    }
    Text(text = stringResource(id = R.string.healthbaby_firstperiod1), color = MaterialTheme.colors.onBackground)

    Text(
        text = stringResource(id = R.string.healthbaby_firstperiod2)
        , color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.breastfeeding),
            contentDescription = "breastfeeding",
            Modifier
                .size(250.dp, 200.dp)
                .scale(1.5f)
        )
    }
    Text(
        stringResource(id = R.string.healthbaby_firstperiod3)
        , color = MaterialTheme.colors.onBackground)
}

@Composable
private fun SecondPeriod() {
    Text(text = stringResource(id = R.string.healthbaby_secondperiod_title), fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.gotohealthpost),
            contentDescription = "Go do health inspection",
            Modifier
                .size(250.dp, 200.dp)
                .scale(1.5f)
        )
    }
    Text(text = stringResource(id = R.string.healthbaby_secondperiod), color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 40.dp, 0.dp, 40.dp)) {
        Image(
            painter = painterResource(id = R.drawable.breastfeedingandfeeding),
            contentDescription = "Breastfeeding and feeding regular food",
            Modifier
                .size(250.dp, 200.dp)
                .scale(1.5f)
        )
    }
    Text(
        text = stringResource(id = R.string.healthbaby_secondperiod1)
        , color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 30.dp)) {
        Image(
            painter = painterResource(id = R.drawable.feedingandfood),
            contentDescription = "Preparing regular food",
            Modifier
                .size(250.dp, 200.dp)
                .scale(1.6f, 1.7f)
        )
    }
    Text(text = stringResource(id = R.string.healthbaby_secondperiod2), color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 30.dp)) {
        Image(
            painter = painterResource(id = R.drawable.twochildrenlogosalt),
            contentDescription = "Salt logo",
            Modifier
                .size(100.dp, 100.dp)
        )
    }
    Text(text = stringResource(id = R.string.healthbaby_secondperiod3), color = MaterialTheme.colors.onBackground)
    Text(text = stringResource(id = R.string.healthbaby_secondperiod4), color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 20.dp)) {
        Image(
            painter = painterResource(id = R.drawable.boiledwater),
            contentDescription = "Boiled water",
            Modifier
                .size(200.dp, 200.dp)

        )
    }
    Text(text = stringResource(id = R.string.healthbaby_secondperiod5), color = MaterialTheme.colors.onBackground)
}
@Composable
private fun ThirdPeriod() {
    Text(text = stringResource(id = R.string.healthbaby_thirdperiod_title), fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 0.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ninemonthswithfoods),
            contentDescription = "Food guide",
            Modifier
                .size(250.dp, 250.dp)
                .scale(1.6f)
        )
    }
    Text(text = stringResource(id = R.string.healthbaby_thirdperiod), color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.nosnacks),
            contentDescription = "No snacks",
            Modifier
                .size(170.dp, 170.dp)
        )
    }
    Text(text = stringResource(id = R.string.healthbaby_thirdperiod1), color = MaterialTheme.colors.onBackground)
}
@Composable
private fun FourthPeriod() {
    Text(text = stringResource(id = R.string.healthbaby_fourthperiod_title), fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Text(text = stringResource(id = R.string.healthbaby_fourthperiod), color = MaterialTheme.colors.onBackground)
    Text(text = stringResource(id = R.string.healthbaby_fourthperiod1), color = MaterialTheme.colors.onBackground)
}
