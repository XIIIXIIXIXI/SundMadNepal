package com.example.sundmadnepal.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = SlightlyLessDark,
    secondary = Teal200,
    onSurface = DarkGray
)

private val LightColorPalette = lightColors(
    primary = Black, //for text
    primaryVariant = Teal200, //for background
    secondary = Teal200,
    background = White,
    //navBar
    onSecondary = OffWhite, //for navBar
    onSurface = SlightlyLessLightGray //for recipe Card

    // add recipe

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun SundMadNepalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}