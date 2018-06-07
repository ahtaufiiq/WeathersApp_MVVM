package com.example.ataufiq.weathersapp_mvvm.util

import android.content.Context
import android.preference.PreferenceManager
import com.example.ataufiq.weathersapp_mvvm.data.source.WeathersRepository
import com.example.ataufiq.weathersapp_mvvm.data.source.remote.WeathersRemoteDataSource
import com.example.ataufiq.weathersapp_mvvm.data.source.local.WeathersLocalDataSource

object Injection{
    fun provideWeatherRepository(context: Context) = WeathersRepository.getInstance(WeathersRemoteDataSource,
            WeathersLocalDataSource.getInstance(PreferenceManager.getDefaultSharedPreferences(context))!!)
}