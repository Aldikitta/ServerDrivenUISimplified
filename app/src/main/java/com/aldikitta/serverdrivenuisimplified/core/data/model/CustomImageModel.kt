package com.aldikitta.serverdrivenuisimplified.core.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomImageModel(
    @SerialName("logo-url")
    val logoUrl: String
)