package com.example.weatherapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.viewmodel.mainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // Initialize ViewModel
    private val viewModel: mainViewModel by viewModels()

    // UI Components
    private lateinit var hourlyRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bind UI components
        hourlyRecyclerView = findViewById(R.id.hourlyRecyclerView)

        // Set up RecyclerView
        hourlyRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Fetch and display hourly data
        fetchAndDisplayHourlyData()
    }

    private fun fetchAndDisplayHourlyData() {
        lifecycleScope.launch {
            try {
                // Get weather data from ViewModel
                val weatherData = viewModel.getAllWeatherData()

                // Set the adapter with the weather data
                hourlyRecyclerView.adapter = HourlyForecastAdapter(weatherData)
            } catch (e: Exception) {
                // Show error message in case of failure
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
