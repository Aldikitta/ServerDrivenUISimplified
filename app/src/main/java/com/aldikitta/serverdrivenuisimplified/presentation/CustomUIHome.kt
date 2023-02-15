package com.aldikitta.serverdrivenuisimplified.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.aldikitta.serverdrivenuisimplified.core.data.model.CustomUIModel
import com.aldikitta.serverdrivenuisimplified.presentation.components.CustomTextView
import com.aldikitta.serverdrivenuisimplified.presentation.composables.AlertDialogFailed
import com.aldikitta.serverdrivenuisimplified.presentation.composables.CustomCircularProgressIndicator
import com.aldikitta.serverdrivenuisimplified.presentation.composables.FormView
import org.koin.androidx.compose.koinViewModel

@Composable
fun CustomUIHome(
    viewModel: CustomUIViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    CustomUIHomeResponseHandling(customUIState = uiState)
}

@Composable
fun CustomUIHomeResponseHandling(
    customUIState: CustomUIState
) {
    val openDialog = remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        when (customUIState) {
            is CustomUIState.Error -> {
                openDialog.value = true
            }
            is CustomUIState.Success -> {
                openDialog.value = false
            }
            else -> {
                openDialog.value = true
            }
        }
    }
    when (customUIState) {
        is CustomUIState.Loading -> CustomCircularProgressIndicator()
        is CustomUIState.Success -> {
            customUIState.customUIModel?.let { CustomUIContent(customUIModel = it) }
        }
        is CustomUIState.Error -> {
            AlertDialogFailed(
                onDismissRequest = { openDialog.value = false },
                errorMessage = "an error occurred",
                onConfirmButton = {
                    openDialog.value = false
                }
            )
        }
    }
}

@Composable
fun CustomUIContent(
    customUIModel: CustomUIModel,
//    responseData: HashMap<String, String>,
//    onDataEntered: (String, String) -> Unit,
) {
    val context = LocalContext.current
    val response by mutableStateOf(HashMap<String, String>())
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomTextView(text = customUIModel.headingText)
            Spacer(modifier = Modifier.height(32.dp))
//            Image(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(60.dp),
//                painter = rememberAsyncImagePainter(
//                    remember(customUIModel.logoUrl) {
//                        ImageRequest.Builder(context)
//                            .data(customUIModel.logoUrl)
//                            .build()
//                    }
//                ),
//                contentDescription = null
//            )
            Spacer(modifier = Modifier.height(32.dp))

//            customUIModel?.let {
//                LazyColumn(modifier = Modifier.fillMaxWidth()) {
//                    items(customUIModel.uidata) {
//                        FormView(
//                            uiData = it,
////                            responseData = response,
////                            enteredData = {key, value ->
////                                response[key] = value
////                            }
//                        )
//                    }
//                }
//            }
        }
    }
}