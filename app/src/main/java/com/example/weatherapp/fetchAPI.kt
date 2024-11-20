package com.example.weatherapp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class fetchAPI {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.open-meteo.com/v1/forecast?latitude=21.02&longitude=105.83&hourly=temperature_2m&models=cma_grapes_global")
        .build()
    @GET
    fun fetch(): Retrofit? {
        return retrofit
    }
}