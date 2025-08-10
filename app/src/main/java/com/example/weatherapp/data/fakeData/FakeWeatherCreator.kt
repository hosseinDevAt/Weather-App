package com.example.weatherapp.data.fakeData

import com.example.weatherapp.data.local.HourlyForecast
import com.example.weatherapp.data.local.WeatherData
import com.example.weatherapp.data.local.WeeklyForecast

object FakeWeatherCreator {

    val fakeWeather = WeatherData(
        name = "Vancouver",
        temp = "19",
        state = "Clear",
        highTemp = "24",
        lowTemp = "18",
        hourlyForecast = listOf(
            HourlyForecast("8 AM", "18"),
            HourlyForecast("NOW", "20"),
            HourlyForecast("10 AM", "21"),
            HourlyForecast("11 AM", "23"),
            HourlyForecast("12 PM", "25"),
            HourlyForecast("1 PM", "28"),
            HourlyForecast("2 PM", "30"),
        ),
        weeklyForecast = listOf(
            WeeklyForecast("Sat", "20"),
            WeeklyForecast("Sun", "20"),
            WeeklyForecast("NOW", "20"),
            WeeklyForecast("Tue", "20"),
            WeeklyForecast("Wed", "20"),
            WeeklyForecast("Thu", "20"),
            WeeklyForecast("Fri", "20"),
        )
    )

}