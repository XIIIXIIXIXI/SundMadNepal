package com.example.sundmadnepal.SundNepal.presentation.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import com.example.sundmadnepal.R
//found on StackOverflow https://stackoverflow.com/questions/66942587/how-to-make-a-surface-background-half-transparent-in-jetpack-compose-but-not-th

@Composable
fun ImageCover( alpha: Float = 0.5f, content: @Composable () -> Unit){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.carrot),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Surface(
            color = Color.Black.copy(alpha = 0.6f), modifier = Modifier
                .fillMaxSize()
        ){
            content()
        }
    }
}