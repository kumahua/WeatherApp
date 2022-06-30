# WeatherApp


## 建立Interface
Interface就是各個連線的接口，每個連線是用GET或POST及其路徑、參數都寫在這裡，個人覺得是Retrofit的精華，將所有連線統一管理。

    interface WeatherService {
        @GET("2.5/weather")
        fun getWeather(
            @Query("lat") lat: Double,
            @Query("lon") lon: Double,
            @Query("units") units: String,
            @Query("lang") lang: String,
            @Query("appid") appid: String
        ) : Call<WeatherResponse>
    }
    
## 建立Retrofit
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //創造能夠使用WeatherService介面的service物件
    val service: WeatherService = retrofit
        .create(WeatherService :: class.java)

    val listCall: Call<WeatherResponse> = service.getWeather(
        latitude, longitude, Constants.METRIC_UNIT, LANG, Constants.Api_ID
    )
