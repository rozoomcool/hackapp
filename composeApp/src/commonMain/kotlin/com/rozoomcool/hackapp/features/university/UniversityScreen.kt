package com.rozoomcool.hackapp.features.university

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.rozoomcool.hackapp.core.data.model.Faculty
import com.rozoomcool.hackapp.core.data.model.University
import com.rozoomcool.hackapp.core.ui.components.NetworkImage
import compose.icons.Octicons
import compose.icons.octicons.Location16
import compose.icons.octicons.Location24

data class UniversityScreen(
    val id: Long
) : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<UniversityScreenModel>()
        screenModel.getUniversity(id)
        UniversityScreenContent(screenModel)
    }

}

@Composable
fun UniversityScreenContent(
    screenModel: UniversityScreenModel
) {
    val uiState by screenModel.state.collectAsState()
    val navigator = LocalNavigator.currentOrThrow

    uiState.university?.let { university ->

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NetworkImage(
                modifier = Modifier.fillMaxWidth().height(96.dp),
                imageUrl = "https://i.ytimg.com/vi/6RHNpdjquPE/maxresdefault.jpg",
                contentScale = ContentScale.FillWidth,
                contentDescription = null
            )
            Column(
                modifier = Modifier.fillMaxSize().padding(vertical = 6.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text("  ${university.name}", style = typography.titleLarge)
                Spacer(Modifier.height(4.dp))
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Octicons.Location16, null)
                    Spacer(Modifier.width(2.dp))
                    Text(university.location, style = typography.bodyLarge)
                }
                Spacer(Modifier.height(4.dp))
                Text("  ${university.description}", style = typography.bodyMedium)

                Row(

                ) {

                }
            }
        }
    }
}

@Composable
fun Faculties(faculties: List<Faculty>) {

}

