package me.kamili.rachid.weather.injection.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import me.kamili.rachid.weather.injection.module.ContextModule;
import me.kamili.rachid.weather.injection.module.NetworkModule;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ContextModule.class, NetworkModule.class})
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();
}
