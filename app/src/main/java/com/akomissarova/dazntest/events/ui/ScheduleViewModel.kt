package com.akomissarova.dazntest.events.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akomissarova.dazntest.di.ServiceLocator
import com.akomissarova.dazntest.events.data.EventUiParams
import com.akomissarova.dazntest.events.data.mapToUiParams
import com.akomissarova.dazntest.remote.EventsRemoteService
import com.akomissarova.dazntest.utils.TimeFormatter
import kotlinx.coroutines.launch

class ScheduleViewModel(private val formatter: TimeFormatter) : ViewModel() {
    private val _events = mutableStateListOf<EventUiParams>()
    val eventsList: List<EventUiParams>
        get() = _events

    fun getScheduleEventsList() {
        viewModelScope.launch {
            val apiService = EventsRemoteService.getInstance()
            try {
                _events.clear()
                _events.addAll(apiService.getSchedule().map { it.mapToUiParams(formatter) })
            } catch (e: Exception) {
            }
        }
    }
}
