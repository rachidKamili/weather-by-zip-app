package me.kamili.rachid.weather.view.search;

import me.kamili.rachid.weather.model.WeatherResponse;
import me.kamili.rachid.weather.view.base.BaseView;

public interface SearchView extends BaseView {
    void onGoDetails(WeatherResponse weather);
    void hideKeyboard();
}
