package com.rozoomcool.hackapp.features.university

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.rozoomcool.hackapp.features.home.HomeScreenModel

object UniversityScreen: Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<UniversityScreenModel>()
        UniversityScreenContent(screenModel)

    }

}

@Composable
fun UniversityScreenContent(screenModel: UniversityScreenModel) {
Text("university")
}