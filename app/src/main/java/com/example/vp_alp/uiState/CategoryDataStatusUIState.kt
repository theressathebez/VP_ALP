package com.example.vp_alp.uiState

import com.example.vp_alp.model.Category

sealed interface CategoryDataStatusUIState {
    data class Success(val category: List<Category>): CategoryDataStatusUIState
    object Start: CategoryDataStatusUIState
    object Loading: CategoryDataStatusUIState
    data class Failed(val errorMessage:String): CategoryDataStatusUIState
}