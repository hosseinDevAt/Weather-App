package com.example.weatherapp.ui.components.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchSection(
    query : String,
    onQueryChange : (String) -> Unit
){

    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xff87CEFA))
            .padding(horizontal = 16.dp, vertical = 6.dp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(35.dp),
                tint = Color(0xffEBEBF5)
            )
        },
        trailingIcon = {
            if (query.isNotEmpty()){
                IconButton(
                    {onQueryChange("")}
                ) {
                    Icon(
                        Icons.Default.Clear,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        tint = Color(0xffEBEBF5)
                    )
                }
            }
        },
        placeholder = {
            Text(
                "Search For City",
                color = Color(0xffEBEBF5),
                fontSize = 18.sp
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xaaA8A8A8),
            focusedContainerColor = Color(0xaaA8A8A8),
            focusedIndicatorColor = Color(0xaaA8A8A8),
            unfocusedIndicatorColor = Color(0xaaA8A8A8),
            focusedTextColor = Color.White,
            cursorColor = Color.White,
            selectionColors = TextSelectionColors(
                handleColor = Color.White,
                backgroundColor = Color.LightGray
            )

        ),
        shape = RoundedCornerShape(15.dp),
        singleLine = true

    )

}