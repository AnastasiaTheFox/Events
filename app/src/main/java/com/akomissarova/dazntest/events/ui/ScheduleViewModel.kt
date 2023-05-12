package com.akomissarova.dazntest.events.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akomissarova.dazntest.events.data.EventUiParams
import com.akomissarova.dazntest.events.data.mapToUiParams
import com.akomissarova.dazntest.remote.EventsRemoteService
import com.akomissarova.dazntest.utils.TimeFormatter
import kotlinx.coroutines.launch

class ScheduleViewModel(
    private val formatter: TimeFormatter,
    private val eventsRemoteService: EventsRemoteService
) : ViewModel() {
    private val _events = mutableStateListOf<EventUiParams>()
    val eventsList: List<EventUiParams>
        get() = _events

    fun getScheduleEventsList() {
        viewModelScope.launch {
            try {
                _events.clear()
                _events.addAll(eventsRemoteService.getSchedule().map { it.mapToUiParams(formatter) })
            } catch (e: Exception) {
            }
        }
    }
}
