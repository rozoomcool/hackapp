package com.rozoomcool.hackapp.core.data.request

import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    val username: String,
    val email: String
)