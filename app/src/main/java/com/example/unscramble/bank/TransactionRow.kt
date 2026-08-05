package com.example.unscramble.bank

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TransactionRow(transaction: Transaction) {
    val rupeeFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left icon circle (stand-in for the UPI/Others logo)
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(0xFFF0F0F0)),
            contentAlignment = Alignment.Center
        ) {
            val icon = if (transaction.subtitle == "Others") {
                Icons.Default.ArrowOutward
            } else {
                Icons.Default.SwapHoriz
            }
            Icon(
                imageVector = icon,
                contentDescription = transaction.subtitle,
                tint = if (transaction.subtitle == "Others") Color.Red else Color(0xFF6A1B9A)
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Middle: title, subtitle, date
        Column(modifier = Modifier.weight(1f)) {
            Text(transaction.title, fontWeight = FontWeight.Medium, fontSize = 15.sp)
            Text(transaction.subtitle, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(transaction.date, fontSize = 12.sp, color = Color.Gray)
        }

        // Right: amount + sign icon, balance below
        Column(horizontalAlignment = Alignment.End) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = rupeeFormat.format(transaction.amount),
                    color = if (transaction.isCredit) Color(0xFF2E7D32) else Color(0xFFD32F2F),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = if (transaction.isCredit) Icons.Default.AddCircle else Icons.Default.RemoveCircle,
                    contentDescription = if (transaction.isCredit) "Credit" else "Debit",
                    tint = if (transaction.isCredit) Color(0xFF2E7D32) else Color(0xFFD32F2F),
                    modifier = Modifier.size(18.dp)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Balance: ${rupeeFormat.format(transaction.balanceAfter)}",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}