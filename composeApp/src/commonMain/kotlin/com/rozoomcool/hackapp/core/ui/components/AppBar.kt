package com.rozoomcool.hackapp.core.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun AppBar(
    title: String = "",
    navigationIcon: @Composable () -> Unit = { },
    containerColor: Color = MaterialTheme.colors.primary,
    titleContentColor: Color = MaterialTheme.colors.onPrimary,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = navigationIcon,
        actions = actions
    )
}
