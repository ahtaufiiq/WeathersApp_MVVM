package com.example.ataufiq.weathersapp_mvvm.MainActivity

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.ataufiq.weathersapp_mvvm.MainActivity.MainAdapter
import com.example.ataufiq.weathersapp_mvvm.data.Weather

object MainBinding {
    @BindingAdapter("app:weatherList")
    @JvmStatic
    fun setWeatherList(recyclerView: RecyclerView, weathers: MutableList<Weather>) {
        with(recyclerView.adapter as MainAdapter){
            replaceData(weathers)
        }
    }
}