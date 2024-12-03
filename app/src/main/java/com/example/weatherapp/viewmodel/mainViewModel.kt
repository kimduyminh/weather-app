package com.example.weatherapp.viewmodel

import com.example.weatherapp.data.weatherAPI
import com.example.weatherapp.data.weather
import com.example.weatherapp.data.weatherDao

class mainViewModel {
    private var weatherArray : MutableList<weather> = TODO()
    private var weatherAPIData = weatherAPI
    private val weatherDao : weatherDao
    private var currentWeatherArray : List<weather>

    suspend fun getWeatherData(){
        var response = weatherAPIData.service.getWeather()
        if (response.isSuccessful) {
            weatherDao.deleteAllData()
            for (i in 0..response.body()?.hourly?.time!!.size - 1) {
                weatherArray[i].datetime = response.body()?.hourly?.time!![i]
            }
            for (j in 0..response.body()?.hourly?.temperature2m!!.size - 1) {
                weatherArray[j].temperature = response.body()?.hourly?.temperature2m!![j]
            }
            syncToDatabase()
        }
        else {
            //add toast here
        }
    }

    suspend fun syncToDatabase(){
        for(i in weatherArray){
            weatherDao.insertWeatherData(i)
        }
    }
    suspend fun getAllWeatherData(): List<weather> {
        return weatherDao.getAllWeatherData()
    }
    suspend fun refreshData(): List<weather> {
        getWeatherData()
        currentWeatherArray = getAllWeatherData()
        return currentWeatherArray
    }

}