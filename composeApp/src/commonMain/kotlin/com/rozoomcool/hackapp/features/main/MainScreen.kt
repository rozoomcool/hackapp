package com.rozoomcool.hackapp.features.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
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
        TabNavigator(
            HomeTab,
            tabDisposable = {
                TabDisposable(
                    navigator = it,
                    tabs = listOf(HomeTab, AuthTab)
                )
            }
        ) {
            MainScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val bottomSheetNavigator = LocalBottomSheetNavigator.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dekit") },
                actions = {
                }
            )
        },
        bottomBar = {
            NavigationBar {
                TabNavigationItem(HomeTab)
                NavigationBarItem(
                    selected = false,
                    onClick = { bottomSheetNavigator.show(AddContentScreen) },
                    icon = { Icon(Octicons.PlusCircle24, "ADD") }
                )
                TabNavigationItem(AuthTab)
            }
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(it)
        ) { CurrentTab() }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(tab.options.icon!!, tab.options.title) }
    )
}