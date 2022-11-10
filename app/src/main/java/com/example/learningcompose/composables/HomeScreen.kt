package com.example.learningcompose.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R
import com.example.learningcompose.domain.Feature
import com.example.learningcompose.ui.theme.*


@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize(),
    ) {
        Column {
            GreetingsLayout(name = "Derrick", timeOfDay = "Morning")
            ChipsSection(chips = listOf(
                "Sweet sleep","Insomnia","Depression"
            ))
            MeditationCard()
            FeaturedSection(
                listOf(
                    Feature(
                        "Sleep meditation",
                        R.drawable.headphone,
                        BlueViolet2
                    ),
                    Feature(
                        "Tips for sleeping",
                        R.drawable.video,
                        LightGreen2
                    ),
                    Feature(
                        "Night Island",
                        R.drawable.play,
                        OrangeYellow1
                    ),
                    Feature(
                        "Calming sounds",
                        R.drawable.play,
                        Beige3
                    )
                )
            )
        }
    }
}

@Composable
fun GreetingsLayout(
    name: String,
    timeOfDay: String
){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
       Column(
           verticalArrangement = Arrangement.Center
       ) {
           Text(
               text = "Good $timeOfDay, $name",
               style = TextStyle(
                   color = TextWhite,
                   fontFamily = gothicA1,
                   fontSize = 22.sp,
                   fontWeight = FontWeight.Bold
               )
           )
           Text(
               text = "We wish you have a good $timeOfDay!",
               style = TextStyle(
                   color = TextWhite,
                   fontFamily = gothicA1,
                   fontSize = 16.sp,
                   fontWeight = FontWeight.Light
               )
           )
       }
        Icon(painter = painterResource(id = com.example.learningcompose.R.drawable.search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(34.dp)
        )
    }
}

@Composable
fun ChipsSection(
    chips: List<String>
){
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow{
        items(chips.size){
          Box(
              contentAlignment = Alignment.Center,
              modifier = Modifier
                  .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                  .clickable {
                      selectedChipIndex = it
                  }
                  .clip(RoundedCornerShape(15.dp))
                  .background(
                      if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
                  )
                  .padding(15.dp)
          ){
              Text(
                  text = chips[it],
                  color = TextWhite
              )
          }
        }
    }
}

@Composable
fun MeditationCard(modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .height(130.dp)
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 16.dp
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(LightRed)
        ) {
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Daily Thought",
                        style = TextStyle(
                            color = TextWhite,
                            fontFamily = gothicA1,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Meditation  3-10 min",
                        style = TextStyle(
                            color = TextWhite,
                            fontFamily = gothicA1,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.play) ,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturedSection(
    features: List<Feature>
){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Featured",
            style = TextStyle(
                color = TextWhite,
                fontFamily = gothicA1,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        
        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight(),
        ){
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(feature: Feature) {
    Card(
        modifier = Modifier
            .height(170.dp)
            .fillMaxWidth(0.5f),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Box(
            modifier = Modifier
                .background(feature.backGroundColor)
                .padding(10.dp)
        ) {
            Column(

            ) {
               Text(
                   text = feature.title,
                   style = TextStyle(
                       color = TextWhite,
                       fontFamily = gothicA1,
                       fontSize = 16.sp,
                       fontWeight = FontWeight.Light
                   )
               )
                Box(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                    ,
                ) {
                    Image(
                        painter = painterResource(id = feature.iconId) ,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(start = 6.dp)
                            .size(40.dp)
                            .align(Alignment.BottomStart)
                    )

                   Button(
                       onClick = { /*TODO*/ },
                            Modifier.align(Alignment.BottomEnd),
                        shape = RoundedCornerShape(16.dp)
                   ) {
                       ButtonBlue
                       Text(
                           text = "Start"
                       )
                   }
                }
            }
        }
    }
}































