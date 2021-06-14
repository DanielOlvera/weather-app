package com.twitter.challenge.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.twitter.challenge.R
import com.twitter.challenge.TemperatureConverter
import com.twitter.challenge.viewmodel.WeatherViewModel

class WeatherActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@WeatherActivity

        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        val temperatureView = findViewById<View>(R.id.temperature) as TextView
        temperatureView.text =
            getString(R.string.temperature, 34f, TemperatureConverter.celsiusToFahrenheit(34f))


    }
}