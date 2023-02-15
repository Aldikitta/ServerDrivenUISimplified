package com.aldikitta.serverdrivenuisimplified.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aldikitta.serverdrivenuisimplified.core.commons.NetworkResponse
import com.aldikitta.serverdrivenuisimplified.domain.usecase.GetCustomUIUseCase
import kotlinx.coroutines.flow.*

class CustomUIViewModel(
    getCustomUIUseCase: GetCustomUIUseCase
) : ViewModel() {
    val uiState: StateFlow<CustomUIState> = getCustomUIUseCase()
        .map {
            when (it) {
                is NetworkResponse.Loading -> CustomUIState.Loading
                is NetworkResponse.Success -> CustomUIState.Success(it.data)
                is NetworkResponse.Error -> CustomUIState.Error(it.exception.toString())
            }
        }.stateIn(
            viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = CustomUIState.Loading
        )
}