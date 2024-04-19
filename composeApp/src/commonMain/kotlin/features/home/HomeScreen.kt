package com.rozoomcool.hackapp.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.rozoomcool.hackapp.core.ui.components.AppBar

object HomeScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<HomeScreenModel>()
        HomeScreenContent(screenModel)
    }
}

@Composable
fun HomeScreenContent(
    screenModel: HomeScreenModel
) {
    val state by screenModel.uiState.collectAsState()
    Scaffold(
        topBar = { AppBar(title = "Shared Preferences") },
    ) {
        Box(
            modifier = Modifier.fillMaxSize().padding(it),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Counter value", style = MaterialTheme.typography.h3)
                Text("${state.data}", style = MaterialTheme.typography.h3)
                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(enabled = state.data > 0, onClick = { screenModel.desc() }) {
                        Icon(Icons.Default.Refresh, contentDescription = null)
                    }
                    Button(onClick = { screenModel.inc() }) {
                        Icon(Icons.Default.Add, contentDescription = null)
                    }
                }
            }
        }
    }
}
