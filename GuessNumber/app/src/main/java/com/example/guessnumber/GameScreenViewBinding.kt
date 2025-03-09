package com.example.guessnumber

data class GameScreenViewBinding(
    val isDisplayWin: Boolean,
    val numberRangeMessage: String,
    val checkResult: () -> Unit,
    val onValueChange: (String) -> Unit,
    val isDisplayWrong: Boolean,
    val onCheckResultMessage: () -> Unit,


    val inputData: String,
    val randomNumber: Int
)