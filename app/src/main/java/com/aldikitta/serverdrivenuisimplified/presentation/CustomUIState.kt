package com.aldikitta.serverdrivenuisimplified.presentation

import com.aldikitta.serverdrivenuisimplified.core.data.model.CustomUIModel

sealed interface CustomUIState {
    object Loading : CustomUIState
    data class Success(
        val customUIModel: CustomUIModel? = null
    ) : CustomUIState
    data class Error(val error: String) : CustomUIState
}