package com.example.learningcompose.domain.model

import androidx.annotation.DrawableRes

data class BottomNavMenu(
    val title: String,
    @DrawableRes val iconId: Int
)
