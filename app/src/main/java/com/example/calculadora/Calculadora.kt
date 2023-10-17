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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import kotlin.math.pow

//Con ViewModel, puedo acceder a esta variable mutable desde mi programa entero.
class CalculadoraViewModel : ViewModel() {
    var count by mutableStateOf("0.0")
}

/*
    Esta clase sólo es para tener válido el preview ya que CalculadoraView Model de tipo ViewModel(),
    no es un parámetro normal.
* */
class SampleUserProvider : PreviewParameterProvider<CalculadoraViewModel> {
    override val values = sequenceOf(CalculadoraViewModel())
}

class Calculadora : ComponentActivity() {

    private var numero: Double = 0.0
    private var operacion: String = ""
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var pulsado: Boolean = false
    private var comillado: Boolean = false
    private var igualado: Boolean = false
    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = CalculadoraViewModel()
            PantallaPrincipal(viewModel)
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun PantallaPrincipal(@PreviewParameter(SampleUserProvider::class) viewModel: CalculadoraViewModel) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),

            ) {
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .padding(15.dp)


            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .weight(1f),
                ) {
                    Resultado(viewModel.count)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.DarkGray)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .weight(1f)
                )
                {
                    BorrarTodo() { newCount: String -> viewModel.count = newCount }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .weight(1f), contentAlignment = Alignment.CenterEnd
                ) {
                    BorrarDigito(total = viewModel.count) { newCount: String ->
                        viewModel.count = newCount
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .weight(1f)
                    .padding(0.dp, 20.dp, 0.dp, 0.dp),
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.BottomCenter
                ) {
                    NumButton(num = "1", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "2", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "3", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(10.dp, 0.dp)
                        .weight(1f), contentAlignment = Alignment.CenterEnd
                ) {
                    OperationButton("+", viewModel, isEnabled = true) { newOperacion: String ->
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
                    NumButton(num = "4", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "5", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "6", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(10.dp, 0.dp)
                        .weight(1f), contentAlignment = Alignment.CenterEnd
                ) {
                    OperationButton("-", viewModel, isEnabled = true) { newOperacion: String ->
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
                    NumButton(num = "7", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "8", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = "9", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp)
                        .weight(1f), contentAlignment = Alignment.CenterEnd
                ) {

                    OperationButton("x", viewModel, isEnabled = true) { newOperacion: String ->
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
                    NumButton(num = "0", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    NumButton(num = ",", viewModel, isEnabled = true) { newCount: String ->
                        viewModel.count = newCount
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    EqualButton("=", isEnabled = true, viewModel) { onKeyPresseded: String ->
                        viewModel.count = onKeyPresseded
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp)
                        .weight(1f), contentAlignment = Alignment.CenterEnd
                ) {
                    OperationButton("/", viewModel, isEnabled = true) { newOperacion: String ->
                        actualizarCount(viewModel)
                    }
                }
            }
        }
    }

    //Función para hacer que las operaciones puedan ser concatenadas
    private fun actualizarCount(vmCount: CalculadoraViewModel) {
        if (this.pulsado == false) { // Verifica si se ha pulsado ya un OperationButton
            this.operacion = "/"
        } else {
            calcular(vmCount)
        }
    }

    @Composable
    private fun BorrarTodo(newCount: (String) -> Unit) {
        Button(
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(Color(R.color.Orange)),
            onClick = {
                reiniciarVariables()
                newCount("0.0")
            }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Eliminar Todo",
                modifier = Modifier.fillMaxSize(1F)
            )
        }
    }

    @Composable
    private fun BorrarDigito(total: String, newCount: (String) -> Unit) {
        var localCount by remember { mutableStateOf(total) }
        Button(
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(Color(R.color.LightOrange)),
            onClick = {
                if (total.isEmpty() || total.isBlank() || total.length == 1 || total.equals("Infinito")) {
                    localCount = "0"
                } else {
                    localCount = total
                    if ((localCount.equals("0") || localCount.equals("-0"))
                        || (total.equals("0") || total.equals("-0"))
                    ) {
                        localCount = "0"
                    } else if (localCount[0] == ',') {
                        localCount = total.dropLast(1)
                        comillado = false
                    } else {
                        localCount = total.dropLast(1)
                    }
                }
                if (pulsado == false) {
                    num1 = localCount.toDouble()
                } else {
                    num2 = localCount.toDouble()
                }
                newCount(localCount)
            }) {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Eliminar",
                modifier = Modifier.fillMaxSize(1F)
            )
        }
    }

    @Composable
    fun OperationButton(
        tipoOperacion: String,
        viewModel: CalculadoraViewModel,
        isEnabled: Boolean,
        newOperacion: (String) -> Unit
    ) {
        var localCount by remember { mutableStateOf(numero) }
        Button(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            enabled = isEnabled,
            onClick = {
                if (pulsado == true) {
                    calcular(viewModel)
                    numero = localCount
                }

                operacion = tipoOperacion
                newOperacion(operacion)

                contador = 0
                comillado = false
                pulsado = true
            }) {
            Text(text = tipoOperacion, fontSize = 25.sp)

        }
    }

    //Esta función auxiliar nos calcula num1 (operacion) num2
    private fun calcular(viewModel: CalculadoraViewModel) {
        var correcto = true
        if (pulsado == false) {
            if (num1.toString().isEmpty() || num1.toString().isBlank()) {
                viewModel.count = "0.0"

            } else {
                viewModel.count = (num1.toString())
            }
        } else {
            when (operacion) {
                "+" -> numero = (num1 + num2)
                "-" -> numero = (num1 - num2)
                "x" -> numero = (num1 * num2)
                "/" -> if (num2 == 0.0 || num2.toString() == ",") {
                    correcto = false
                    reiniciarVariables()
                    viewModel.count = ("Infinito")
                } else {
                    numero = (num1 / num2)
                    viewModel.count = (numero.toString())
                }

                else -> { // Note the block
                    numero = 0.0
                    correcto = false
                    viewModel.count = ("Error")
                }
            }

            if (correcto == true) {
                num1 =
                    numero //Lo igualamos a numero por si queremos continuar realizando operaciones.
                num2 = 0.0
                contador = 0
                comillado = false
                igualado = true
                pulsado = false

                viewModel.count = (numero.toString())
            }
        }
    }

    @Composable
    fun EqualButton(
        igual: String,
        isEnabled: Boolean,
        viewModel: CalculadoraViewModel,
        onKeyPresseded: (String) -> Unit
    ) {
        Button(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            enabled = isEnabled,
            onClick = {
                calcular(viewModel)
                onKeyPresseded(viewModel.count)
            }
        ) {
            Text(text = igual, fontSize = 25.sp)

        }
    }

    private fun reiniciarVariables() {
        num1 = 0.0
        num2 = 0.0
        numero = 0.0
        pulsado = false
        comillado = false
        contador = 0
        operacion = ""
    }

    @Composable
    fun NumButton(
        num: String,
        viewModel: CalculadoraViewModel,
        isEnabled: Boolean,
        onCountChanged: (String) -> Unit
    ) {
        Button(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape),
            enabled = isEnabled,
            colors = ButtonDefaults.buttonColors(Color(R.color.lightGray)),
            onClick = {
                val maximosDecimales = 18
                var potencia :Double
                igualado = false


                if (contador < maximosDecimales) {
                    if (num.equals(",")) {
                        if (pulsado) { //Si le hemos dado antes a OperationButton, seleccionamos el num2
                            viewModel.count = num2.toString()
                        } else {
                            viewModel.count = num1.toString()
                        }
                        comillado = true
                    } else {
                        if (pulsado == false) {
                            if (comillado == true) {
                                contador++
                                var aux: Double
                                /*
                                    Transformar el número que hayamos seleccionado a su posición correspondiente
                                    mediante división entre potencias de 10.
                                 */

                                aux = num.toDouble()
                                potencia = 10.0.pow(contador)
                                aux /= potencia
                                num1 += aux // Se lo sumamos al número completo que tenemos

                                //Este fragmento sirve para eliminar unos decimales que surgen aleatoriamente.
                                var partes = num1.toString().split(".")
                                if (partes.size > 1) {
                                    //El tamaño de los numeros enteros + la coma decimal
                                    if (partes[1].length > contador) {
                                        var num1String = num1.toString()
                                        num1String = num1String.substring(
                                            0,
                                            num1String.length - (partes[1].length - contador)
                                        )
                                        num1 = num1String.toDouble()
                                    }
                                }
                            } else if (viewModel.count.equals("0.0")) {
                                num1 = num.toDouble()
                            } else {
                                num1 *= 10.0
                                num1 += num.toDouble()
                            }
                            viewModel.count = num1.toString()

                        } else {    //Lo mismo para el num2
                            if (comillado == true) {
                                contador++
                                var aux: Double


                                aux = num.toDouble()
                                potencia = 10.0.pow(contador)
                                aux /= potencia
                                num2 += aux

                                //Este fragmento sirve para eliminar unos decimales que surgen aleatoriamente.
                                var partes = num2.toString().split(".")
                                if (partes.size > 1) {

                                    if (partes[1].length > contador) {
                                        var num2String = num2.toString()
                                        num2String = num2String.substring(
                                            0,
                                            num2String.length - (partes[1].length - contador)
                                        )
                                        num2 = num2String.toDouble()
                                    }
                                }

                            } else if (num2.equals(0.0)) {
                                num2 = num.toDouble()

                            } else {
                                num2 *= 10.0
                                num2 += num.toDouble()
                            }
                            viewModel.count = num2.toString()
                        }
                    }
                } else {
                    //No puede añadir más decimales
                }
                onCountChanged(viewModel.count)
            }) {
            Text(text = num, fontSize = 25.sp)
        }
    }

    @Composable
    fun Resultado(numero: String) {
        Text(
            text = numero, Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 55.sp,
                shadow = Shadow(
                    color = Color.Blue,
                    blurRadius = 2f
                )
            ),
            textAlign = TextAlign.End,
        )
    }
}