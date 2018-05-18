package me.kamili.rachid.weather.api;

import io.reactivex.Observable;
import me.kamili.rachid.weather.model.WeatherResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    //Get current weather data by zip code
    @GET("/data/2.5/weather")
    Observable<WeatherResponse> getWeather(@Query("q") String zip);

}
