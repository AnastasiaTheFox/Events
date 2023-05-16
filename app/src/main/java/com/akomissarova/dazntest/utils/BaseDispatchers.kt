package com.akomissarova.dazntest.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface BaseDispatchers {
    val IO: CoroutineDispatcher
}

class Dispatchers : BaseDispatchers {
    override val IO: CoroutineDispatcher
        get() = Dispatchers.IO
}
