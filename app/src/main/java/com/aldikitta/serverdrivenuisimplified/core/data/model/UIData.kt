package com.aldikitta.serverdrivenuisimplified.core.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UIData(
    @SerialName("hint")
    val hint: String,
    @SerialName("key")
    val key: String,
    @SerialName("uitype")
    val uitype: String,
    @SerialName("value")
    val value: String
)
