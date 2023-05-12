package com.akomissarova.dazntest.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.akomissarova.dazntest.events.data.EventUiParams

@Composable
fun CommonEventListItem(
    modifier: Modifier = Modifier,
    data: EventUiParams
) {
    Row(
        modifier = modifier
            .padding(
                all = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        AsyncImage(
            modifier = modifier
                .size(52.dp),
            model = data.imageUrl,
            contentDescription = "${data.title} ${data.subtitle}"
        )
        Spacer(
            modifier = modifier.width(12.dp)
        )
        InfoContentRow(data, modifier)
        Spacer(
            modifier = modifier.width(12.dp)
        )
    }
}

@Composable
private fun InfoContentRow(
    data: EventUiParams,
    modifier: Modifier
) {
    Column {
        Text(
            text = data.title,
            style = MaterialTheme.typography.subtitle1,
        )
        Spacer(
            modifier = modifier.height(2.dp)
        )
        Text(
            text = data.subtitle,
            style = MaterialTheme.typography.subtitle2,
        )
        Spacer(
            modifier = modifier.height(12.dp)
        )
        Text(
            text = data.timeText,
            style = MaterialTheme.typography.caption,
        )
    }
}