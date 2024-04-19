package com.rozoomcool.hackapp.di

import com.rozoomcool.hackapp.core.data.SettingsRepository
import com.rozoomcool.hackapp.features.home.HomeScreenModel
import org.koin.dsl.module

val sharedModules = module {
    single { SettingsRepository(get()) }
}

val homeModule = module {
    factory<HomeScreenModel> { HomeScreenModel(get()) }
}


fun applicationModules() = listOf(sharedModules, homeModule)