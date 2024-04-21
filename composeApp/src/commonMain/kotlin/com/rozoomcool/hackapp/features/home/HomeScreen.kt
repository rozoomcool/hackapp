package com.rozoomcool.hackapp.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.dokar.sonner.rememberToasterState
import com.rozoomcool.hackapp.core.preferences.AuthState
import com.rozoomcool.hackapp.core.ui.components.NetworkImage
import com.rozoomcool.hackapp.features.auth.AuthTab
import com.rozoomcool.hackapp.features.university.UniversityScreen
import compose.icons.Octicons
import compose.icons.octicons.Home24
import compose.icons.octicons.Search24
import io.github.aakira.napier.log
import kotlinx.coroutines.delay

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
    val navigator = LocalNavigator.currentOrThrow
    val sc = rememberCoroutineScope()
    val uiState by screenModel.state.collectAsState()

    LaunchedEffect(key1 = true) {

    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            label = { Text("Поиск") },
            value = "",
            onValueChange = {},
            trailingIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(Octicons.Search24, null)
                }
            },
            colors = OutlinedTextFieldDefaults.colors(),
            shape = RoundedCornerShape(16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        uiState.universities.forEachIndexed {index, university ->
            Card(
                modifier = Modifier.fillMaxWidth()
                    .pointerInput(true) {
                        this.detectTapGestures {
                            navigator.push(UniversityScreen)
                        }
                    }) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(100.dp).background(colorScheme.primary)
                    ) {
                        NetworkImage(
                            modifier = Modifier.fillMaxWidth(),
                            imageUrl = university.avatar,
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )
                    }
                    Column(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(university.name, style = typography.body1)
                        Text(university.location)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(86.dp))
    }

}
