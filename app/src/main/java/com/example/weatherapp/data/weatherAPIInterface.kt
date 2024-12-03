package com.example.weatherapp.data

import retrofit2.Response
import retrofit2.http.GET

interface weatherAPIInterface {
    @GET("forecast?latitude=21.02&longitude=105.83&hourly=temperature_2m&models=cma_grapes_global")
    suspend fun getWeather(): Response<weatherResponse>
}