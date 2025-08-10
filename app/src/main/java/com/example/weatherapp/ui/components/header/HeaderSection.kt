package com.example.weatherapp.ui.components.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BoxScope.HeaderSection(
    name: String,
    temp: String,
    state: String,
    highTemp: String,
    lowTemp: String
) {

    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .statusBarsPadding()
            .align(Alignment.TopCenter),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = name,
            fontSize = 38.sp,
            color = Color.White
        )

        Text(
            text = "$temp°",
            fontSize = 44.sp,
            color = Color.White
        )

        Text(
            text = state,
            fontSize = 32.sp,
            color = Color(0XFF0099CC)
        )


        Text(
            text = "H:$highTemp°  L:$lowTemp°",
            fontSize = 38.sp,
            color = Color.White
        )


    }


}