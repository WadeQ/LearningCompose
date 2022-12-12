package com.example.learningcompose.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.example.learningcompose.ui.theme.*
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
           BioChipGroup()
           StorySection()
           StoryDefinitionSection()
           InstagramIconsSection()
       }
   }
}

@Composable
fun InstagramIconsSection() {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 36.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(painter = painterResource(id = R.drawable.pixels),
            contentDescription = "Grid",
            tint = Color.Black,
            modifier = Modifier
                .clickable {

                }
                .size(24.dp)
        )

        Icon(painter = painterResource(id = R.drawable.user_profile),
            contentDescription = "Grid",
            tint = Color.Black,
            modifier = Modifier
                .clickable {

                }
                .size(24.dp)
        )
    }
}

@Composable
fun StoryDefinitionSection() {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Text(
            text = "YouTube",
            style = TextStyle(
                color = Color.Black,
                fontFamily = gothicA1,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Q and A",
            style = TextStyle(
                color = Color.Black,
                fontFamily = gothicA1,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Discord",
            style = TextStyle(
                color = Color.Black,
                fontFamily = gothicA1,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Telegram",
            style = TextStyle(
                color = Color.Black,
                fontFamily = gothicA1,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
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
fun BioChipGroup(){
    Row(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
//                authViewModel.onLoginEvent(OnLoginEvent.OnLoginButtonClicked)
            },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text(text = "Following")

            Icon(painter = painterResource(id = R.drawable.down),
                contentDescription = "Down",
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
            )
        }
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text(text = "Message")
        }
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text(text = "Email")
        }
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier
                .padding(4.dp)
        ) {
            Text(text = "")
            Icon(painter = painterResource(id = R.drawable.down),
                contentDescription = "Down",
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}

@Composable
fun StorySection(){
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(R.drawable.youtube),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Image(
            painter = painterResource(R.drawable.qa),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Image(
            painter = painterResource(R.drawable.discord),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Image(
            painter = painterResource(R.drawable.telegram),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
    }
}


















