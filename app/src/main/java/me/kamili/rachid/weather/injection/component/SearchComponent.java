package me.kamili.rachid.weather.injection.component;

import dagger.Component;
import me.kamili.rachid.weather.injection.module.SearchModule;
import me.kamili.rachid.weather.injection.scope.PerActivity;
import me.kamili.rachid.weather.view.search.SearchActivity;

@PerActivity
@Component(modules = SearchModule.class, dependencies = ApplicationComponent.class)
public interface SearchComponent {
    void inject(SearchActivity activity);
}