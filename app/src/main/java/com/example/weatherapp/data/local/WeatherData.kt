package com.example.weatherapp.data.local

data class WeatherData(
    val name : String,
    val temp : String,
    val state : String,
    val highTemp : String,
    val lowTemp : String,
    val hourlyForecast : List<HourlyForecast>,
    val weeklyForecast : List<WeeklyForecast>
)

data class HourlyForecast(
    val time : String,
    val temp : String
)

data class WeeklyForecast(
    val dayOfWeek : String,
    val temp : String
)
