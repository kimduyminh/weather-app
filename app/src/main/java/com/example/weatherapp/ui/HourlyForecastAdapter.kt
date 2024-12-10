package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.data.weather

class HourlyForecastAdapter(private val hourlyData: List<weather>) :
    RecyclerView.Adapter<HourlyForecastAdapter.HourlyViewHolder>() {

    class HourlyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tempTextView: TextView = itemView.findViewById(R.id.tempTextView)
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hourly_forecast_item, parent, false)
        return HourlyViewHolder(view)
    }

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        val weatherItem = hourlyData[position]
        holder.tempTextView.text = "${weatherItem.temperature}°C"

        // Format datetime to display only the hour
        val formattedTime = weatherItem.datetime?.substring(11, 16) ?: "N/A"
        holder.timeTextView.text = formattedTime
    }

    override fun getItemCount(): Int {
        return hourlyData.size
    }
}
