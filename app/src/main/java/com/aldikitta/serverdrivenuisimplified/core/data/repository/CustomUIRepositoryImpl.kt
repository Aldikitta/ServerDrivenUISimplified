package com.aldikitta.serverdrivenuisimplified.core.data.repository

import com.aldikitta.serverdrivenuisimplified.core.data.model.CustomUIModel
import com.aldikitta.serverdrivenuisimplified.core.remote.NetworkApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CustomUIRepositoryImpl(
    private val networkApi: NetworkApi
): CustomUIRepository {

    override fun getCustomUI(): Flow<CustomUIModel> = flow {
        while (true){
            val customUI = networkApi.fetchCustomUI()
            emit(customUI)
            delay(500L)
        }
    }
}