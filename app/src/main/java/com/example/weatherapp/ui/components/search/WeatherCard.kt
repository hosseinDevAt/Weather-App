package com.example.weatherapp.ui.components.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.local.Cites

@Composable
fun WeatherCard(
    city : Cites
){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(15.dp))
            .height(220.dp)
            .customBackgroundCard()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(
                "${city.temp}°",
                fontSize = 48.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(10.dp))

            Text(
                city.state,
                fontSize = 20.sp,
                color = Color.White
            )

            Spacer(Modifier.height(10.dp))

            Text(
                "H:${city.highTemp}° L:${city.lowTemp}°",
                fontSize = 20.sp,
                color = Color(0xffC9C9C9),
            )

            Spacer(Modifier.height(20.dp))

            Text(
                city.name,
                fontSize = 26.sp,
                color = Color.White
            )

        }

        Image(
            painter = painterResource(id = city.img),
            contentDescription = city.name,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(150.dp)
        )

    }

}


@Composable
fun Modifier.customBackgroundCard() : Modifier = this.then(
    Modifier.drawBehind {

        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width, 180f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }

        drawPath(
            path = path,
            brush = Brush.linearGradient(
                listOf(
                    Color(0xff3BB4FF),
                    Color(0xff482FE9)
                ),
                start = Offset.Zero,
                end = Offset(size.width, size.height)
            ),
            style = Fill
        )
    }
)