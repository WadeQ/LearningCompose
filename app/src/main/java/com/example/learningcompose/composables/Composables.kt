package com.example.learningcompose.composables

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    description: String
){
    Column() {
        var clicked: MutableState<Boolean> = remember {
            mutableStateOf(false)
        }
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
           Card(
               modifier
                   .fillMaxWidth()
                   .wrapContentHeight()
                   .padding(16.dp),
               RoundedCornerShape(12.dp),
               elevation = 8.dp
           ) {
               Row(
                   Modifier
                       .weight(1f),
                   horizontalArrangement = Arrangement.SpaceEvenly,
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Box(
                       modifier = Modifier.padding(16.dp)
                   ) {
                       Text(
                           text = "Click Button",
                           style = TextStyle(
                               Color.Black,
                               fontSize = 18.sp
                           )
                       )
                   }
                   Box(
                       modifier = modifier
                           .padding(16.dp)
                   )
                   {
                       Button(onClick = { clicked.value = !clicked.value }) {
                           Color.Cyan
                           Text(
                               if (clicked.value) "You clicked ME!" else "Click ME!"
                           )
                       }
                   }
               }
           }
    }

}

@Composable
fun OnBoardingScreen(
    onButtonClicked : () -> Unit
){
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentWidth()
        ) {
            Text(
                text = "Welcome to Google Codelabs",
                style = TextStyle(
                    Color.White,
                    fontSize = 18.sp
                )
            )
        }
        Box(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentWidth()
        ) {
            Button(onClick = onButtonClicked ) {
                Color.Blue
                Text(
                    text = "Continue"
                )
            }
        }
    }
}

@Composable
fun DisplaySomeText(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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

@Composable
fun DisplaySomeButton(
    modifier: Modifier = Modifier
){
   Row(modifier.fillMaxWidth()) {
       Box(
           modifier = Modifier
               .height(100.dp)
               .weight(1f)
       ) {
           Text(
               text = "Click Button",
               style = TextStyle(
                   Color.White,
                   fontSize = 16.sp
               )
           )
       }
   }
}

