package com.rozoomcool.hackapp.features.home

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.rozoomcool.hackapp.core.data.model.University
import com.rozoomcool.hackapp.core.network.repository.UniversityRepository
import kotlinx.coroutines.launch


data class HomeUiState(
    val universities: List<University> = emptyList()
)

class HomeScreenModel(
    private val universityRepository: UniversityRepository,
) : StateScreenModel<HomeUiState>(HomeUiState()) {

    init {
        screenModelScope.launch {
            mutableState.value = state.value.copy(universities = universityRepository.getUniversities())
        }
    }

}


//val uiState = authRepository.authState.map { HomeUiState(authState = it) }.stateIn(
//    scope = screenModelScope,
//    started = SharingStarted.WhileSubscribed(5_000),
//    initialValue = HomeUiState(),
//)
