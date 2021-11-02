package com.example.sundmadnepal

data class Recipes(
    val imageRes: Int,
    val title: String,
    val keyIngrediens: List<Int> = emptyList()
)

val allRecipes = listOf(
    Recipes(R.drawable.lasagna, "Vegetable lasagna", listOf(R.drawable.carrot, R.drawable.onion, R.drawable.spinach)),
    Recipes(R.drawable.pasta, "Pasta", listOf(R.drawable.garlic, R.drawable.tomato))
)