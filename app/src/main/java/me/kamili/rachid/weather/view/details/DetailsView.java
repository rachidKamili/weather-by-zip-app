package me.kamili.rachid.weather.view.details;

import me.kamili.rachid.weather.view.base.BaseView;

public interface DetailsView extends BaseView {

    void setWeatherDetails(String descriptionName, String description, String temp,
                           String windSpeed, String cloudiness, String pressure,
                           String humidity, String sunrise, String city);
}
