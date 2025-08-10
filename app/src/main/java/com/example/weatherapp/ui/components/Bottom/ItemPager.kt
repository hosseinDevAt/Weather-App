package com.example.weatherapp.ui.components.Bottom

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly

@Composable
fun ItemPager(
    time : String,
    @DrawableRes img : Int,
    temp : String
){

    val backgroundColor by animateColorAsState(
        targetValue = if (time == "NOW") Color(0xff0099CC) else
        Color(0xff87C7DD)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .background(backgroundColor, RoundedCornerShape(30.dp))
            .padding(10.dp)
    ) {

        Text(
            text = if (time.take(1).isDigitsOnly()) time.take(4)
            else time.take(3),
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        Image(
            painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier
                .size(55.dp)
        )


        Text(
            text = "$temp°",
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(vertical = 12.dp)
        )

    }


}