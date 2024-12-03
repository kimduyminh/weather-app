package com.example.weatherapp.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface weatherDao {
    @Insert
    suspend fun insertWeatherData(weather: weather)

    @Query("SELECT * FROM hourly_weather")
    suspend fun getAllWeatherData(): List<weather>

    @Query("DELETE FROM hourly_weather")
    suspend fun deleteAllData()
}