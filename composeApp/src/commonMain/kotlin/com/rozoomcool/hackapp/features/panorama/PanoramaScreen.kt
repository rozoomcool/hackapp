package com.rozoomcool.hackapp.features.panorama

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.rozoomcool.hackapp.core.ui.components.Panorama

object PanoramaScreen: Screen {
    @Composable
    override fun Content() {
        PanoramaContent()
    }
}

@Composable
fun PanoramaContent() {
    Panorama()
}