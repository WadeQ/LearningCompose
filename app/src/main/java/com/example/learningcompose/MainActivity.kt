package com.example.learningcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningcompose.ui.theme.LearningComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(name = "Derrick")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello $name!")
        Text("Some Random text")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Greeting("Derrick")
}