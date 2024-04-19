package com.rozoomcool.hackapp

import androidx.compose.runtime.Composable
import com.rozoomcool.hackapp.di.applicationModules
import org.koin.compose.KoinApplication
import org.koin.core.module.Module

@Composable
fun App(platformModules: List<Module> = emptyList()) {
    KoinApplication(moduleList = { applicationModules() + platformModules }) {
        MainApplication()
    }
}