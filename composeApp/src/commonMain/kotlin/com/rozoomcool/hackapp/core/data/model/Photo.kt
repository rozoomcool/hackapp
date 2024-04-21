package com.rozoomcool.hackapp.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val id: Long,
    val image: String,
    @SerialName("uploaded_at")
    val uploadedAt: String,
    val post: Long,
)