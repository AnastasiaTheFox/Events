package com.akomissarova.dazntest.di

import com.akomissarova.dazntest.events.data.EventsRepository
import com.akomissarova.dazntest.events.ui.EventsViewModelFactory
import com.akomissarova.dazntest.remote.EventsRemoteService
import com.akomissarova.dazntest.utils.TimeFormatter

object ServiceLocator {
    val timeFormatter = TimeFormatter()

    fun viewModelFactory(): EventsViewModelFactory = EventsViewModelFactory()
    fun eventsRemoteService(): EventsRemoteService = EventsRemoteService.getInstance()
    fun eventsRepository(): EventsRepository = EventsRepository(eventsRemoteService())
}
