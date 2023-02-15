package com.aldikitta.serverdrivenuisimplified.domain.usecase

import com.aldikitta.serverdrivenuisimplified.core.commons.NetworkResponse
import com.aldikitta.serverdrivenuisimplified.core.commons.asResponse
import com.aldikitta.serverdrivenuisimplified.core.data.model.CustomUIModel
import com.aldikitta.serverdrivenuisimplified.core.data.repository.CustomUIRepository
import kotlinx.coroutines.flow.Flow

class GetCustomUIUseCaseImpl(
    private val customUIRepository: CustomUIRepository
) : GetCustomUIUseCase {
    override fun invoke(): Flow<NetworkResponse<CustomUIModel>> {
        return customUIRepository.getCustomUI().asResponse()
    }
}