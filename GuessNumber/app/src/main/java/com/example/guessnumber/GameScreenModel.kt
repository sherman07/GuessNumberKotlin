package com.example.guessnumber

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameScreenModel: ViewModel() {


        val state = GameScreenViewState(
            randomNum = getRandomNumberCorrect(),
            isDisplayWin = false,
            isDisplayWrong = false,
            inputData = "",
            onValueChange = ::onValueChange,
            checkResult = :: checkResult,

    )




    private fun getRandomNumberCorrect() = (1..10).random()

    private fun onValueChange(newInput: String) {
        if (newInput.all { letter -> letter.isDigit()} && newInput .length <= 2){
            state.binding.value = state.binding.value.copy(
                inputData = newInput,
                isDisplayWin = false,
                isDisplayWrong = false
            )
        }
    }

    private fun checkResult() {
        if(state.binding.value.inputData.isEmpty()) return
        val inputNumber = Integer.parseInt(state.binding.value.inputData)
        val targetNumber = state.binding.value.randomNumber
        val isDisplayWin = inputNumber == targetNumber
        state.resultUpdate(isDisplayWin, if(isDisplayWin) "You got it" else "You failed", ::getRandomNumberCorrect)

    }
}