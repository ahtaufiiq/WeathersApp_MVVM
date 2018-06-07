package com.example.ataufiq.weathersapp_mvvm.data.source.local

import android.content.SharedPreferences
import android.support.annotation.VisibleForTesting
import com.example.ataufiq.weathersapp_mvvm.data.source.WeathersDataSource

class WeathersLocalDataSource private constructor(private val preference:SharedPreferences) : WeathersDataSource {
    override fun getWeather(callback: WeathersDataSource.GetWeatherCallback) {
        //NOTHING
    }

    companion object {
        private var INSTANCE: WeathersLocalDataSource? = null
        @JvmStatic
        fun getInstance(preference: SharedPreferences): WeathersLocalDataSource? {
            if (INSTANCE == null){
                synchronized(WeathersLocalDataSource::class.java){
                    INSTANCE = WeathersLocalDataSource(preference)
                }
            }
            return INSTANCE
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }
}