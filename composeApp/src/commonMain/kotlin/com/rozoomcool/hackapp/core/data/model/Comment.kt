package com.rozoomcool.hackapp.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val id: Long,
    val post: Long,
    val author: Author,
    val content: String,
    @SerialName("created_at")
    val createdAt: String,
)