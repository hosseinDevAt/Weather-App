package com.example.weatherapp.ui.components.Bottom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.data.local.WeeklyForecast

@Composable
fun WeeklyForecastSection(
    weeklyForecast: List<WeeklyForecast>
){

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(items = weeklyForecast, key = { it.dayOfWeek }){

            ItemPager(
                time = it.dayOfWeek,
                temp = it.temp,
                img = R.drawable.pic
            )

        }

    }

}