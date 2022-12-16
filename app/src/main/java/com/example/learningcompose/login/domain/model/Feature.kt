package com.example.learningcompose.login.domain.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize


@Parcelize
data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val backGroundColor: Color,
    val titleBanner: String,
    val musicType: String,
    val musicDuration: String,
    val musicDescription: String,
    val savedListens: String,
    val liveListens: String
): Parcelable{

    override fun describeContents(): Int {
        return 0
    }

    companion object : Parceler<Feature> {
        override fun Feature.write(parcel: Parcel, flags: Int) {
            parcel.writeString(title)
            parcel.writeInt(iconId)
            parcel.writeValue(backGroundColor.toArgb())
            parcel.writeString(titleBanner)
            parcel.writeString(musicType)
            parcel.writeString(musicDuration)
            parcel.writeString(musicDescription)
            parcel.writeString(savedListens)
            parcel.writeString(liveListens)
        }

        override fun create(parcel: Parcel): Feature {
            return Feature(
                parcel.readString()!!,
                parcel.readInt(),
                Color(parcel.readValue(Int::class.java.classLoader) as Int),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!
            )
        }
    }
}
