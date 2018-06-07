package com.example.ataufiq.weathersapp_mvvm.data

import android.os.Parcel
import android.os.Parcelable

class Weather(
        var name: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
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