package com.example.ataufiq.weathersapp_mvvm.data.source.remote



import android.util.Log
import com.example.ataufiq.weathersapp_mvvm.data.source.remote.dao.WeatherApiDao
import com.example.ataufiq.weathersapp_mvvm.data.Weather
import com.example.ataufiq.weathersapp_mvvm.data.source.WeathersDataSource
import com.example.ataufiq.weathersapp_mvvm.util.Constant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.math.RoundingMode
import java.text.DecimalFormat

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
                                    weather.main=weatherItem.main
                                }

                                val df = DecimalFormat("#.##")
                                df.roundingMode = RoundingMode.CEILING

                                var temp: Double?=null
                                var humidity: Int?=null
                                var seaLevel: Double?=null

                                items.main.also { temp=it?.temp?.minus(273.15) }
                                        .also { humidity=it?.humidity }
                                        .also { seaLevel=it?.seaLevel }

                                weather.temperature="${df.format(temp)} °C"

                                weather.humidity="$humidity %"

                                weather.seaLevel="$seaLevel mdpl"

                                listWeather.add(weather)
                            }

                            callback.onWeatherLoaded(listWeather)

                    }
                }, { error ->
                    callback.onError(error.message)
                })
    }

}

