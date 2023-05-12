package com.akomissarova.dazntest.events.data

import com.akomissarova.dazntest.remote.data.EventRemoteData
import com.akomissarova.dazntest.utils.TimeFormatter

data class EventUiParams(
    val imageUrl: String? = null,
    val timeText: String,
    val title: String,
    val subtitle: String
)

fun EventRemoteData.mapToUiParams(formatter: TimeFormatter): EventUiParams {
    return EventUiParams(
        imageUrl = imageUrl,
        timeText = formatter.convertDate(date) ?: "",
        title = title,
        subtitle = subtitle
    )
}
