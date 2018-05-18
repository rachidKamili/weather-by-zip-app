package me.kamili.rachid.weather.view.base;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BasePresenter<V extends BaseView> {

    @Inject
    protected V mView;

    protected V getView() {
        return mView;
    }

    protected void dettachView() {
        mView = null;
    }

    protected <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        observable
                .debounce(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
