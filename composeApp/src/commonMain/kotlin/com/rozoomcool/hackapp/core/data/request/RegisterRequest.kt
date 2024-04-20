package com.rozoomcool.hackapp.core.data.request

import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String,
    val password2: String,
)