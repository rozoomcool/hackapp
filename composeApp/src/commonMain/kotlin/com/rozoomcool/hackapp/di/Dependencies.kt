package com.rozoomcool.hackapp.di

import com.rozoomcool.hackapp.core.preferences.AuthRepository
import com.rozoomcool.hackapp.features.auth.AuthScreenModel
import com.rozoomcool.hackapp.features.home.HomeScreenModel
import com.rozoomcool.hackapp.features.university.UniversityScreenModel
import org.koin.dsl.module

val sharedModules = module {
    single { AuthRepository(get()) }
}

val homeModule = module {
    includes(networkModule)
    factory<HomeScreenModel> { HomeScreenModel(get()) }
    factory<AuthScreenModel> { AuthScreenModel(get(), get()) }
//    factory<UniversityScreenModel> {UniversityScreenModel()}
}


fun applicationModules() = listOf(sharedModules, homeModule, networkModule)