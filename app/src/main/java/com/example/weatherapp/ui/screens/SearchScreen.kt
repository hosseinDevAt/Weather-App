package com.example.weatherapp.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.data.fakeData.FakeCitesCreator
import com.example.weatherapp.data.local.Cites
import com.example.weatherapp.ui.components.search.DragHandle
import com.example.weatherapp.ui.components.search.SearchSection
import com.example.weatherapp.ui.components.search.WeatherCard

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(
    showSearch: Boolean,
    onDismissSearch: () -> Unit
) {

    if (!showSearch) return
    val cityList = remember { FakeCitesCreator.fakeCity }
    var query by remember { mutableStateOf("") }
    val filterCity = remember { mutableStateListOf<Cites>() }
    val showSheet = rememberModalBottomSheetState(true)
    LaunchedEffect(key1 = query) {
        filterCity.clear()
        filterCity.addAll(
            cityList.filter { it.name.contains(query, ignoreCase = true) }
        )
    }

    ModalBottomSheet(
        modifier = Modifier.statusBarsPadding(),
        onDismissRequest = onDismissSearch,
        sheetState = showSheet,
        containerColor = Color(0xff87CEFA),
        dragHandle = { DragHandle { onDismissSearch() } }
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            stickyHeader {
                SearchSection(
                    query = query,
                    onQueryChange = { query = it }
                )
            }
            items(items = filterCity, key = { it.name }) {
                WeatherCard(city = it)
            }

            if (filterCity.isEmpty()) {
                item {
                    Text(
                        "No Data Found",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.White.copy(0.8f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)

                    )
                }
            }

        }

    }
}
