package com.rozoomcool.hackapp.features.auth

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.rozoomcool.hackapp.core.data.request.RegisterRequest
import com.rozoomcool.hackapp.core.network.repository.UserRepository
import com.rozoomcool.hackapp.core.preferences.AuthRepository
import io.github.aakira.napier.Napier.log
import io.github.aakira.napier.log
import kotlinx.coroutines.launch


data class AuthUiState(
    val username: String = "",
    val email: String = "",
    val password: String = ""
)

class AuthScreenModel(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
): StateScreenModel<AuthUiState>(AuthUiState()) {
    fun register() {
        screenModelScope.launch {
            val response = userRepository.register(RegisterRequest("rosul", "rosul.um@gmail.com", "rozoomcool", "rozoomcool"))
            log(tag = "sgfdg") { response.toString() }
        }
    }
}