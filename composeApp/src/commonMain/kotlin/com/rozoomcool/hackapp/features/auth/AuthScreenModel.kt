package com.rozoomcool.hackapp.features.auth

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.rozoomcool.hackapp.core.data.request.RegisterRequest
import com.rozoomcool.hackapp.core.network.repository.UserRepository
import com.rozoomcool.hackapp.core.preferences.AuthRepository
import io.github.aakira.napier.log
import kotlinx.coroutines.launch


data class AuthUiState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val isUsernameError: Boolean = false,
    val isEmailError: Boolean = false,
    val isPasswordError: Boolean = false
)

class AuthScreenModel(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : StateScreenModel<AuthUiState>(AuthUiState()) {

    fun changeUsername(username: String) {
        if (username.isNotEmpty() && username.length <= 16 && username.length >= 5) {
            this.mutableState.value = mutableState.value.copy(isUsernameError = false)
        } else {
            this.mutableState.value = mutableState.value.copy(isUsernameError = true)
        }
        this.mutableState.value = mutableState.value.copy(username = username)

    }

    fun changeEmail(email: String) {
        if (email.isNotEmpty() && email.length <= 191 && email.contains(Regex("([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)"))) {
            this.mutableState.value = mutableState.value.copy(isEmailError = false)
        } else {
            this.mutableState.value = mutableState.value.copy(isEmailError = true)
        }
        this.mutableState.value = mutableState.value.copy(email = email)
    }

    fun changePassword(password: String) {
        if (password.isNotEmpty() && password.length <= 16 && password.length >= 8) {
            this.mutableState.value = mutableState.value.copy(isPasswordError = false)
        } else {
            this.mutableState.value = mutableState.value.copy(isPasswordError = true)
        }
        this.mutableState.value = mutableState.value.copy(password = password)
    }

    fun signUp() {
        screenModelScope.launch {
            val response = userRepository.signUp(
                RegisterRequest(
                    state.value.username,
                    state.value.email,
                    state.value.password,
                    state.value.password
                )
            )
            log(tag = "_AUTHSCREEN_") { response.status.value.toString() }
        }
    }

    fun signIn() {
        screenModelScope.launch {
            val response = userRepository.signUp(
                RegisterRequest(
                    state.value.username,
                    state.value.email,
                    state.value.password,
                    state.value.password
                )
            )
            log(tag = "_AUTHSCREEN_") { response.status.value.toString() }
        }
    }
}