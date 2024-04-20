package com.rozoomcool.hackapp.features.main

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.rozoomcool.hackapp.features.add.AddContentScreen
import com.rozoomcool.hackapp.features.auth.AuthTab
import com.rozoomcool.hackapp.features.home.HomeTab
import compose.icons.Octicons
import compose.icons.octicons.PlusCircle24

object MainScreen : Screen {
    @Composable
    override fun Content() {
        TabNavigator(HomeTab) {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val bottomSheetNavigator = LocalBottomSheetNavigator.current

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = colors.background,
                contentColor = colors.onBackground,
                title = { Text("Dekit") },
                actions = {
                }
            )
        },
        bottomBar = {

            BottomNavigation {
                TabNavigationItem(HomeTab)
                BottomNavigationItem(
                    selected = false,
                    onClick = { bottomSheetNavigator.show(AddContentScreen()) },
                    icon = { Icon(Octicons.PlusCircle24, "ADD") }
                )
                TabNavigationItem(AuthTab)
            }
        }
    ) {

        CurrentTab()
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(tab.options.icon!!, tab.options.title) }
    )
}

// { Icon(painter = tab.icon, contentDescription = tab.title) }