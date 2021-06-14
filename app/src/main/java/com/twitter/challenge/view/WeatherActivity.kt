package com.twitter.challenge.view

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.twitter.challenge.R
import com.twitter.challenge.TemperatureConverter
import com.twitter.challenge.utils.fiveChars
import com.twitter.challenge.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*

class WeatherActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@WeatherActivity

        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        val temperatureView = findViewById<View>(R.id.temperature) as TextView

        weatherViewModel.getWeather().observe(this, { weather ->

            city.text = weather.name
            val temp = weather.weather!!.temp

            temperatureView.text =
                getString(R.string.temperature, temp.toString().fiveChars(), TemperatureConverter.celsiusToFahrenheit(temp.toFloat()).toString().fiveChars())

            windSpeed.text = getString(R.string.wind_speed, weather.wind!!.speed)

            if (weather.clouds!!.cloudiness > 50) {
                cloudiness.setImageResource(R.drawable.ic_baseline_wb_cloudy_24)
            } else {
                cloudiness.setImageResource(R.drawable.ic_baseline_wb_sunny_24)
            }
        })
    }
}