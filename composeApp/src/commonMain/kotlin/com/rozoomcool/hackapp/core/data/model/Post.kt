package com.rozoomcool.hackapp.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Long,
    val photos: List<Photo>,
    val comments: List<Comment>,
    @SerialName("like_count")
    val likeCount: Long,
    val title: String,
    val content: String,
    @SerialName("created_at")
    val createdAt: String,
    val university: Long,
    val author: Long,
)
