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
            val result = repository.getEvents()
            //TODO should be error handling here with passing different states
            if (result.isSuccess) {
                _events.clear()
                _events.addAll(result.getOrNull()?.map {
                    it.mapToUiParams(formatter)
                } ?: emptyList())
            }
        }
    }
}
