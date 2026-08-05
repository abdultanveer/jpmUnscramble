package com.example.unscramble.bank

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PassbookViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PassbookUiState())
    val uiState: StateFlow<PassbookUiState> = _uiState.asStateFlow()

    init {
        loadTransactions()
    }

    private fun loadTransactions() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            delay(500) // pretend network/db call
            _uiState.update {
                it.copy(
                    transactions = DummyData.getTransactions(),
                    isLoading = false
                )
            }
        }
    }
}