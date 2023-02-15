package com.aldikitta.serverdrivenuisimplified.core.remote

import com.aldikitta.serverdrivenuisimplified.core.data.model.CustomImageModel
import com.aldikitta.serverdrivenuisimplified.core.data.model.CustomUIModel
import retrofit2.http.GET

interface NetworkApi {

    @GET("mobileapps/android_assignment.json")
    suspend fun fetchCustomUI(): CustomUIModel

    @GET("mobileapps/android_assignment.json")
    suspend fun fetchImage(): CustomImageModel
}