package com.example.weatherapp.network

import com.example.weatherapp.models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    //https://api.openweathermap.org/data/2.5/weather?lat=25&lon=121&appid=98ca07eb98136e828d476db8e0474579
    @GET("2.5/weather")
    fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("lang") lang: String,
        @Query("appid") appid: String
    ) : Call<WeatherResponse> //當呼叫getWeather，會調用 WeatherResponse，作為整個call的回應
}