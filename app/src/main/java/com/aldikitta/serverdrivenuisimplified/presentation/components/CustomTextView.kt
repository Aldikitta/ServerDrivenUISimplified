package com.aldikitta.serverdrivenuisimplified.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomTextView(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(text = text, modifier = modifier)
}