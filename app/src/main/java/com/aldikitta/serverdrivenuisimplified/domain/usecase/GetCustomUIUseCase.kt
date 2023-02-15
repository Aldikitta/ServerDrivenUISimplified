package com.aldikitta.serverdrivenuisimplified.domain.usecase

import com.aldikitta.serverdrivenuisimplified.core.commons.NetworkResponse
import com.aldikitta.serverdrivenuisimplified.core.data.model.CustomUIModel
import kotlinx.coroutines.flow.Flow

interface GetCustomUIUseCase {
    operator fun invoke(): Flow<NetworkResponse<CustomUIModel>>
}