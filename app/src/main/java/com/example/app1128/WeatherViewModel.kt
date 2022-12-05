package com.example.app1128

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class WeatherViewModel :ViewModel(){
    val cities = listOf<String>("Taipei","New York","London","Tokyo")
    val selectedCityWeather = MutableLiveData<CityWeather>()

    fun sendRetrofitRequest(location: String){
        viewModelScope.launch{
            try{
                val result =
                    GetService.retrofitService.getAppData(location, "metric", "zh_tw",WeatherViewModel.API_KEY)
                val cityWeather = CityWeather(
                    result.name,
                    result.main.temp,
                    result.weather[0].description,
                    result.weather[0].icon
                )
                selectedCityWeather.value = cityWeather
                Log.d("Main", cityWeather.toString())
            }catch (e: Exception){
                Log.d("Main", "Fail due to ${e.message}")
            }
        }
    }
    // calss static variables
    companion object{
        const val API_URL = "https://api.openweathermap.org"
        const val API_KEY = "71308d654f79d5e9595eb0d57b311504"
    }
}