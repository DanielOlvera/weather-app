package com.twitter.challenge.model.retrofit

import com.twitter.challenge.model.WeatherTwitter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("current.json")
    fun getWeatherService(): Call<WeatherTwitter>
}