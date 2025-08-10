package com.example.weatherapp.data.fakeData

import com.example.weatherapp.R
import com.example.weatherapp.data.local.Cites

object FakeCitesCreator {

    val fakeCity = listOf(
        Cites("Vancouver, Canada", "20", "Sunny", "24", "18", R.drawable.sun),
        Cites("Los Angeles, United State", "34", "Sunny", "36", "25", R.drawable.sun),
        Cites("Dusseldorf, Germany", "-3", "Snowy", "1", "-5", R.drawable.snow),
        Cites("Milan, Italy", "6", "Shower", "10", "4", R.drawable.rain),
        Cites("Tokyo, Japan", "-3", "Snowy", "3", "-5", R.drawable.snow),
        Cites("Tehran, Iran", "8", "Shower", "11", "3", R.drawable.rain)
        )
}