package com.akomissarova.dazntest.events.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akomissarova.dazntest.events.data.EventUiParams
import com.akomissarova.dazntest.events.data.mapToUiParams
import com.akomissarova.dazntest.remote.EventsRemoteService
import kotlinx.coroutines.launch

class EventsViewModel : ViewModel() {
    private val _events = mutableStateListOf<EventUiParams>()
    val eventsList: List<EventUiParams>
        get() = _events

    fun getEventsList() {
        viewModelScope.launch {
            val apiService = EventsRemoteService.getInstance()
            try {
                _events.clear()
                _events.addAll(apiService.getEvents().map { it.mapToUiParams() })
            } catch (e: Exception) {
            }
        }
    }

    /*var events by mutableStateOf(
        listOf<EventUiParams>(
            EventUiParams(
                title = "Liverpool v Porto",
                subtitle = "UEFA Champions League",
                timeText = "Today 10am"
            ),
            EventUiParams(
                title = "Nîmes v Rennes",
                subtitle = "Ligue 1",
                timeText = "Today 10am"
            )
        )
    )*/
}
