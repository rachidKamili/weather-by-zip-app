package me.kamili.rachid.weather.injection.module;

import dagger.Module;
import dagger.Provides;
import me.kamili.rachid.weather.api.ApiService;
import me.kamili.rachid.weather.injection.scope.PerActivity;
import me.kamili.rachid.weather.view.details.DetailsView;
import retrofit2.Retrofit;

@Module
public class DetailsModule {

    private DetailsView mView;

    public DetailsModule(DetailsView view) {
        mView = view;
    }

    @PerActivity
    @Provides
    DetailsView provideView() {
        return mView;
    }

}
