package com.example.sundmadnepal.SundNepal.data

import com.example.sundmadnepal.R

data class KeyIngredient(
    val image: Int,
    val name: String
)

val defaultKeyIngredient = listOf(
    KeyIngredient(R.drawable.carrot, "carrot"),
    KeyIngredient(R.drawable.garlic, "garlic"),
    KeyIngredient(R.drawable.onion, "onion"),
    KeyIngredient(R.drawable.spinach, "spinach"),
    KeyIngredient(R.drawable.tomato, "tomato")
)