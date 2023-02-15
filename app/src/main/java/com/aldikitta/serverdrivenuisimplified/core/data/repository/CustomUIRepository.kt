package com.aldikitta.serverdrivenuisimplified.core.data.repository

import com.aldikitta.serverdrivenuisimplified.core.data.model.CustomUIModel
import kotlinx.coroutines.flow.Flow

interface CustomUIRepository {
    fun getCustomUI(): Flow<CustomUIModel>
}