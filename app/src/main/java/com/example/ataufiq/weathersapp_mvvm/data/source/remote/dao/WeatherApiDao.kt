package com.example.ataufiq.weathersapp_mvvm.data.source.remote.dao


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class WeatherApiDao{

    @SerializedName("count")
    @Expose
    val count: Int? = 0
    @SerializedName("cod")
    @Expose
    val cod: String? = ""
    @SerializedName("message")
    @Expose
    val message: String? = ""
    @SerializedName("list")
    @Expose
    val list: List<ListItem>?=null

    open class ListItem
    {
        @SerializedName("dt")
        val dt: Int? = 0
//        @SerializedName("rain")
//        val rain: Rain?=null
//        @SerializedName("coord")
//        val coord: Coord?=null
        @SerializedName("snow")
        val snow: Double? = null
        @SerializedName("name")
        @Expose
        val name: String? = ""
        @SerializedName("weather")
        @Expose
        val weather: List<WeatherItem>?=null
//        @SerializedName("main")
//        val main: List<Main>?=null
//        @SerializedName("id")
//        val id: Int? = 0
//        @SerializedName("clouds")
//        val clouds: Clouds?=null
//        @SerializedName("sys")
//        val sys: Sys?=null
//        @SerializedName("wind")
//        val wind: List<Wind>?=null

//        open class Main{@SerializedName("temp")
//        val temp: Double? = 0.0
//            @SerializedName("temp_min")
//            val tempMin: Double? = 0.0
//            @SerializedName("grnd_level")
//            val grndLevel: Double? = 0.0
//            @SerializedName("humidity")
//            val humidity: Int? = 0
//            @SerializedName("pressure")
//            val pressure: Double? = 0.0
//            @SerializedName("sea_level")
//            val seaLevel: Double? = 0.0
//            @SerializedName("temp_max")
//            val tempMax: Double? = 0.0
//        }

        open class WeatherItem{
            @SerializedName("icon")
                               val icon: String? = ""
                               @SerializedName("description")
                               val description: String? = ""
                               @SerializedName("main")
                               val main: String? = ""
                               @SerializedName("id")
                               val id: Int? = 0}

//        open class Coord{@SerializedName("lon")
//                         val lon: Double? = 0.0
//                         @SerializedName("lat")
//                         val lat: Double? = 0.0}
//
//
//        open class Wind{@SerializedName("deg")
//                        val deg: Int? = 0
//                        @SerializedName("speed")
//                        val speed: Double? = 0.0}
//
//
//        open class Rain{@SerializedName("3h")
//                        val H: Double? = 0.0}
//
//
//        open class Clouds{@SerializedName("all")
//                          val all: Int? = 0}
//
//        open class Sys{@SerializedName("country")
//                       val country: String? = ""}
    }

}

