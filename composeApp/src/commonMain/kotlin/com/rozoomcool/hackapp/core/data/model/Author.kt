package com.rozoomcool.hackapp.core.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val id: Long,
    val username: String,
    val email: String,
    val role: String,
    val university: University,
    val avatar: String,
)
