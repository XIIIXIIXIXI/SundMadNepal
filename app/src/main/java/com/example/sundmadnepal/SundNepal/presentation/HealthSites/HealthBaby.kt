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
        Text(text = "Health information for Children",textAlign = TextAlign.Center,
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
    Text(text = "National immunization schedule", fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Row(verticalAlignment = Alignment.CenterVertically, /*modifier = Modifier.size(400.dp,200.dp)*/) {
        Column(Modifier
            .padding(10.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text(text = "Vaccine", color = MaterialTheme.colors.onBackground)
            Text(text = "1. BCG", color = MaterialTheme.colors.onBackground)
            Text(text = "2. DPT Hepatitis B HemoPhilos", color = MaterialTheme.colors.onBackground)
            Text(text = "3. OPV (Oral polio Vaccine)", color = MaterialTheme.colors.onBackground)
            Text(text = "4. PCV\n", color = MaterialTheme.colors.onBackground)
            Text(text = "5. Rota Virus", color = MaterialTheme.colors.onBackground)
            Text(text = "6. FIPV\n (Fractional " +
                    "Injectable Polio vaccine)", color = MaterialTheme.colors.onBackground)
            Text(text = "7. MR (Measles Rebula)\n", color = MaterialTheme.colors.onBackground)
            Text(text = "8. JE (Japanese Encephditis)", color = MaterialTheme.colors.onBackground)

        }
        Column(Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp)) {
            Text(text = "Age", color = MaterialTheme.colors.onBackground)
            Text(text = "At birth", color = MaterialTheme.colors.onBackground)
            Text(text = "At weeks: 6,10,14", color = MaterialTheme.colors.onBackground)
            Text(text = "At weeks: 6,10,14", color = MaterialTheme.colors.onBackground)
            Text(text = "At weeks: 6,10 And Month: 9.", color = MaterialTheme.colors.onBackground)
            Text(text = "At weeks: 6,10", color = MaterialTheme.colors.onBackground)
            Text(text = "At weeks: 6,14\n", color = MaterialTheme.colors.onBackground)
            Text(text = "At Months: 9 and 15\n", color = MaterialTheme.colors.onBackground)
            Text(text = "At Month: 12", color = MaterialTheme.colors.onBackground)
        }
    }
}

@Composable
private fun FirstPeriod() {
    Text(text = "0-6 months", fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.gotohealthpost),
            contentDescription = "Go do health inspection",
            Modifier
                .size(250.dp, 200.dp)
                .scale(1.5f)
        )
    }
    Text(text = "The child should be examined at the health institution on the third day within 24 hours of birth and at 4 months.", color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.firstmonths),
            contentDescription = "breastfeeding",
            Modifier
                .size(250.dp, 200.dp)
                .scale(1.5f)
        )
    }
    Text(text = "The first yellow milk of the mother should be fed as soon as possible (within 1 hour) after the birth of the newborn baby.", color = MaterialTheme.colors.onBackground)

    Text(
        text = "From birth to 6 months the baby does not need to be fed water as it is exclusively breast milk.\n" +
                "Starting breastfeeding as soon as you are born helps to keep the milk constant.\n"
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
        "Newborns should be breastfed at least 10 times a day, day and night.\n" +
                "Feed from one breast only after feeding in another way.\n"
        , color = MaterialTheme.colors.onBackground)
}

@Composable
private fun SecondPeriod() {
    Text(text = "6-9 months", fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.gotohealthpost),
            contentDescription = "Go do health inspection",
            Modifier
                .size(250.dp, 200.dp)
                .scale(1.5f)
        )
    }
    Text(text = "After the child reaches 6 months and 9 months, go to the health institution for examination", color = MaterialTheme.colors.onBackground)
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
        text = "After the completion of 6 months (180 days), breast milk should be fed with different foods till the completion of two years. \n" +
                "\n" +
                "When starting different feeding, feed 2 to 3 tablespoons at a time and then increase to 1 cup of tea (125 ml) at a time.\n"
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
    Text(text = "Different foods should be prepared daily by mixing at least 4 groups of food (grains, nuts, animal foods, fruits and vegetables)." +
            "\nOnly salt with two children logo should be used when preparing food.", color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 30.dp)) {
        Image(
            painter = painterResource(id = R.drawable.twochildrenlogosalt),
            contentDescription = "Salt logo",
            Modifier
                .size(100.dp, 100.dp)
        )
    }
    Text(text = "Baby food should be soft and fluffy.", color = MaterialTheme.colors.onBackground)
    Text(text = "Always use clean or boiled water.", color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 10.dp, 0.dp, 20.dp)) {
        Image(
            painter = painterResource(id = R.drawable.boiledwater),
            contentDescription = "Boiled water",
            Modifier
                .size(200.dp, 200.dp)

        )
    }
    Text(text = "Wash hands thoroughly with soap and water before cooking and after feeding.", color = MaterialTheme.colors.onBackground)
}
@Composable
private fun ThirdPeriod() {
    Text(text = "9-12 months", fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(75.dp, 0.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ninemonthswithfoods),
            contentDescription = "Food guide",
            Modifier
                .size(250.dp, 250.dp)
                .scale(1.6f)
        )
    }
    Text(text = "In addition to breastfeeding, feed the baby 3 times a day (2 meals and 1 oatmeal), one glass of tea (125 ml) different food and 1 meal.\n" +
            "Fruits can be included in the lunch\n", color = MaterialTheme.colors.onBackground)
    Row(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp)) {
        Image(
            painter = painterResource(id = R.drawable.nosnacks),
            contentDescription = "No snacks",
            Modifier
                .size(170.dp, 170.dp)
        )
    }
    Text(text = "Discourage eating less nutritious food available in the market.\n" +
            "It will make your child less healthy\n", color = MaterialTheme.colors.onBackground)
}
@Composable
private fun FourthPeriod() {
    Text(text = "12-24 months", fontSize = 25.sp, color = MaterialTheme.colors.onBackground)
    Text(text = "In addition to breastfeeding, 3 times a day (3 meals only), two teaspoons of glass (250 ml) of supplementary food and 2 meals should be fed.", color = MaterialTheme.colors.onBackground)
    Text(text = " Each meal should include the three food groups.\n" +
            "Snacks should include seasonal fruits and eggs if possible. Beans are also good for snack.\n" +
            "Eating fresh home-cooked food (meat, eggs and fish) should be encouraged.\n", color = MaterialTheme.colors.onBackground)
}
