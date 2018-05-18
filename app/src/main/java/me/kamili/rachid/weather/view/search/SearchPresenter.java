package me.kamili.rachid.weather.view.search;

import android.content.Context;
import android.util.Log;
import android.util.MalformedJsonException;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.kamili.rachid.weather.api.ApiService;
import me.kamili.rachid.weather.model.WeatherResponse;
import me.kamili.rachid.weather.utils.NetworkUtils;
import me.kamili.rachid.weather.utils.ZipCodeValidator;
import me.kamili.rachid.weather.view.base.BasePresenter;

public class SearchPresenter extends BasePresenter<SearchView> implements Observer<WeatherResponse> {

    private static final String TAG = SearchPresenter.class.getSimpleName();
    private Context mContext;

    @Inject
    protected ApiService mApiService;
    private Observable<WeatherResponse> mWeatherObservable;

    @Inject
    public SearchPresenter(Context context) {
        mContext = context;
    }

    public void validateZipCode(String zip) {
        getView().hideKeyboard();

        //Checking if the device is connected to the internet
        if (NetworkUtils.isInternetAvailable(mContext)){
            zip = zip.trim();

            //Checking if its a valid zip code
            if (ZipCodeValidator.isValidZipCode(zip)) {
                getWeatherDetails(zip);
            } else {
                getView().onShowSnackBar("Invalid Zip code.");
            }
        }else {
            getView().onShowSnackBar("No Internet connection.");
        }
    }

    //Get Weather details
    private void getWeatherDetails(String zipCode){
        getView().onShowDialog("Loading....");

        //Create the request
        mWeatherObservable = mApiService.getWeather(zipCode + ",us");

        //Subscribe
        subscribe(mWeatherObservable, this);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(WeatherResponse weather) {
        getView().onHideDialog();

        getView().onGoDetails(weather);
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        Log.d(TAG, "onError: " + e.getMessage());
        getView().onShowSnackBar("Invalid Zip code.");
    }

    @Override
    public void onComplete() {

    }

}
