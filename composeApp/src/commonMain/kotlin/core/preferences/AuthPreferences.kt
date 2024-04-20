package com.rozoomcool.hackapp.core.preferences

import com.russhwolf.settings.Settings
import kotlinx.coroutines.flow.Flow

enum class AuthState {
    AUTHORIZED,
    NONAUTHORIZED
}

class AuthRepository(
    settings: Settings,
) {


    private val _authState = PreferencesSettingConfig(settings, "auth", AuthState.AUTHORIZED.name)
    val authState: Flow<String> = _authState.value

    fun signIn() {
        _authState.set(AuthState.AUTHORIZED.name)
    }

    fun signOut() {
        _authState.set(AuthState.NONAUTHORIZED.name)
    }
}