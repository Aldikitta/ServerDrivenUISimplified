package com.aldikitta.serverdrivenuisimplified.core.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomUIModel(
    @SerialName("heading-text")
    val headingText: String,
    @SerialName("logo-url")
    val logoUrl: String,
    @SerialName("uidata")
    val uidata: List<UIData>
)