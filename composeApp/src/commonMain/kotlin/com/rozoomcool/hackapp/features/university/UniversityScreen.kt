package com.rozoomcool.hackapp.features.university

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.rozoomcool.hackapp.features.home.HomeScreenModel

object UniversityScreen: Screen {
    @Composable
    override fun Content() {
//        val screenModel = getScreenModel<UniversityScreenModel>()
        UniversityScreenContent()
    }

}

@Composable
fun UniversityScreenContent(
//    screenModel: UniversityScreenModel
) {
    val navigator = LocalNavigator.currentOrThrow
    Button({navigator.pop()}){
        Text("university")
    }
}