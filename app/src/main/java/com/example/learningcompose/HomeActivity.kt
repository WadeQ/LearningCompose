package com.example.learningcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.learningcompose.composables.ExpandableList
import com.example.learningcompose.composables.OnBoardingScreen
import com.example.learningcompose.composables.RandomImageCard

class HomeActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.farmer_events)
            val description = "Arguably, this is the most beautiful black kid in the world. " +
                    "This was according to some survey done online."
            val title = "Beautiful people"
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            ) {
//                 RandomImageCard(painter, description = description)
                ExpandableList()
            }
        }
    }
}