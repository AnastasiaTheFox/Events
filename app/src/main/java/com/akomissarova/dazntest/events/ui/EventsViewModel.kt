package com.akomissarova.dazntest.events.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akomissarova.dazntest.events.data.EventUiParams
import com.akomissarova.dazntest.events.data.EventsRepository
import com.akomissarova.dazntest.events.data.mapToUiParams
import com.akomissarova.dazntest.utils.TimeFormatter
import kotlinx.coroutines.launch

class EventsViewModel(
    private val formatter: TimeFormatter,
    private val repository: EventsRepository
) : ViewModel() {
    private val _events = mutableStateListOf<EventUiParams>()
    val eventsList: List<EventUiParams>
        get() = _events

    fun getEventsList() {
        viewModelScope.launch {
            try {
                _events.clear()
                _events.addAll(repository.getEvents().map { it.mapToUiParams(formatter) })
            } catch (e: Exception) {
            }
        }
    }
}
