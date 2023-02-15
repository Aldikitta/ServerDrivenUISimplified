package com.aldikitta.serverdrivenuisimplified.presentation.composables

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import com.aldikitta.serverdrivenuisimplified.core.data.model.UIData
import com.aldikitta.serverdrivenuisimplified.presentation.components.CustomTextField
import com.aldikitta.serverdrivenuisimplified.presentation.components.CustomTextView
import com.aldikitta.serverdrivenuisimplified.presentation.util.CustomUIType

@Composable
fun FormView(
    uiData: UIData,
//    responseData: HashMap<String, String>,
//    enteredData: (String, String) -> Unit,
) {
    when(uiData.uitype){
        CustomUIType.TEXT.type -> CustomTextView(text = uiData.value)
        CustomUIType.TEXT_FIELD.type -> {
//            val text = remember{ mutableStateOf(responseData[uiData.key] ?: "")}
            var text by rememberSaveable { mutableStateOf("") }
            CustomTextField(
                value = text,
                onValueChange = {
                    text = it
//                    enteredData(uiData.key, it)
                },
//                labelTextField = uiData.hint,
                placeHolderTextField = uiData.hint,
                isNumberField = uiData.key.equals("text_phone", true),
            )

        }
    }
}