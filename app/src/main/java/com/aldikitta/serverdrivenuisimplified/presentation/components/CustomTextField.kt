package com.aldikitta.serverdrivenuisimplified.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
//    labelTextField: String,
    placeHolderTextField: String,
    isNumberField: Boolean
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
//        label = {
//            Text(text = labelTextField)
//        },
        placeholder = {
            Text(text = placeHolderTextField)
        },
        keyboardOptions = if (isNumberField) KeyboardOptions(keyboardType = KeyboardType.Number) else KeyboardOptions.Default
    )
}