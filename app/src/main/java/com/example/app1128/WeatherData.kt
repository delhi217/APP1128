package com.example.app1128

// Define data classes that map to JSON formats
data class WeatherData(val name: String, val main: Temperature, val weather: List<Weather>)

data class Temperature(val temp: Double, val humidity: Int, val temp_min: Double, val temp_max: Double)

data class Weather(var main: String, var description: String, var icon: String)

//Define a dara class that record the city's main info
data class CityWeather(val name: String, val temperature: Double, val description: String, val iconName: String)
