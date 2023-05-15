package com.akomissarova.dazntest.events.data

import com.akomissarova.dazntest.remote.EventsRemoteService
import com.akomissarova.dazntest.remote.data.EventRemoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import java.io.IOException
import kotlin.time.Duration.Companion.seconds

class EventsRepository(private val remoteService: EventsRemoteService) {

    public suspend fun getEvents(): Result<List<EventRemoteData>> {
        return withContext(Dispatchers.IO) {
            Result.success(remoteService.getEvents())
        }
    }

    public suspend fun getSchedule(): Flow<Result<List<EventRemoteData>>> {
        return flow {
            while (currentCoroutineContext().isActive) {
                emit(Result.success(remoteService.getSchedule()))
                delay(UPDATE_DELAY)
            }
        }
            .flowOn(Dispatchers.IO)
            .catch {
                emit(Result.failure(IOException("Error fetching schedule")))
            }
    }
}

private val UPDATE_DELAY = 30.seconds