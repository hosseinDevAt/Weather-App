package com.example.weatherapp.ui.components.Bottom

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.local.HourlyForecast
import com.example.weatherapp.data.local.WeeklyForecast
import com.example.weatherapp.ui.screens.SearchScreen
import kotlinx.coroutines.launch

@Composable
fun BoxScope.ForecastBottom(
    hourlyForecast: List<HourlyForecast>,
    weeklyForecast: List<WeeklyForecast>
){

    val tabs = listOf("Hourly Forecast", "Weekly Forecast")
    val pagerState = rememberPagerState { tabs.size }
    val scope = rememberCoroutineScope()
    var showSheetSearchState by remember { mutableStateOf(false) }


    SearchScreen(
        showSearch = showSheetSearchState,
        onDismissSearch = { showSheetSearchState = false }
    )


    Column(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
            .background(
                Brush.linearGradient(
                    listOf(
                        Color(0xFF42B8FD),
                        Color(0xFF42B8FD),
                        Color(0xFF42B8FD),
                        Color(0xFF42B8FD)
                    )
                ),
                alpha = 0.8f
            )
    ) {

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(80.dp, 6.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(Color.White)
        )
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.Transparent,
            contentColor = Color.White,
            indicator = {
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(it[pagerState.currentPage])
                        .clip(RoundedCornerShape(25.dp))
                        .height(3.dp)
                        .background(
                            Brush.horizontalGradient(
                                listOf(
                                    Color.Transparent,
                                    Color(0xffffffff),
                                    Color(0xffffffff),
                                    Color.Transparent
                                )
                            )
                        )
                )
            },
            divider = {
                HorizontalDivider(
                    thickness = 2.dp,
                    color = Color.LightGray.copy(alpha = 0.5f)
                )
            }
        ) {

            tabs.forEachIndexed { index, item ->

                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                index,
                                animationSpec = tween(durationMillis = 700)
                            )
                        }
                    },
                    text = {
                        Text(
                            text = item,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                        )
                    }
                )
            }

        }

        HorizontalPager(
            state = pagerState,
        ) { page ->

            if (page == 0)
                HourlyForecastSection(hourlyForecast)
            else
                WeeklyForecastSection(weeklyForecast)



        }

        BottomSection { showSheetSearchState = true }

    }

}