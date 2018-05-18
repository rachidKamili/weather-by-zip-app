package me.kamili.rachid.weather.injection.component;

import dagger.Component;
import me.kamili.rachid.weather.injection.module.DetailsModule;
import me.kamili.rachid.weather.injection.scope.PerActivity;
import me.kamili.rachid.weather.view.details.DetailsActivity;

@PerActivity
@Component(modules = DetailsModule.class, dependencies = ApplicationComponent.class)
public interface DetailsComponent {
    void inject(DetailsActivity activity);
}