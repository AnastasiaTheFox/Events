package com.akomissarova.dazntest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.akomissarova.dazntest.events.ui.EventsScreen
import com.akomissarova.dazntest.ui.theme.EventsTheme
import com.akomissarova.dazntest.events.ui.EventsViewModel
import com.akomissarova.dazntest.events.ui.ScheduleViewModel
import com.akomissarova.dazntest.ui.ScheduleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val eventsViewModel by viewModels<EventsViewModel>()
        val scheduleViewModel by viewModels<ScheduleViewModel>()
        setContent {
            EventsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(eventsViewModel, scheduleViewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    eventsViewModel: EventsViewModel,
    scheduleViewModel: ScheduleViewModel
) {
    var tabIndex by remember { mutableStateOf(0) }
    LaunchedEffect(Unit, block = {
        eventsViewModel.getEventsList()
    })
    LaunchedEffect(Unit, block = {
        scheduleViewModel.getScheduleEventsList()
    })

    val tabs = listOf(
        stringResource(id = R.string.events_title),
        stringResource(id = R.string.schedule_title),
    )

    Column(modifier = Modifier) {
        Column(modifier = Modifier.weight(1f)) {
            when (tabIndex) {
                0 -> EventsScreen(eventsViewModel)
                1 -> ScheduleScreen(scheduleViewModel)
            }
        }
        TabRow(
            modifier = Modifier.height(50.dp),
            selectedTabIndex = tabIndex,
            indicator = {}
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    modifier = Modifier,
                    text = {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.subtitle2,
                        )
                    },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                )
            }
        }

    }
}
