package me.kamili.rachid.weather.application;

import android.app.Application;

import me.kamili.rachid.weather.injection.component.ApplicationComponent;
import me.kamili.rachid.weather.injection.component.DaggerApplicationComponent;
import me.kamili.rachid.weather.injection.module.ContextModule;
import me.kamili.rachid.weather.injection.module.NetworkModule;

public class WeatherApplication extends Application {

    private static final String BASE_URL = "https://openweathermap.org";

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    private void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .contextModule(new ContextModule(this))
                .networkModule(new NetworkModule(BASE_URL))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
