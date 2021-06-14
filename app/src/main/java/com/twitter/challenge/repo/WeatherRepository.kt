package com.twitter.challenge.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twitter.challenge.model.WeatherTwitter
import com.twitter.challenge.model.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object WeatherRepository {
    val TAG = WeatherRepository::class.java.simpleName

    val serviceWeather = MutableLiveData<WeatherTwitter>()

    fun getWeatherApiCall(): MutableLiveData<WeatherTwitter> {
        val call = RetrofitClient.apiInterface.getWeatherService()

        call.enqueue(object : Callback<WeatherTwitter> {
            override fun onResponse(
                call: Call<WeatherTwitter>,
                response: Response<WeatherTwitter>
            ) {
                Log.d(TAG, response.body().toString())

                val data = response.body()

                val city = data!!.name
                val wind = data.wind
                val weather = data.weather
                val clouds = data.clouds

                serviceWeather.value = WeatherTwitter(
                    wind = wind,
                    weather = weather,
                    clouds = clouds,
                    name = city
                )
            }

            override fun onFailure(call: Call<WeatherTwitter>, t: Throwable) {
                Log.e(TAG, t.message!!)
            }

        })

        return serviceWeather
    }
}