package com.rozoomcool.hackapp.features.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

object AddContentScreen: Screen {
    @Composable
    override fun Content() {
        AddContent()
    }

}

@Composable
fun AddContent() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button({}) {
            Text("Добавить пост")
        }
        Button({}) {
            Text("Добавить пост")
        }
        Button({}) {
            Text("Добавить пост")
        }
    }
}