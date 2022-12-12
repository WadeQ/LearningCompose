package com.example.learningcompose.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.learningcompose.ui.theme.ButtonBlue
import com.example.learningcompose.ui.theme.DarkerButtonBlue
import com.example.learningcompose.ui.theme.TextWhite
import com.example.learningcompose.ui.theme.gothicA1
import com.ramcosta.composedestinations.annotation.Destination


@Destination(start = true)
@Composable
fun InstagramMainScreen(

){
   Box(
       modifier = Modifier
           .background(Color.White)
           .fillMaxSize()
   ) {
       Column {
           NavigationBarTop()
           ProfileDetails()
           UserBio(
               "CodingFlow",
               "Phillip Lackner",
               "18"
           )
           BioChipGroup(chips = listOf(
               "Following","Message","Email","^"
           ))
       }
   }
}

@Composable
fun NavigationBarTop(

) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(painter = painterResource(id = R.drawable.arrow_black),
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier
                .clickable {

                }
                .size(24.dp)
        )

        Text(
            text = "Derrick Wadek",
            style = TextStyle(
                color = Color.Black,
                fontFamily = gothicA1,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Icon(painter = painterResource(id = R.drawable.notification),
            contentDescription = "Search",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
        )

        Icon(painter = painterResource(id = R.drawable.menu),
            contentDescription = "Search",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
        )
    }
}

@Composable
fun ProfileDetails() {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(R.drawable.girl_2),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )

        Column() {
            Text(
                text = "601",
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = gothicA1,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Posts",
                style = TextStyle(
                    color = Color.Gray,
                    fontFamily = gothicA1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Column(

        ) {
            Text(
                text = "500.5K",
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = gothicA1,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Followers",
                style = TextStyle(
                    color = Color.Gray,
                    fontFamily = gothicA1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }

        Column(
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Text(
                text = "100.2K",
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = gothicA1,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Following",
                style = TextStyle(
                    color = Color.Gray,
                    fontFamily = gothicA1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}


@Composable
fun UserBio(
    followerOne: String,
    followerTwo: String,
    otherFollowers: String
) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Senior Software Engineer",
            style = TextStyle(
                color = Color.Black,
                fontFamily = gothicA1,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Over 10 years coding experience",
            style = TextStyle(
                color = Color.Gray,
                fontFamily = gothicA1,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            text = "Want quality Android Apps? Send me an email",
            style = TextStyle(
                color = Color.Gray,
                fontFamily = gothicA1,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            text = "Followed by $followerOne, $followerTwo and $otherFollowers others",
            style = TextStyle(
                color = Color.Gray,
                fontFamily = gothicA1,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
fun BioChipGroup(
    chips: List<String>
){
    LazyRow{
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {

                    }
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White)
                    .padding(15.dp)
            ){
                Text(
                    text = chips[it],
                    color = Color.Black
                )
            }
        }
    }
}


















