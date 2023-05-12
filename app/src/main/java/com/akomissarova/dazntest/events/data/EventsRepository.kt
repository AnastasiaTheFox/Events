package com.akomissarova.dazntest.events.data

import com.akomissarova.dazntest.remote.EventsRemoteService
import com.akomissarova.dazntest.remote.data.EventRemoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EventsRepository(private val remoteService: EventsRemoteService) {

    public suspend fun getEvents(): List<EventRemoteData> {
        return withContext(Dispatchers.IO) {
             remoteService.getEvents()
        }
    }

    public suspend fun getSchedule(): List<EventRemoteData> {
        return withContext(Dispatchers.IO) {
            remoteService.getSchedule()
        }
    }
}