package com.akomissarova.dazntest.events.data

import com.akomissarova.dazntest.remote.EventsRemoteService
import com.akomissarova.dazntest.remote.data.EventRemoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EventsRepository(private val remoteService: EventsRemoteService) {

    public suspend fun getEvents(): Result<List<EventRemoteData>> {
        return withContext(Dispatchers.IO) {
            Result.success(remoteService.getEvents())
        }
    }

    public suspend fun getSchedule(): Result<List<EventRemoteData>> {
        return withContext(Dispatchers.IO) {
            Result.success(remoteService.getSchedule())
        }
    }
}