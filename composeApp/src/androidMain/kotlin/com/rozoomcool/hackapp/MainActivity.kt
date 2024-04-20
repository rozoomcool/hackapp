package com.rozoomcool.hackapp

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.preference.PreferenceManager
import com.rozoomcool.hackapp.com.rozoomcool.hackapp.App
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.dsl.module

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            window.statusBarColor = Color(0xFF358c96).toArgb()
            window.navigationBarColor = Color(0xFF358c96).toArgb()
            window.navigationBarDividerColor = Color(0xFF358c96).toArgb()
//            window.color

            Napier.base(DebugAntilog())
            val preferences = PreferenceManager.getDefaultSharedPreferences(LocalContext.current)
            App(androidPlatformModules(preferences))
        }
    }
}

fun androidModule(sharedPref: SharedPreferences) = module {
    single<Settings> {
        SharedPreferencesSettings(sharedPref)
    }
}

fun androidPlatformModules(sharedPref: SharedPreferences) = listOf(androidModule(sharedPref))

