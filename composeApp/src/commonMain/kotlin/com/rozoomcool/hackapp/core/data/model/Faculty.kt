package com.rozoomcool.hackapp.core.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Faculty(
    val id: Long,
    val name: String,
    val description: String,
//    val university: Long,
)