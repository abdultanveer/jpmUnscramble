package com.example.unscramble.bank

data class PassbookUiState(
    val accountNumber: String = "XXXXXX2331",
    val transactions: List<Transaction> = emptyList(),
    val isLoading: Boolean = false
)