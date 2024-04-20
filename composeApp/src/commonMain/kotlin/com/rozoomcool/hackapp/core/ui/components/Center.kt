package com.rozoomcool.hackapp.core.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
private fun Center(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun LoadingIndicator() {
    Center {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(message: String) {
    Center { Text(message) }
}