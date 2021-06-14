package com.twitter.challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.twitter.challenge.model.WeatherTwitter
import com.twitter.challenge.repo.WeatherRepository

class WeatherViewModel: ViewModel() {
    lateinit var weatherLiveData: MutableLiveData<WeatherTwitter>

    fun getWeather(): LiveData<WeatherTwitter> {
        weatherLiveData = WeatherRepository.getWeatherApiCall()
        return weatherLiveData
    }
}