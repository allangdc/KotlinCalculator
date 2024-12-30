package org.meliante.kotlincalculator

import org.meliante.kotlincalculator.Calculator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

fun NumericClick(number: Int, result: MutableState<String>) {
    var vv: Int = result.value.toInt()
    vv = vv * 10 + number
    result.value = vv.toString()
}

@Composable
fun Btn(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier.height(70.dp)) { Text(text) }
}

@Composable
@Preview
fun App() {
    val result = remember { mutableStateOf("0") }
    val calculator = Calculator()

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = result.value,
                onValueChange = { result.value = it},
                readOnly = true,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(6),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                item { Btn(text = "7", onClick = { result.value = calculator.pressNumber(7).toString() }) }
                item { Btn(text = "8", onClick = { result.value = calculator.pressNumber(8).toString() }) }
                item { Btn(text = "9", onClick = { result.value = calculator.pressNumber(9).toString() }) }
                item { Btn(text = "/", onClick = { }) }
                item { Btn(text = "Undo", onClick = {}) }
                item { Btn(text = "Clear", onClick = { result.value = calculator.pressClear().toString() }) }

                item { Btn(text = "4", onClick = { result.value = calculator.pressNumber(4).toString() }) }
                item { Btn(text = "5", onClick = { result.value = calculator.pressNumber(5).toString() }) }
                item { Btn(text = "6", onClick = { result.value = calculator.pressNumber(6).toString() }) }
                item { Btn(text = "*", onClick = { result.value = calculator.pressOperator("*").toString() }) }
                item { Btn(text = "(", onClick = {}) }
                item { Btn(text = ")", onClick = {}) }

                item { Btn(text = "1", onClick = { result.value = calculator.pressNumber(1).toString() }) }
                item { Btn(text = "2", onClick = { result.value = calculator.pressNumber(2).toString() }) }
                item { Btn(text = "3", onClick = { result.value = calculator.pressNumber(3).toString() }) }
                item { Btn(text = "-", onClick = { result.value = calculator.pressOperator("-").toString() }) }
                item { Btn(text = "x²", onClick = {}) }
                item { Btn(text = "sqrt", onClick = {}) }

                item { Btn(text = "0", onClick = { result.value = calculator.pressNumber(0).toString() }) }
                item { Btn(text = ",", onClick = {}) }
                item { Btn(text = "%", onClick = {}) }
                item { Btn(text = "+", onClick = { result.value = calculator.pressOperator("+").toString() }) }
                item(span={ GridItemSpan(2) }) { Btn(text = "=", onClick = { result.value = calculator.pressEqual().toString() }) }
            }
        }
    }
}