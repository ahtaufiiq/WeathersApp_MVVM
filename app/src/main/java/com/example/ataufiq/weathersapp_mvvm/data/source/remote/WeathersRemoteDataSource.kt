package com.example.ataufiq.weathersapp_mvvm.data.source.remote



import android.util.Log
import com.example.ataufiq.weathersapp_mvvm.data.source.remote.dao.WeatherApiDao
import com.example.ataufiq.weathersapp_mvvm.data.Weather
import com.example.ataufiq.weathersapp_mvvm.data.source.WeathersDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object WeathersRemoteDataSource : WeathersDataSource {
    private val apiService = WeathersRemoteService.create();
    override fun getWeather(callback: WeathersDataSource.GetWeatherCallback) {
        apiService.getWeather()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ results ->
                    run {
                            val listWeather: MutableList<Weather> = mutableListOf<Weather>()
                            for (items: WeatherApiDao.ListItem in results.list!!) {
                                val weather: Weather = Weather()
                                weather.name = items.name
                                for (weatherItem:WeatherApiDao.ListItem.WeatherItem in items.weather!!){
                                    weather.icon = weatherItem.icon
                                    weather.description=weatherItem.description
                                }

                                listWeather.add(weather)
                            }

                            callback.onWeatherLoaded(listWeather)

                    }
                }, { error ->
                    callback.onError(error.message)
                })
    }

}