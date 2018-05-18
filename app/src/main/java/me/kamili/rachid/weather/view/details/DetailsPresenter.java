package me.kamili.rachid.weather.view.details;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.inject.Inject;

import me.kamili.rachid.weather.model.WeatherResponse;
import me.kamili.rachid.weather.utils.TextUtils;
import me.kamili.rachid.weather.utils.TimeUtils;
import me.kamili.rachid.weather.utils.WeatherUtils;
import me.kamili.rachid.weather.view.base.BasePresenter;

public class DetailsPresenter extends BasePresenter<DetailsView> {

    private static final String TAG = DetailsPresenter.class.getSimpleName();

    @Inject
    public DetailsPresenter() {
    }

    public void setWeatherDetails(WeatherResponse weather) {
        String descriptionName = TextUtils.capitalizeByWords(weather.getWeather().get(0).getDescription());
        String description = WeatherUtils.getDescription(weather.getMain().getTempMax());
        String temp = String.valueOf((int) WeatherUtils.celsiusToFahrenheit(weather.getMain().getTemp()));
        String windSpeed = weather.getWind().getSpeed() + " m/s";
        String cloudiness = WeatherUtils.getCloudinessDesc(weather.getClouds().getAll(), weather.getDt());
        String pressure = weather.getMain().getPressure() + " hpa";
        String humidity = weather.getMain().getHumidity() + "%";
        String sunrise = new SimpleDateFormat("hh:mm a").format(
                                    TimeUtils.shiftTimeZone(
                                            weather.getSys().getSunrise(),
                                            TimeZone.getTimeZone("UTC"),
                                            Calendar.getInstance().getTimeZone()
                                    ));

        String city = weather.getName() + ", " + weather.getSys().getCountry();

        //Send data to the activity
        getView().setWeatherDetails(descriptionName, description, temp, windSpeed, cloudiness
                , pressure, humidity, sunrise, city);
    }
}
