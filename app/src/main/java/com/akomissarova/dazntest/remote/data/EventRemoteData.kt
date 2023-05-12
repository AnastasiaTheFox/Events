package com.akomissarova.dazntest.remote.data

data class EventRemoteData(
    val id: Int,
    val title: String,
    val subtitle: String,
    val date: String,
    val imageUrl: String,
    val videoUrl: String?
)
