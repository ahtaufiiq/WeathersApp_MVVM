package com.example.ataufiq.weathersapp_mvvm.util

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.support.annotation.VisibleForTesting
import com.example.ataufiq.weathersapp_mvvm.data.source.WeathersRepository
import com.example.ataufiq.weathersapp_mvvm.DetailActivity.DetailViewModel
import com.example.ataufiq.weathersapp_mvvm.MainActivity.MainViewModel

class ViewModelFactory private constructor(
        private val application: Application,
        private val weatherRepository: WeathersRepository
) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>)= with(modelClass) {
        when{
            isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(application,weatherRepository)
            isAssignableFrom(DetailViewModel::class.java) ->
                    DetailViewModel(application,weatherRepository)
            else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }as T

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
                INSTANCE
                        ?: synchronized(ViewModelFactory::class.java){
                    INSTANCE
                            ?: ViewModelFactory(
                                    application, Injection.provideWeatherRepository(application.applicationContext))
                            .also { INSTANCE = it }
                }

        @VisibleForTesting fun destroyInstance(){
            INSTANCE = null
        }
    }
}