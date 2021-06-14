package com.twitter.challenge.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherTwitter(
    @SerializedName("coord")
    @Expose
    var coord: Coord? = null,

    @SerializedName("weather")
    @Expose
    var weather: Weather? = null,

    @SerializedName("wind")
    @Expose
    var wind: Wind? = null,

    @SerializedName("rain")
    @Expose
    var rain: Rain? = null,

    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
)