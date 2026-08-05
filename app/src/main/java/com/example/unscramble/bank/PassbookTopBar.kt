package com.example.unscramble.bank

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassbookTopBar(accountNumber: String) {
    CenterAlignedTopAppBar(
        title = { Text("mPassbook - A/c No. $accountNumber") },
        navigationIcon = {
            IconButton(onClick = { /* handle back press */ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF6A1B9A), // purple like YONO header
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        )
    )
}