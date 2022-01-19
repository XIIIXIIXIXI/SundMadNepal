package com.example.sundmadnepal

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sundmadnepal.SundNepal.presentation.util.BottomNavigationBarHome
@Preview
@Composable
fun HealthAdult(/*navController: NavController*/) {
    Column(modifier = Modifier.padding(10.dp,0.dp)) {
        Text(text = stringResource(id = R.string.healthadult_title),textAlign = TextAlign.Center,
            fontSize = 30.sp, color = MaterialTheme.colors.onBackground)
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
fun GeneralInfo(){
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
    Text(text = stringResource(id = R.string.generalinfo1), color = MaterialTheme.colors.onBackground)

    Row(
        modifier = Modifier.padding(75.dp,0.dp,0.dp,0.dp)
    ) {
        /*Image(
            painter = painterResource(id = R.drawable.handwashing),
            contentDescription = "Handwashing",
            Modifier
                .size(110.dp, 150.dp)
                .padding(10.dp)
        )*/
        Image(
            painter = painterResource(id = R.drawable.whentowashhands),
            contentDescription = "Handwashing",
            Modifier
                .size(250.dp, 200.dp)
                .scale(1.4f)
                .padding(10.dp)
        )
    }
    Text(text = stringResource(id = R.string.generalinfo2), color = MaterialTheme.colors.onBackground)


}

@Composable
private fun FemaleInfo(){
    Image(painter = painterResource(id = R.drawable.woman),
        contentDescription = "Woman",
        Modifier.size(120.dp)
    )
    Text(text = stringResource(id = R.string.healthadult_female_title),fontSize = 20.sp, color = MaterialTheme.colors.onBackground)
    Text(text = stringResource(id = R.string.healthadult_female_calories), color = MaterialTheme.colors.onBackground)
    Image(painter = painterResource(id = R.drawable.vitamina),
        contentDescription = "vitaminA",
        Modifier
            .width(500.dp)
            .height(200.dp)

    )
    Text(text = stringResource(id = R.string.healthadult_female_vitamina), color = MaterialTheme.colors.onBackground)
    Image(painter = painterResource(id = R.drawable.iron),
        contentDescription = "iron",
        Modifier
            .width(500.dp)
            .height(200.dp)
            .scale(1.4f, 1f)
    )
    // https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.yummytoddlerfood.com%2Firon-rich-foods-for-kids%2F&psig=AOvVaw2GOByfgq1wFEqewaBniNY8&ust=1641550741008000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKDi7pjznPUCFQAAAAAdAAAAABAD
    Text(text = stringResource(id = R.string.healthadult_female_iron)
        , color = MaterialTheme.colors.onBackground)
}


@Composable
private fun MaleInfo(){
    Image(painter = painterResource(id = R.drawable.man),
        contentDescription = "man",
        Modifier.size(120.dp)
    )
    Text(text = stringResource(id = R.string.healthadult_male_title),fontSize = 20.sp, color = MaterialTheme.colors.onBackground)
    Text(text = stringResource(id = R.string.healthadult_male_calories), color = MaterialTheme.colors.onBackground)

    Text(text = stringResource(id = R.string.healthadult_male_info), color = MaterialTheme.colors.onBackground)
}