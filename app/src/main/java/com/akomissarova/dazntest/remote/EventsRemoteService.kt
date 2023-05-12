package com.akomissarova.dazntest.remote

import com.akomissarova.dazntest.remote.data.EventRemoteData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface EventsRemoteService {
    @GET("getEvents")
    suspend fun getEvents(): List<EventRemoteData>

    @GET("getSchedule")
    suspend fun getSchedule(): List<EventRemoteData>

    companion object {
        var apiService: EventsRemoteService? = null
        fun getInstance(): EventsRemoteService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(EventsRemoteService::class.java)
            }
            return apiService!!
        }
    }

}

const val BASE_URL = "https://us-central1-dazn-sandbox.cloudfunctions.net/"