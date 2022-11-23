package com.example.learningcompose.domain.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val backGroundColor:@RawValue Color,
    val titleBanner: String,
    val musicType: String,
    val musicDuration: String,
    val musicDescription: String,
    val savedListens: String,
    val liveListens: String
): Parcelable
