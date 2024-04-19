package com.rozoomcool.hackapp.features.auth

import cafe.adriel.voyager.core.model.StateScreenModel


data class AuthUiState(
    val username: String = "",
    val email: String = "",
    val password: String = ""
)

class AuthScreenModel: StateScreenModel<AuthUiState>(AuthUiState()) {

}