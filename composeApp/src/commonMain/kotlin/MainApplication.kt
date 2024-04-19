package com.rozoomcool.hackapp

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.rozoomcool.hackapp.features.splash.SplashScreen
import com.santimattius.kmp.hackatonapp.core.ui.themes.AppTheme

@Composable
fun MainApplication() {
    AppTheme {
        Navigator(SplashScreen)
    }
}