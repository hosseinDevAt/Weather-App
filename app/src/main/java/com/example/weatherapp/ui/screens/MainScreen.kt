package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.data.fakeData.FakeWeatherCreator
import com.example.weatherapp.ui.components.Bottom.ForecastBottom
import com.example.weatherapp.ui.components.header.HeaderSection

@Composable
fun MainScreen() {

    val item = remember { FakeWeatherCreator.fakeWeather }

    BackgroundMain {

        HeaderSection(
            item.name,
            item.temp,
            item.state,
            item.highTemp,
            item.lowTemp
        )


        ForecastBottom(item.hourlyForecast, item.weeklyForecast)

    }


}





