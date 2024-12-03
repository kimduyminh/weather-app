package com.example.weatherapp.data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object weatherAPI {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.open-meteo.com/v1/forecast?latitude=21.02&longitude=105.83&hourly=temperature_2m&models=cma_grapes_global")
        .build()
    val service: weatherAPIInterface = retrofit.create(weatherAPIInterface::class.java)
}