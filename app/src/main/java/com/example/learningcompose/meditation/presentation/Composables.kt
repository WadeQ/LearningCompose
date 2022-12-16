package com.example.learningcompose.presentation.composables

import android.content.Intent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.presentation.HomeActivity
import com.example.learningcompose.R
import kotlinx.coroutines.launch


@Composable
fun RandomImageCard(
    painter: Painter,
    modifier: Modifier = Modifier,
    description: String
){
    Column {
        var clicked by rememberSaveable {
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
                       Button(onClick = { clicked = !clicked }) {
                           Color.Cyan
                           Text(
                               if (clicked) "You clicked ME!" else "Click ME!"
                           )
                       }
                   }
               }
           }

    }

}

@Composable
fun ExpandableList() {
    LazyColumn(Modifier.padding(8.dp)) {
        items(500) {
            SomeButtonAndText()
        }
    }
}

@Composable
fun SomeButtonAndText(
    modifier: Modifier = Modifier
){
    var expanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier.fillMaxWidth()
    ) {
        Card(
            modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = 16.dp
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
            ) {
               Column(
                   modifier = Modifier.padding(6.dp)
               ) {
                   Box(modifier.padding(16.dp)) {
                       Text(
                           text = "Click To View More",
                           style = TextStyle(
                               Color.Black,
                               fontSize = 18.sp,
                               fontWeight = FontWeight.ExtraBold
                           ))
                       if (expanded){
                           Text(
                               modifier = Modifier.padding(vertical = 20.dp),
                               text = ("The quick brown fox jumped over the lazy dog.")
                                   .repeat(10),
                               style = TextStyle(
                                   Color.Black,
                                   fontSize = 16.sp
                               )
                           )
                       }
                   }
                   Box(
                       modifier = modifier.padding(12.dp)
                   ) {
                       IconButton(onClick = { expanded = !expanded }) {
                           Icon(
                               imageVector = if (expanded) Icons.Filled.ExpandLess else
                                   Icons.Filled.ExpandMore,
                               contentDescription = if (expanded) {
                                   stringResource(R.string.show_less)
                               } else {
                                   stringResource(R.string.show_more)
                               }
                           )
                       }
                   }
               }
            }
        }
    }
}

@Composable
fun ShowTextFields(
    modifier: Modifier = Modifier
){
    val scaffoldState = rememberScaffoldState()
    var someText by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = someText,
                label = {
                        Text(text = "Enter some text")
                },
                onValueChange = {
                    someText = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
            )
            Box(modifier.fillMaxWidth()) {
                Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            "Typed text is ${someText}"
                        )
                    }
                }) {
                   Text(text = "Show Text")
                }
            }
        }
    }

}

@Composable
fun ShowList(
    modifier: Modifier = Modifier,
){
    LazyColumn(modifier.padding(8.dp)){
        items(500){
            RandomImageCard(
                painter = painterResource(id = R.drawable.farmer_events),
                description = "Arguably, this is the most beautiful black kid in the world. " +
                        "This was according to some survey done online.")
        }
    }
}

@Composable
fun OnBoardingScreen(){
    val context = LocalContext.current
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
            Button(onClick = {
                val intent = Intent(context, HomeActivity::class.java)
                context.startActivity(intent)
            } ) {
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

