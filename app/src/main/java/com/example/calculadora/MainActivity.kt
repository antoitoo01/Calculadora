package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    var numero: Double = 0.0
    var operacion: String = ""
    var num1: Double = 0.0
    var num2: Double = 0.0
    var pulsado: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {
            PantallaPrincipal();
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun PantallaPrincipal() {
        var count by remember { mutableStateOf("0") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),

            ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)

            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .weight(1f),
                ) {
                    Resultado(count)

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .background(Color.DarkGray)
            ) {

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(0.dp, 10.dp, 0.dp, 0.dp)
                    .weight(1f)

            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "1", count, isEnabled = true) { newCount: String ->
                        count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "2", count, isEnabled = true) { newCount: String ->
                        count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "3", count, isEnabled = true) { newCount: String ->
                        count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(10.dp, 0.dp)
                        .weight(1f), contentAlignment = Alignment.CenterEnd
                ) {
                    OperationButton("+", isEnabled = true) {
                            newOperacion: String ->
                        operacion = newOperacion

                    }
                }


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .weight(1f)

            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "4", count, isEnabled = true) { newCount: String ->
                        count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "5", count, isEnabled = true) { newCount: String ->
                        count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "6", count, isEnabled = true) { newCount: String ->
                        count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(10.dp, 0.dp)
                        .weight(1f), contentAlignment = Alignment.CenterEnd
                ) {
                    OperationButton("-", isEnabled = true) {
                            newOperacion: String ->
                        operacion = newOperacion

                    }
                }


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .weight(1f)

            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "7", count, isEnabled = true) { newCount: String ->
                        count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "8", count, isEnabled = true) { newCount: String ->
                        count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "9", count, isEnabled = true) { newCount: String ->
                        count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp)
                        .weight(1f), contentAlignment = Alignment.CenterEnd
                ) {
                    OperationButton("*", isEnabled = true) {
                            newOperacion: String ->
                        operacion = newOperacion

                    }
                }


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .weight(1f)

            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "0", count, isEnabled = true) { newCount: String ->
                        count = newCount


                    }

                }



                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    EqualButton("=", isEnabled = true) {
                            onKeyPresseded: String ->
                        count = onKeyPresseded

                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp)
                        .weight(1f), contentAlignment = Alignment.CenterEnd
                ) {
                    OperationButton("/", isEnabled = true) {
                            newOperacion: String ->
                        operacion = newOperacion
                    }
                }


            }

        }


    }

    @Composable
    fun OperationButton(tipoOperacion: String, isEnabled: Boolean, newOperacion: (String) -> Unit) {
        Button(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(Color.Magenta),
            enabled = isEnabled,
            onClick = {
                operacion = tipoOperacion
                newOperacion(operacion)
                pulsado = true;}) {
            Text(text = tipoOperacion)

        }
    }

    @Composable
    fun EqualButton(tipoOperacion: String, isEnabled: Boolean, onKeyPresseded: (String) -> Unit) {
        Button(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            enabled = isEnabled,
            onClick = {

                when (tipoOperacion) {
                    "+" -> numero = num1 + num2
                    "-" -> numero = num1 - num2
                    "*" -> numero = num1 / num2
                    "/" -> numero = num1 * num2
                    else -> { // Note the block
                        println("Error")
                    }
                }

                onKeyPresseded(numero.toString())
                pulsado = false}) {
            Text(text = tipoOperacion)

        }
    }

    @Composable
    fun NumButton(
        num: String,
        count: String,
        isEnabled: Boolean,
        onCountChanged: (String) -> Unit
    ) {
        var localCount by remember { mutableStateOf(count) }
        Button(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            enabled = isEnabled,
            colors = ButtonDefaults.buttonColors(Color.Blue),
            onClick = {
                if (pulsado == false) {
                    if (num1.equals(0.0)) {
                        num1 = num.toDouble()
                    } else {
                        num1 *= 10.0
                        num1 += num.toDouble()
                    }
                    localCount = num1.toString()

                } else {
                    if (num2.equals(0.0)) {
                        num2 = num.toDouble()
                    } else {
                        num2 *= 10.0
                        num2 += num.toDouble()
                    }
                    localCount = num2.toString()
                }
                onCountChanged(localCount)

            }) {
            Text(text = num)
        }
    }

    @Composable
    fun Resultado(numero: String) {
        Text(
            text = numero, Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 40.sp,
                shadow = Shadow(
                    color = Color.Blue,
                    blurRadius = 3f
                )
            ),
            textAlign = TextAlign.End,
        )
    }
}