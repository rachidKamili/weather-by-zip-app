package me.kamili.rachid.weather.view.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.kamili.rachid.weather.R;
import me.kamili.rachid.weather.injection.component.DaggerDetailsComponent;
import me.kamili.rachid.weather.injection.module.DetailsModule;
import me.kamili.rachid.weather.model.WeatherResponse;
import me.kamili.rachid.weather.view.base.BaseActivity;

public class DetailsActivity extends BaseActivity implements DetailsView {

    public static final String WEATHER = "WEATHER";

    @BindView(R.id.details_layout)
    ConstraintLayout mConstraintLayout;

    @Inject
    DetailsPresenter mPresenter;
    @BindView(R.id.tv_desc_name)
    TextView tvDescName;
    @BindView(R.id.tv_temp)
    TextView tvTemp;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.tv_wind)
    TextView tvWind;
    @BindView(R.id.tv_cloud)
    TextView tvCloud;
    @BindView(R.id.tv_pressure)
    TextView tvPressure;
    @BindView(R.id.tv_humidity)
    TextView tvHumidity;
    @BindView(R.id.tv_sunrise)
    TextView tvSunrise;
    @BindView(R.id.tv_city)
    TextView tvCity;

    @Override
    protected int getContentView() {
        return R.layout.activity_details;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerDetailsComponent.builder()
                .applicationComponent(getApplicationComponent())
                .detailsModule(new DetailsModule(this))
                .build().inject(this);
    }

    @Override
    protected void onActivityReady(Bundle savedInstanceState, Intent intent) {

        //Back support
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        WeatherResponse weather = intent.getParcelableExtra(WEATHER);

        if (weather != null) {
            mPresenter.setWeatherDetails(weather);
        } else {
            onShowSnackBar("No results");
        }
    }

    @Override
    public void setWeatherDetails(String descriptionName, String description, String temp,
                                  String windSpeed, String cloudiness, String pressure,
                                  String humidity, String sunrise, String city) {
        tvDescName.setText(descriptionName);
        tvDesc.setText(description);
        tvTemp.setText(temp);
        tvWind.setText(windSpeed);
        tvCloud.setText(cloudiness);
        tvPressure.setText(pressure);
        tvHumidity.setText(humidity);
        tvSunrise.setText(sunrise);
        tvCity.setText(city);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.hamburger_menu, menu);
        return true;
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowSnackBar(String message) {
        Snackbar.make(mConstraintLayout, message, Snackbar.LENGTH_LONG).show();
    }
}
