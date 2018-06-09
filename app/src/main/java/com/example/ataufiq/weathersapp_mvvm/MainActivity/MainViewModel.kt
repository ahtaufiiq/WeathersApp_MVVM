package com.example.ataufiq.weathersapp_mvvm.MainActivity

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.util.Log
import android.widget.Toast
import com.example.ataufiq.weathersapp_mvvm.data.Weather
import com.example.ataufiq.weathersapp_mvvm.data.source.WeathersDataSource
import com.example.ataufiq.weathersapp_mvvm.data.source.WeathersRepository
import com.example.ataufiq.weathersapp_mvvm.util.SingleLiveEvent

class MainViewModel(application: Application, private val weatherRepository: WeathersRepository) : AndroidViewModel(application){
    val weatherList: ObservableList<Weather> = ObservableArrayList()
    internal val openDetailWeather = SingleLiveEvent<Weather>()

    fun start(){
        getWeather()
    }

    private fun getWeather(){
        weatherRepository.getWeather(object : WeathersDataSource.GetWeatherCallback{
            override fun onNotAvailable() {
                Toast.makeText(getApplication(),"No Data Found",Toast.LENGTH_SHORT).show()
            }

            override fun onError(msg: String?) {
                Toast.makeText(getApplication(),"Error at "+msg,Toast.LENGTH_SHORT).show()
                Log.d("Error Main View Model",msg)
            }

            override fun onWeatherLoaded(weathers: MutableList<Weather>?) {
                with(weatherList){
                    clear()
                    addAll(weathers!!)
                }
            }
        })
    }
}