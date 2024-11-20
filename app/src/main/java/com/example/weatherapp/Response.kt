package com.example.weatherapp

data class Response(
	val elevation: Any? = null,
	val hourlyUnits: HourlyUnits? = null,
	val generationtimeMs: Any? = null,
	val timezoneAbbreviation: String? = null,
	val timezone: String? = null,
	val latitude: Any? = null,
	val utcOffsetSeconds: Int? = null,
	val hourly: Hourly? = null,
	val longitude: Any? = null
)

data class Hourly(
	val temperature2m: List<Any?>? = null,
	val time: List<String?>? = null
)

data class HourlyUnits(
	val temperature2m: String? = null,
	val time: String? = null
)

