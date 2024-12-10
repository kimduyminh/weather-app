package com.example.weatherapp.data
import android.health.connect.datatypes.units.Temperature
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "hourly_weather")
data class weather(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "datetime") var datetime: String?,
    @ColumnInfo(name = "temperature_2m") var temperature: Double?
)
