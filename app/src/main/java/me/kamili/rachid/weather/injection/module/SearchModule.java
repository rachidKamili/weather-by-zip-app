package me.kamili.rachid.weather.injection.module;

import dagger.Module;
import dagger.Provides;
import me.kamili.rachid.weather.api.ApiService;
import me.kamili.rachid.weather.injection.scope.PerActivity;
import me.kamili.rachid.weather.view.search.SearchView;
import retrofit2.Retrofit;

@Module
public class SearchModule {

    private SearchView mView;

    public SearchModule(SearchView view) {
        mView = view;
    }

    @PerActivity
    @Provides
    SearchView provideView() {
        return mView;
    }

    @PerActivity
    @Provides
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

}
