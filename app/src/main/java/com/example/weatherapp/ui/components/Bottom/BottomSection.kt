package com.example.weatherapp.ui.components.Bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R

@Composable
fun BottomSection(
    showSheetSearch: () -> Unit
) {

    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier.fillMaxWidth()
    ) {

        Image(
            painter = painterResource(R.drawable.rectangle),
            contentDescription = null,
            modifier = Modifier
                .height(110.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.fillMaxWidth().padding(end = 25.dp, bottom = 15.dp)
        ) {

            IconButton(
                onClick = { showSheetSearch() }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_list),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp),
                    tint = Color(0XFF0099CC)
                )
            }

        }

        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier.fillMaxWidth().padding(start = 25.dp, bottom = 15.dp)
        ) {

            Icon(
                painter = painterResource(R.drawable.ic_map),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp),
                tint = Color(0XFF0099CC)
            )

        }

    }


}