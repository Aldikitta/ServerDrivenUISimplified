package com.aldikitta.serverdrivenuisimplified.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonLabel: String
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(text = buttonLabel)
    }
}