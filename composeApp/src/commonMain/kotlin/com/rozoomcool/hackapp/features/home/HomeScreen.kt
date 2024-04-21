package com.rozoomcool.hackapp.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.AssistChip
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.rozoomcool.hackapp.core.data.model.Faculty
import com.rozoomcool.hackapp.core.ui.components.NetworkImage
import com.rozoomcool.hackapp.features.university.UniversityScreen
import compose.icons.Octicons
import compose.icons.octicons.Search24
import io.github.aakira.napier.log

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
        uiState.universities.forEachIndexed { index, university ->
            log(tag = "_HOMESCREEN_") {
                university.avatar.apply {
                    replace(
                        "localhost",
                        "192.168.1.113"
                    )
                }
            }
            Card(
                modifier = Modifier.fillMaxWidth()
                    .pointerInput(true) {
                        this.detectTapGestures {
                            navigator.push(UniversityScreen(university.id))
                        }
                    }) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(146.dp)
                            .background(colorScheme.primary)
                    ) {
                        NetworkImage(
                            modifier = Modifier.fillMaxWidth(),
                            imageUrl = university.avatar.apply {
                                replace(
                                    "localhost",
                                    "192.168.1.113"
                                )
                            },
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth
                        )
                    }
                    Column(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(university.name, style = typography.titleMedium)
                        Spacer(Modifier.height(2.dp))
                        Text(university.location, style = typography.bodyLarge)
                        Spacer(Modifier.height(2.dp))
                        Text(university.description, style = typography.bodySmall, maxLines = 4, overflow = TextOverflow.Ellipsis)
//                        FlowRowFaculties(university.faculties)
                        Spacer(Modifier.height(8.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        Spacer(modifier = Modifier.height(86.dp))
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FlowRowFaculties(faculties: List<Faculty>) {
    FlowRow(modifier = Modifier.padding(8.dp)) {
        faculties.forEach {
            AssistChip(onClick = {}, label = { Text(it.name, style = typography.labelSmall) })
        }
    }
}

@Composable
private fun FacultyItem(name: String) {
    Box(modifier = Modifier.padding(4.dp)) {
        Text(name, style = typography.labelLarge)
    }
}
