package com.rozoomcool.hackapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.rozoomcool.hackapp.core.preferences.AuthRepository
import com.rozoomcool.hackapp.core.preferences.AuthState
import com.rozoomcool.hackapp.features.auth.AuthScreen
import com.rozoomcool.hackapp.features.home.HomeScreen
import com.rozoomcool.hackapp.features.splash.SplashScreen
import com.santimattius.kmp.hackatonapp.core.ui.themes.AppTheme
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.compose.koinInject



@Composable
fun MainApplication() {
    AppTheme {
        val coroutineScope = rememberCoroutineScope()
        val authRepository: AuthRepository = koinInject()
        val authState = authRepository.authState.stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ""
        )
        Napier.v("::::::::${authState.value}")

        val auth = authRepository.authState.collectAsState(coroutineScope)
        val startScreen = when(auth.value) {
            AuthState.AUTHORIZED.name -> {
                HomeScreen
            }
            AuthState.NONAUTHORIZED.name -> {
                AuthScreen
            }

            else -> {HomeScreen}
        }


        Navigator(screen = SplashScreen)


    }
}