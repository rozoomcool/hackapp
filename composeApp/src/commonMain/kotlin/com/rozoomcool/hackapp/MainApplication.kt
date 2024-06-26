package com.rozoomcool.hackapp

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import com.rozoomcool.hackapp.core.preferences.AuthRepository
import com.rozoomcool.hackapp.navigation.homeScreenModule
import com.rozoomcool.hackapp.features.splash.SplashScreen
import com.rozoomcool.hackapp.core.ui.themes.AppTheme
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
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

        ScreenRegistry {
            homeScreenModule()
        }

        BottomSheetNavigator(
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            Navigator(SplashScreen)
        }
    }
}