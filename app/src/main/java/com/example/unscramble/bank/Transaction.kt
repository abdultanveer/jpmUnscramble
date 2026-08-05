package com.example.unscramble.bank

data class Transaction(
    val id: Int,
    val title: String,          // "Fund Transfer" or "Others"
    val subtitle: String,       // "UPI", "Others", "Within SBI"
    val date: String,           // "03/03/2023"
    val amount: Double,
    val isCredit: Boolean,      // true = green (+), false = red (-)
    val balanceAfter: Double
)