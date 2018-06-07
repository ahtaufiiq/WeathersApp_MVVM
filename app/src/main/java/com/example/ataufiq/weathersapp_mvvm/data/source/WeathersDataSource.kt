package com.example.ataufiq.weathersapp_mvvm.data.source

import com.example.ataufiq.weathersapp_mvvm.data.Weather

interface WeathersDataSource {
    fun getWeather(callback: GetWeatherCallback)

    interface GetWeatherCallback {
        fun onWeatherLoaded(weathers: MutableList<Weather>?)
        fun onNotAvailable()
        fun onError(msg : String?)
    }
}