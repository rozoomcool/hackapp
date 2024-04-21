package com.rozoomcool.hackapp.core.ui.components

import androidx.compose.runtime.Composable
import com.rozoomcool.hackapp.core.data.model.Panorama

@Composable
internal expect fun __Panorama(imageName: String? = null)

@Composable
internal fun Panorama() {
    __Panorama()
}