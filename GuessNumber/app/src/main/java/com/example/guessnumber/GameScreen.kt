package com.example.guessnumber

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GameScreen(binding: GameScreenViewBinding) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)
            .background(Color(0xFFE2F2FF)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        var isDisplay by remember {
            mutableStateOf(false)
        }


        Spacer(modifier = Modifier.height(64.dp))

        Text(
            fontFamily = FontFamily.Cursive,
            color = Color(0xFFFF1100),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            text = "GUESS NUMBER GAME", modifier = Modifier.padding(bottom = 48.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(horizontal = 16.dp)
        ) {

            TextField(
                textStyle = TextStyle(textAlign = TextAlign.Center),
                modifier = Modifier
                    .width(250.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 32.dp),
                value = binding.inputData,
                onValueChange = { newInput ->

                                binding.onValueChange(newInput)
                },
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Enter your guess",
                        textAlign = TextAlign.Center
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                )
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp,
                text = binding.numberRangeMessage
            )

            Button(
                onClick = binding.checkResult,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Guess")

            }


        }


        if (binding.isDisplayWin) {
            Image(painter = painterResource(R.drawable.img), contentDescription = null)

        }

        if (binding.isDisplayWrong){
        Image(modifier = Modifier.padding(top = 30.dp),
                painter = painterResource(R.drawable.img_1), contentDescription = null)


    }


}
}

@Composable
fun Belts() {
    Text(
        text = "", modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(Color(0xFFE91E63))
    )
    Text(
        text = "", modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(Color(0xFFFFEB3B))
    )
    Text(
        text = "", modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(Color(0xFF2196F3))
    )
}

@Preview
@Composable
fun GameScreenPreview() {

    GameScreen(binding = GameScreenViewBinding(
        onValueChange = {},
        numberRangeMessage = "",
        randomNumber = 5,
        checkResult = {},
        inputData = "",
        isDisplayWin = true,
        isDisplayWrong = false,
        onCheckResultMessage = {}


    ))

}