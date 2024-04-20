package com.rozoomcool.hackapp.features.auth

import cafe.adriel.voyager.core.model.StateScreenModel
import com.rozoomcool.hackapp.core.preferences.AuthRepository


data class AuthUiState(
    val username: String = "",
    val email: String = "",
    val password: String = ""
)

class AuthScreenModel(
    private val authRepository: AuthRepository
): StateScreenModel<AuthUiState>(AuthUiState()) {

}