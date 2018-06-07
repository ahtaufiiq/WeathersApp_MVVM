package com.example.ataufiq.weathersapp_mvvm.MainActivity

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ataufiq.weathersapp_mvvm.R

import com.example.ataufiq.weathersapp_mvvm.data.Weather
import com.example.ataufiq.weathersapp_mvvm.databinding.CardWeatherBinding
import com.example.ataufiq.weathersapp_mvvm.util.load

class MainAdapter(private var weathers: MutableList<Weather>, private var mainViewModel: MainViewModel) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val weatherRowBinding : CardWeatherBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.card_weather,parent,false)
        return WeatherRowHolder(weatherRowBinding)
    }

    override fun getItemCount(): Int = weathers.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val datas = weathers[position]
        val actionListener = object : WeathersItemUserActionListener {
            override fun onWeatherClicked(weather: Weather) {
                mainViewModel.openDetailWeather.value = weather
            }

        }
        (holder as WeatherRowHolder).bindRows(datas,actionListener)
    }

    fun replaceData(weathers: MutableList<Weather>){
        setList(weathers)
    }

    fun setList(weathers: MutableList<Weather>){
        this.weathers = weathers
        notifyDataSetChanged()
    }

    class WeatherRowHolder(binding: CardWeatherBinding) : RecyclerView.ViewHolder(binding.root){
        val weatherRowBinding = binding

        fun bindRows(weather: Weather, userActionListener: WeathersItemUserActionListener) {
            weatherRowBinding.datas =  weather
            weatherRowBinding.action = userActionListener
            weatherRowBinding.executePendingBindings()
            if(weather.icon!= null)
                weatherRowBinding.ivRowWeatherImage.load("http://openweathermap.org/img/w/${weather.icon!!}.png"){
                    requestCreator -> requestCreator.fit().centerCrop()
                }
        }
    }
}