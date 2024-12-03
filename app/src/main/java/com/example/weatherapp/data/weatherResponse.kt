package com.example.weatherapp.data
data class weatherResponse(
    val hourly: HourlyData
)

data class HourlyData(
    val time: List<String?>,
    val temperature2m: List<Any?>
)