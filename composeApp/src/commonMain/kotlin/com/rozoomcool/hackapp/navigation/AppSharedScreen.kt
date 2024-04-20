package com.rozoomcool.hackapp.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.screenModule
import com.rozoomcool.hackapp.features.add.AddContentScreen
import com.rozoomcool.hackapp.features.auth.AuthTab
import com.rozoomcool.hackapp.features.home.HomeScreen
import com.rozoomcool.hackapp.features.home.HomeTab
import com.rozoomcool.hackapp.features.university.UniversityScreen

sealed class AppSharedScreen: ScreenProvider {
    data object Home : AppSharedScreen()
    data object Auth: AppSharedScreen()
    data object AddContent: AppSharedScreen()
    data class University(val id: String) : AppSharedScreen()
}

val homeScreenModule = screenModule {
    register<AppSharedScreen.University> { provider ->
        UniversityScreen
    }
    register<AppSharedScreen.Home> {
        HomeScreen
    }
    register<AppSharedScreen.AddContent> {
        AddContentScreen
    }
}