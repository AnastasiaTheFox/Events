package com.akomissarova.dazntest.events.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akomissarova.dazntest.events.data.EventUiParams
import com.akomissarova.dazntest.events.data.EventsRepository
import com.akomissarova.dazntest.events.data.mapToUiParams
import com.akomissarova.dazntest.utils.TimeFormatter
import kotlinx.coroutines.launch

class ScheduleViewModel(
    private val formatter: TimeFormatter,
    private val repository: EventsRepository
) : ViewModel() {
    private val _events = mutableStateListOf<EventUiParams>()
    val eventsList: List<EventUiParams>
        get() = _events

    fun getScheduleEventsList() {
        viewModelScope.launch {
            val result = repository.getSchedule()
            if (result.isSuccess) {
                _events.clear()
                _events.addAll(result.getOrNull()?.map {
                    it.mapToUiParams(formatter)
                } ?: emptyList())
            }
        }
    }
}
