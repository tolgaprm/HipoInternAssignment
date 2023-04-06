package com.prcoding.hipointernassignment.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun HipoTopBar(
    text: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = Color.White,
        title = {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h4
            )
        }
    )
}