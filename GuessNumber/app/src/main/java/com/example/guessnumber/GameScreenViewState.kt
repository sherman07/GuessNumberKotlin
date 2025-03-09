package com.example.guessnumber

import androidx.compose.runtime.mutableStateOf

class GameScreenViewState (
    val isDisplayWin: Boolean,
    val isDisplayWrong: Boolean,
    val checkResult: () -> Unit,
    val onValueChange: (String) -> Unit,
    val inputData: String,
    val randomNum: Int,


){

    val binding = mutableStateOf(
        GameScreenViewBinding(
            randomNumber = randomNum,
            isDisplayWin = isDisplayWin,
            numberRangeMessage = "Please input a number between 1 and 10",
            checkResult = checkResult,
            onValueChange = onValueChange,
            inputData = inputData,
            isDisplayWrong = isDisplayWrong,
            onCheckResultMessage = checkResult


        )
    )

    fun resultUpdate(
        isDisplayWin: Boolean,
        numberRangeMessage: String
    ){
        binding.value = binding.value.copy(
            isDisplayWin = isDisplayWin,
            numberRangeMessage = numberRangeMessage
        )
    }
}