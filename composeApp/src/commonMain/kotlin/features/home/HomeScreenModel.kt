package com.rozoomcool.hackapp.features.home

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.rozoomcool.hackapp.core.preferences.AuthRepository
import com.rozoomcool.hackapp.core.preferences.AuthState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


data class HomeUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val authState: String = AuthState.AUTHORIZED.name,
)

class HomeScreenModel(
    private val authRepository: AuthRepository,
) : StateScreenModel<HomeUiState>(HomeUiState()) {

    val uiState = authRepository.authState.map { HomeUiState(authState = it) }.stateIn(
        scope = screenModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = HomeUiState(),
    )

    fun signIn() = authRepository.signIn()

    fun signOut() = authRepository.signOut()
}
