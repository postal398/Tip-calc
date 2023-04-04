package com.example.tiptime

import android.icu.text.NumberFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiptime.ui.theme.TipTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipTimeScreen()
                }
            }
        }
    }
}

@Composable
fun TipTimeScreen() {

    var amountInput: String by remember { mutableStateOf("Hey") } //отслеживается Compose
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip : String = calculateTip(amount).toString()

    Column(
        modifier = Modifier.padding(32.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
            EditNumberField(//Вызов функции пользовательского ввода чаевых
                value = amountInput,
                onValueChange = { amountInput = it }) //It's a custom function
        Spacer(Modifier.height(24.dp))
        Text( // Строка итого чааевых
            text = stringResource(R.string.tip_amount, tip), //отображает строку Tip Amount и переменную Tip
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold

        )
    }
}



@Composable
fun EditNumberField(//Функция описывающая поведение пользовательского ввода чаевых
    value: String,
    onValueChange: (String) -> Unit)
{


        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(stringResource(R.string.cost_of_service)) },
           modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
}


@VisibleForTesting
internal fun calculateTip(
    amount: Double,
    tipPercent: Double = 15.0
): String? {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}