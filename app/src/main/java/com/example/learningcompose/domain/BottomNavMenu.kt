package com.example.learningcompose.domain

import androidx.annotation.DrawableRes

data class BottomNavMenu(
    val title: String,
    @DrawableRes val iconId: Int
)
