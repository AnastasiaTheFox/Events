package com.akomissarova.dazntest.events.data

import com.akomissarova.dazntest.remote.data.EventRemoteData

data class EventUiParams(
    val imageUrl: String? = null,
    val timeText: String,
    val title: String,
    val subtitle: String
)

fun EventRemoteData.mapToUiParams(): EventUiParams{
    return EventUiParams(
        imageUrl = imageUrl,
        timeText = date,
        title = title,
        subtitle = subtitle
    )
}
