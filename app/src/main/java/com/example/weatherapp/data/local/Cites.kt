package com.example.weatherapp.data.local

import androidx.annotation.DrawableRes

data class Cites(
    val name : String,
    val temp : String,
    val state : String,
    val highTemp : String,
    val lowTemp : String,
    @DrawableRes val img : Int
)
