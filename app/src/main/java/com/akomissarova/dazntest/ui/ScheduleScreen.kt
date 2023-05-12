package com.akomissarova.dazntest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akomissarova.dazntest.events.ui.ScheduleViewModel
import com.akomissarova.dazntest.ui.common.CommonEventListItem

@Composable
fun ScheduleScreen(scheduleViewModel: ScheduleViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            scheduleViewModel.eventsList.forEach { event ->
                item {
                    CommonEventListItem(data = event)
                }
            }
        }
    }
}