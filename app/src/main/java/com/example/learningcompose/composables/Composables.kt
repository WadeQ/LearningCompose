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
fun ImageCard2(
    painter: Painter,
    title: String,
    contentDescription: String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp
    ) {
        Box(
            modifier = modifier.height(200.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                Text(
                    title,
                    modifier = modifier.align(
                        Alignment.CenterStart
                    ),
                    style = TextStyle(
                        color = Color.White
                    ),
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = modifier.height(36.dp))
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    contentDescription,
                    modifier = modifier.align(
                       Alignment.BottomStart
                    ),
                    style = TextStyle(color = Color.White),
                    fontSize = 14.sp
                )
            }
        }
    }
}