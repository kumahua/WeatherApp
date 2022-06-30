# WeatherApp
透過Retrofit搭配使用FusedLocationProviderClient及lastLocation方法獲得經緯度以抓取openweathermap api上的資料，最後呈現至畫面上。

<img src="https://user-images.githubusercontent.com/40682280/176605382-f5a8db8c-3587-46d5-b9c2-de25a6146ef7.png" width="350">

## 建立Interface
Interface就是各個連線的接口，每個連線是用GET或POST及其路徑、參數都寫在這裡，將所有連線統一管理。

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
        .addConverterFactory(GsonConverterFactory.create()) //這邊透過 Google 出的 Json 處理工具叫做 Gson 來進行轉換
        .build()

    //創造能夠使用WeatherService介面的service物件
    val service: WeatherService = retrofit
        .create(WeatherService :: class.java)

    val listCall: Call<WeatherResponse> = service.getWeather(
        latitude, longitude, Constants.METRIC_UNIT, LANG, Constants.Api_ID
    )
