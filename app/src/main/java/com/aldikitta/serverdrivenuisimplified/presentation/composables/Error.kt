package com.aldikitta.serverdrivenuisimplified.presentation.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AlertDialogFailed(
    onDismissRequest: () -> Unit,
    onConfirmButton: () -> Unit,
    errorMessage: String
) {
    AlertDialog(
        onDismissRequest = {
            onDismissRequest()
        },
        icon = {
            Icon(
                Icons.Filled.ArrowDropDown,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.error
            )
        },
        title = {
            Text(text = "An Error Occurred")
        },
        text = {
            Text(
                errorMessage, textAlign = TextAlign.Center
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmButton()
                }
            ) {
                Text("OK")
            }
        }
    )
}