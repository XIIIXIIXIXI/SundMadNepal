package com.example.sundmadnepal.SundNepal.presentation.recipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sundmadnepal.SundNepal.data.Cake
import com.example.sundmadnepal.ui.theme.LightGray
import com.example.sundmadnepal.ui.theme.Shapes
import com.example.sundmadnepal.ui.theme.SlightlyLessLightGray


@Composable
fun StepsScreen(viewModel: RecipesViewModel = hiltViewModel()) {
    SMainFragment(viewModel)
}

@Composable
fun SMainFragment(viewModel: RecipesViewModel) {
    Box() {
        SContent(viewModel)
    }
}

@Composable
fun SContent(viewModel: RecipesViewModel) {
    val completedStep by remember { mutableStateOf(mutableListOf(false, false))}
    LazyColumn() {
        items(Cake.stepss.size) { counter ->

            Row(
                horizontalArrangement = Arrangement.Start,

                modifier = if (counter % 2 == 0 && counter != Cake.stepss.size) {
                    Modifier
                        .fillMaxWidth()
                        .background(SlightlyLessLightGray)
                        .padding(vertical = 10.dp)
                        .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {completedStep[counter] = !completedStep[counter]}
                        )
                    }
                } else {
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {completedStep[counter] = !completedStep[counter]}
                        )
                    }
                }
            ) {


                if (Cake.stepss[counter].stepImage == 0) {
                    Text(
                        text = "${counter}.",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                    Text(
                        text = Cake.stepss[counter].stepText,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp
                    )
                }
                if (Cake.stepss[counter].stepImage != 0) {
                    Column(
                        modifier = Modifier
                            .padding(top = 50.dp),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "${counter}.",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(horizontal = 15.dp)
                        )
                    }
                    Column(Modifier.width(222.dp)) {
                        Text(
                            text = Cake.stepss[counter].stepText,
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(bottom = 0.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(PaddingValues(end = 15.dp))
                                .width(100.dp)
                                .height(100.dp),
                            backgroundColor = LightGray,
                            shape = Shapes.large,
                            elevation = 0.dp
                        ) {
                            Image(
                                painter = painterResource(id = Cake.stepss[counter].stepImage),
                                contentDescription = null,
                                modifier = Modifier.padding(15.dp)
                            )
                        }

                    }

                }

            }
        }
    }
}

