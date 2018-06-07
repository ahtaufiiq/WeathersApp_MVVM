package com.example.ataufiq.weathersapp_mvvm.data.source.remote

import com.example.ataufiq.weathersapp_mvvm.data.source.remote.dao.WeatherApiDao
import com.example.ataufiq.weathersapp_mvvm.util.Constant
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface WeathersRemoteService {
    @GET("data/2.5/find?lat=-6.914744&lon=107.609810&cnt=10&appId=a1a21b58dc969cb4d32bc5868a090256")
    fun getWeather() : Observable<WeatherApiDao>

    companion object Factory {

        fun create():WeathersRemoteService{

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl(Constant.BASE_URL)
                    .build()

            return retrofit.create(WeathersRemoteService ::class.java)
        }
    }
}
