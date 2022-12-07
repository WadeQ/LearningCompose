package com.example.learningcompose.presentation.composables

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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R
import com.example.learningcompose.domain.model.BottomNavMenu
import com.example.learningcompose.domain.model.Feature
import com.example.learningcompose.presentation.composables.destinations.DetailsScreenDestination
import com.example.learningcompose.ui.theme.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
){

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
                        BlueViolet2,
                        "Best practice  meditations",
                        "Sleep Music",
                    "45 min",
                        "Ease the mind into a restful night's sleep with these deep, ambient tones",
                        "12,542",
                        "43,453"
                    ),
                    Feature(
                        "Tips for sleeping",
                        R.drawable.video,
                        LightGreen2,
                        "Best practice for sleeping",
                        "Sleep Music",
                        "45 min",
                        "Ease the mind into a restful night's sleep with these deep, ambient tones",
                        "12,500",
                        "63,0000"
                    ),
                    Feature(
                        "Night Island",
                        R.drawable.headphone,
                        OrangeYellow2,
                        "Best practice night islands",
                        "Sleep Music",
                        "45 min",
                        "Ease the mind into a restful night's sleep with these deep, ambient tones",
                        "12,542",
                        "43,453"
                    ),
                    Feature(
                        "Calming sounds",
                        R.drawable.video,
                        Beige3,
                        "Best practice calming sounds",
                        "Sleep Music",
                        "45 min",
                        "Ease the mind into a restful night's sleep with these deep, ambient tones",
                        "12,542",
                        "43,453"
                    )
                )
            ) {
                navigator.navigate(DetailsScreenDestination(it))
            }
        }

        BottomNavigationSection(list = listOf(
            BottomNavMenu("Home", R.drawable.home),
            BottomNavMenu("Meditate", R.drawable.meditation),
            BottomNavMenu("Sleep", R.drawable.moon),
            BottomNavMenu("Music", R.drawable.music),
            BottomNavMenu("Profile", R.drawable.user),
        ), modifier = Modifier.align(Alignment.BottomCenter))
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
        Icon(painter = painterResource(id = R.drawable.search),
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
fun MeditationCard(){
    Card(
        modifier = Modifier
            .height(130.dp)
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 16.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightRed)
        ) {
            Row(
                Modifier
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
    features: List<Feature>,
    onClicked: (Feature) -> Unit
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
            items(features.size) { it ->
                FeatureItem(
                    feature = features[it],
                    onItemClicked = { feature ->
                        onClicked.invoke(feature)
                    }
                )
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature,
    onItemClicked:  (Feature) -> Unit
) {

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
                            .size(40.dp)
                            .align(Alignment.BottomStart)
                    )

                   Button(
                       onClick = {
                           onItemClicked.invoke(feature)
                       },
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

@Composable
fun BottomNavigationSection(
    list: List<BottomNavMenu>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inActiveTextColor: Color  = AquaBlue,
    initialSelectedItemIndex: Int = 0
){

    var selectedIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(16.dp)
    ) {
        list.forEachIndexed { index, items ->
            BottomMenuSingleItem(
                item = items,
                isSelected = index == selectedIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inActiveTextColor = inActiveTextColor
            ){
                selectedIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuSingleItem(
    item: BottomNavMenu,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inActiveTextColor: Color  = AquaBlue,
    isSelected:  Boolean,
    onMenuItemClicked: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onMenuItemClicked()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inActiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inActiveTextColor
        )
    }
}































