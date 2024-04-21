package com.rozoomcool.hackapp.features.university

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.rozoomcool.hackapp.core.data.model.University
import com.rozoomcool.hackapp.core.network.repository.UniversityRepository
import kotlinx.coroutines.launch


data class UniversityUiState(
    val university: University?
)

class UniversityScreenModel(
    private val id: Long? = null,
    private val universityRepository: UniversityRepository
) : StateScreenModel<UniversityUiState>(UniversityUiState(null)) {

    init {
        id?.let {
            screenModelScope.launch {
                mutableState.value =
                    state.value.copy(university = universityRepository.getUniversity(it))
            }
        }
    }

    fun getUniversity(id: Long) {
        screenModelScope.launch {
            mutableState.value =
                state.value.copy(university = universityRepository.getUniversity(id))
        }
    }

}