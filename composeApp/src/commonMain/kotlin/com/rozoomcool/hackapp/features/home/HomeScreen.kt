package com.rozoomcool.hackapp.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.rozoomcool.hackapp.core.preferences.AuthState
import com.rozoomcool.hackapp.core.ui.components.NetworkImage
import com.rozoomcool.hackapp.features.auth.AuthTab
import com.rozoomcool.hackapp.features.university.UniversityScreen
import compose.icons.Octicons
import compose.icons.octicons.Home24
import io.github.aakira.napier.log

object HomeScreen: Screen {
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
    val navigator = LocalNavigator.currentOrThrow
    val sc = rememberCoroutineScope()
    val state by screenModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        log(tag = ":::::::::::::") { "$state" }
        if (state.authState == AuthState.NONAUTHORIZED.name) {
            navigator.replaceAll(AuthTab)
        }
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp).verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            label = { Text("Поиск") },
            value = "",
            onValueChange = {},
            trailingIcon = {
                IconButton({}) {
                    Icon(Icons.Default.Search, null)
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = colors.background),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        repeat(10) {
            Card(
                modifier = Modifier.fillMaxWidth()
                    .pointerInput(true){
                        this.detectTapGestures {
                            navigator.replace(UniversityScreen)
                        }
                    }) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(86.dp).background(colors.primary)
                    ) {
                        NetworkImage(
                            modifier = Modifier.fillMaxWidth(),
                            imageUrl = "https://ytimg.googleusercontent.com/vi/w6bUhUuio5M/maxresdefault.jpg",
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth
                        )
                    }
                    Column(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text("Чеченский Государственный университет")
                        Text("г. Грозный")
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(86.dp))
    }

}
