package com.akomissarova.dazntest.events.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akomissarova.dazntest.di.ServiceLocator
import com.akomissarova.dazntest.di.ServiceLocator.timeFormatter

class EventsViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == EventsViewModel::class.java) {
            return EventsViewModel(timeFormatter, ServiceLocator.eventsRemoteService()) as T
        } else if (modelClass == ScheduleViewModel::class.java) {
            return ScheduleViewModel(timeFormatter, ServiceLocator.eventsRemoteService()) as T
        }
        return super.create<T>(modelClass)
    }
}