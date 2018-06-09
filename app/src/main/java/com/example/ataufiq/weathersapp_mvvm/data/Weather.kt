package com.example.ataufiq.weathersapp_mvvm.data

import android.os.Parcel
import android.os.Parcelable

class Weather(
        var name: String? = null,
        var main: String? = null,
        var icon: String? = null,
        var description: String? = null,
        var temperature: String? = null,
        var humidity:   String?=null,
        var seaLevel:String?=null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()){
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(main)
        parcel.writeString(icon)
        parcel.writeString(description)
        parcel.writeString(temperature)
        parcel.writeString(humidity)
        parcel.writeString(seaLevel)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Weather> {
        override fun createFromParcel(parcel: Parcel): Weather {
            return Weather(parcel)
        }

        override fun newArray(size: Int): Array<Weather?> {
            return arrayOfNulls(size)
        }
    }
}