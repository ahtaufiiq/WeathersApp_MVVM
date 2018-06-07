package com.example.ataufiq.weathersapp_mvvm.MainActivity

import com.example.ataufiq.weathersapp_mvvm.data.Weather

interface WeathersItemUserActionListener {
    fun onWeatherClicked(weather: Weather)
}