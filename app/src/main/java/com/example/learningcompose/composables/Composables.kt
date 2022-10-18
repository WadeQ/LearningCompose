package com.example.learningcompose.composables

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RandomImageCard(
    painter: Painter,
    modifier: Modifier = Modifier,
    title: String,
    description: String
){
    Card(
        modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 8.dp
    ) {
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painter ,
                contentDescription = description,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun DisplaySomeText(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "Some random text for test purposes",
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp
            )
        )
    }
}

