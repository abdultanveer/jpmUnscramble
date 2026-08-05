package com.example.unscramble.bank


object DummyData {
    fun getTransactions(): List<Transaction> = listOf(
        Transaction(1, "Fund Transfer", "UPI", "03/03/2023", 1.50, false, 0.00),
        Transaction(2, "Fund Transfer", "UPI", "03/03/2023", 1.00, true, 1.50),
        Transaction(3, "Fund Transfer", "UPI", "01/02/2023", 12400.00, false, 0.50),
        Transaction(4, "Fund Transfer", "UPI", "01/02/2023", 12400.00, true, 12400.50),
        Transaction(5, "Fund Transfer", "UPI", "30/01/2023", 375.00, false, 0.50),
        Transaction(6, "Fund Transfer", "UPI", "30/01/2023", 375.00, true, 375.50),
        Transaction(7, "Others", "Others", "22/10/2022", 147.50, false, 0.50),
        Transaction(8, "Fund Transfer", "UPI", "22/10/2022", 1855.00, false, 148.00),
        Transaction(9, "Fund Transfer", "Within SBI", "22/10/2022", 2003.00, true, 2003.00)
    )
}