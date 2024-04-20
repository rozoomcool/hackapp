package com.rozoomcool.hackapp.features.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import compose.icons.Octicons
import compose.icons.octicons.Home24

object HomeTab : Tab {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Navigator(HomeScreen)
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = "HOME"
            val icon = rememberVectorPainter(Octicons.Home24)

            return remember {
                TabOptions(
                    index = 0u,
                    title = "HOME",
                    icon = icon
                )
            }
        }
}