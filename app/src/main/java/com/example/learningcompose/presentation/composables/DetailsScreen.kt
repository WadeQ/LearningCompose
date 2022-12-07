package com.example.learningcompose.presentation.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcompose.R
import com.example.learningcompose.domain.model.Feature
import com.example.learningcompose.presentation.composables.destinations.HomeScreenDestination
import com.example.learningcompose.ui.theme.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Destination(route = "Details")
@Composable
fun DetailsScreen(
    navigator: DestinationsNavigator,
    feature: Feature
){

    val list = listOf(
        Feature(
            "Sleep meditation",
            R.drawable.headphone,
            BlueViolet2,
            "Best practice  meditations",
            "Sleep Music",
            "45 min",
            "Ease the mind into a restful night's sleep with these deep," +
                    "ambient tones",
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
            "Ease the mind into a restful night's sleep with these deep," +
                    "ambient tones",
            "12,500",
            "63,0000"
        ),
        Feature(
            "Night Island",
            R.drawable.headphone,
            OrangeYellow1,
            "Best practice night islands",
            "Sleep Music",
            "45 min",
            "Ease the mind into a restful night's sleep with these deep," +
                    "ambient tones",
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
            "Ease the mind into a restful night's sleep with these deep," +
                    "ambient tones",
            "12,542",
            "43,453"
        )
    )
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            TopNavigationMenu(
                onBackArrowClicked = {
                    navigator.navigate(HomeScreenDestination)
                }
            )
            FeaturedBanner(
                feature.title,
                feature.titleBanner
            )
            FeatureCard(
                feature.backGroundColor!!,
                feature.iconId
            )
            CardDetails(
                feature.musicType,
                feature.musicDuration,
                feature.musicDescription,
                feature.savedListens,
                feature.liveListens
            )
            RelatedSection(
               list
            )
        }
    }
}

@Composable
fun TopNavigationMenu(
    onBackArrowClicked: () -> Unit
){
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(painter = painterResource(id = R.drawable.arrow),
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier
                .clickable {
                    onBackArrowClicked.invoke()
                }
                .size(24.dp)
        )
        Icon(painter = painterResource(id = R.drawable.favorite),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
        )
    }
}

@Composable
fun FeaturedBanner(
   title: String,
   titleBanner: String
){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = TextWhite,
                fontFamily = gothicA1,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp))

        Text(
            text = titleBanner,
            style = TextStyle(
                color = AquaBlue,
                fontFamily = gothicA1,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        )
    }
}

@Composable
fun FeatureCard(
    backGroundColor: Color,
    iconId: Int
){
    Card(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 16.dp
    ) {
       Box(
           modifier = Modifier
               .background(backGroundColor)
               .padding(10.dp)
       ) {
           Image(
               painter = painterResource(id = iconId) ,
               contentDescription = "",
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .size(40.dp)
                   .align(Alignment.BottomStart)
           )

           Button(
               onClick = { /*TODO*/ },
               Modifier
                   .align(Alignment.BottomEnd),
               shape = RoundedCornerShape(8.dp)
           ) {
               ButtonBlue
               Text(
                   text = "Start",
                   modifier = Modifier.padding(4.dp)
               )
           }
       }
    }
}

@Composable
fun CardDetails(
    musicType: String,
    musicDuration: String,
    musicDescription: String,
    savedListens: String,
    liveListens: String
){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "$musicType-$musicDuration",
            style = TextStyle(
                color = AquaBlue,
                fontFamily = gothicA1,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp))

        Text(
            text = musicDescription,
            style = TextStyle(
                color = AquaBlue,
                fontFamily = gothicA1,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = R.drawable.favorite),
                contentDescription = "Search",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = "$savedListens Saved",
                style = TextStyle(
                    color = TextWhite,
                    fontFamily = gothicA1,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.headphone),
                    contentDescription = "Search",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                )

                Text(
                    text = "$liveListens Listening",
                    style = TextStyle(
                        color = TextWhite,
                        fontFamily = gothicA1,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .background(Purple700)
            .height(0.7.dp))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RelatedSection(
    features: List<Feature>
){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Related",
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
                .padding(10.dp)
        )

        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight(),
        ){
            items(features.size) {
                FeatureItem(
                    feature = features[it],
                    onItemClicked = {}
                )
            }
        }
    }
}




















