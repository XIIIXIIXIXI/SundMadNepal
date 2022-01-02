package com.example.sundmadnepal.SundNepal.presentation.Home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DefaultButton(
    text: String,
    icon: ImageVector,
    onClick: () -> Unit,
    //cornerRadius: Dp = 10.dp,

) {
    Button(onClick,
        modifier = Modifier.fillMaxWidth(0.5f),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.onBackground)
    ) {
        Row(
            modifier = Modifier.align(alignment = CenterVertically).fillMaxWidth(0.9f), Arrangement.SpaceBetween
        ){
            Text(text, color = MaterialTheme.colors.primary)
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                icon,
                contentDescription = text,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }

    }
}