package com.appscals.daycountr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appscals.daycountr.ui.theme.DayCountrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DayCountrTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hello $name!")
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "BUTTON")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DayCountrTheme {
        Greeting("Android")
    }
}