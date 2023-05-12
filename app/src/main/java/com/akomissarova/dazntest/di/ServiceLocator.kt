package com.akomissarova.dazntest.di

import com.akomissarova.dazntest.events.ui.EventsViewModelFactory
import com.akomissarova.dazntest.utils.TimeFormatter

object ServiceLocator {
    public val timeFormatter = TimeFormatter()

    public fun viewModelFactory(): EventsViewModelFactory = EventsViewModelFactory()
    //fun getTimeFormatter(): TimeFormatter = TimeFormatter()
}
