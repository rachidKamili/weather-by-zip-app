package me.kamili.rachid.weather.view.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import me.kamili.rachid.weather.R;
import me.kamili.rachid.weather.injection.component.DaggerSearchComponent;
import me.kamili.rachid.weather.injection.module.SearchModule;
import me.kamili.rachid.weather.model.WeatherResponse;
import me.kamili.rachid.weather.view.base.BaseActivity;
import me.kamili.rachid.weather.view.details.DetailsActivity;

public class SearchActivity extends BaseActivity implements SearchView {

    @BindView(R.id.search_layout)
    RelativeLayout mLayout;
    @BindView(R.id.input_zip)
    EditText mZipCodeSearch;

    @Inject
    protected SearchPresenter mPresenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_search;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerSearchComponent.builder()
                .applicationComponent(getApplicationComponent())
                .searchModule(new SearchModule(this))
                .build().inject(this);
    }

    @Override
    protected void onActivityReady(Bundle savedInstanceState, Intent intent) {

    }

    @OnClick(R.id.search_btn)
    void onSearch(Button button){
        String zip = mZipCodeSearch.getText().toString();
        mPresenter.validateZipCode(zip);
    }

    @Override
    public void onGoDetails(WeatherResponse weather) {
        Intent intent = new Intent(getApplicationContext() , DetailsActivity.class);
        intent.putExtra(DetailsActivity.WEATHER,weather);
        startActivity(intent);
    }

    @Override
    public void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }

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
        Snackbar.make(mLayout, message, Snackbar.LENGTH_LONG).show();
    }

}
