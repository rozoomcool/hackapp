package com.rozoomcool.hackapp.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.screenModule
import com.rozoomcool.hackapp.features.add.AddContentScreen
import com.rozoomcool.hackapp.features.home.HomeScreen
import com.rozoomcool.hackapp.features.university.UniversityScreen

sealed class AppSharedScreen: ScreenProvider {
    data object Home : AppSharedScreen()
    data object Auth: AppSharedScreen()
    data object AddContent: AppSharedScreen()
    data class University(val id: Long) : AppSharedScreen()
}

val homeScreenModule = screenModule {
    register<AppSharedScreen.University> { provider ->
        UniversityScreen(provider.id)
    }
    register<AppSharedScreen.Home> {
        HomeScreen
    }
    register<AppSharedScreen.AddContent> {
        AddContentScreen
    }
}