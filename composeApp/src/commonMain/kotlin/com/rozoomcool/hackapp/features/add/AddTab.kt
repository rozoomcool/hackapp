package com.rozoomcool.hackapp.features.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import compose.icons.Octicons
import compose.icons.octicons.Person24
import compose.icons.octicons.PlusCircle24

class AddContentScreen: Screen {
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