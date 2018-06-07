package com.example.ataufiq.weathersapp_mvvm.DetailActivity

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import com.example.ataufiq.weathersapp_mvvm.data.Weather
import com.example.ataufiq.weathersapp_mvvm.data.source.WeathersRepository
import com.example.ataufiq.weathersapp_mvvm.util.SingleLiveEvent

class DetailViewModel(application: Application, weatherRepository: WeathersRepository) : AndroidViewModel(application){
    val details: ObservableField<Weather> = ObservableField()
    internal val openBrowser = SingleLiveEvent<String>()

    fun start(){

    }


}