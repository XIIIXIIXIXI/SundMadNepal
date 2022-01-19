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
fun HealthChildren(/*navController: NavController*/) {
    Column(modifier = Modifier.padding(10.dp,0.dp)) {
        Text(text = "Health information for Children",textAlign = TextAlign.Center,
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
    Text(text = "Children", fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Row() {
        Column() {
            Text(text = "Age in years", color = MaterialTheme.colors.onBackground)
            Text(text = "4-8", color = MaterialTheme.colors.onBackground)
            Text(text = "9-13", color = MaterialTheme.colors.onBackground)
            Text(text = "14-18", color = MaterialTheme.colors.onBackground)
        }
        Column(modifier = Modifier.padding(30.dp,0.dp,0.dp,0.dp)) {
            Text(text = "Male KCAL", color = MaterialTheme.colors.onBackground)
            Text(text = "1400-1600", color = MaterialTheme.colors.onBackground)
            Text(text = "1800-2200", color = MaterialTheme.colors.onBackground)
            Text(text = "2400-2800", color = MaterialTheme.colors.onBackground)
        }
        Column(modifier = Modifier.padding(40.dp,0.dp,0.dp,0.dp)) {
            Text(text = "Female KCAL", color = MaterialTheme.colors.onBackground)
            Text(text = "1400-1600", color = MaterialTheme.colors.onBackground)
            Text(text = "1600-2000", color = MaterialTheme.colors.onBackground)
            Text(text = "2000", color = MaterialTheme.colors.onBackground)
        }
    }
    Text(text = "\n Furthermore children's diet should include foods which contain Calcium and Fiber", color = MaterialTheme.colors.onBackground)
    Row(Modifier.padding(75.dp,0.dp,0.dp,0.dp)) {
        Image(painter = painterResource(id = R.drawable.cleanwaterbig),
            contentDescription = "Clean water",
            Modifier.size(200.dp,200.dp)
        )
    }
    Text(text = "Another commonly neglected part of a childs diet is ensuring proper hydration, proper hydration improves cognitive function", color = MaterialTheme.colors.onBackground)
    Text(text = "\n Calcium plays a big part in developing strong, health bones and teeth. Calcium dense foods include: Milk, soy-milk, sardines, cereals  and oatmeal", color = MaterialTheme.colors.onBackground)
    Text(text = "\n Fiber is key to prevent prevent heart disease and other conditions, it also helps digestion and prevents constipation", color = MaterialTheme.colors.onBackground)
    Row(Modifier.padding(75.dp,0.dp,0.dp,0.dp)) {
        Image(painter = painterResource(id = R.drawable.nosnacks),
            contentDescription = "No snacks",
            Modifier.size(200.dp,200.dp)
        )
    }
    Text(text = "Limiting snacks is a great way to ensure stable blood sugar ", color = MaterialTheme.colors.onBackground)
}


