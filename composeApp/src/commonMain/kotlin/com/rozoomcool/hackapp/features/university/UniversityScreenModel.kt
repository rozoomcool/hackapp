package com.rozoomcool.hackapp.features.university

import cafe.adriel.voyager.core.model.StateScreenModel


data class UniversityUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val authState: String = "",
)

class UniversityScreenModel(): StateScreenModel<UniversityScreenModel>(UniversityScreenModel()) {
    val uiState = UniversityUiState()
}