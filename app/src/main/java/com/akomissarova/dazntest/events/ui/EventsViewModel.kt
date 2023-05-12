package com.akomissarova.dazntest.events.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akomissarova.dazntest.events.data.EventUiParams
import com.akomissarova.dazntest.events.data.mapToUiParams
import com.akomissarova.dazntest.remote.EventsRemoteService
import com.akomissarova.dazntest.utils.TimeFormatter
import kotlinx.coroutines.launch

class EventsViewModel(
    private val formatter: TimeFormatter,
    private val eventsRemoteService: EventsRemoteService
) : ViewModel() {
    private val _events = mutableStateListOf<EventUiParams>()
    val eventsList: List<EventUiParams>
        get() = _events

    fun getEventsList() {
        viewModelScope.launch {
            try {
                _events.clear()
                _events.addAll(eventsRemoteService.getEvents().map { it.mapToUiParams(formatter) })
            } catch (e: Exception) {
            }
        }
    }
}
