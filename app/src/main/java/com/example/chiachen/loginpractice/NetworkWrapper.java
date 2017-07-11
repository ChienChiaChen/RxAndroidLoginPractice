package com.example.chiachen.loginpractice;

import android.util.Log;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by chiachen on 2017/7/11.
 */

public class NetworkWrapper {

	public static void getToken(String name, String pwd) {
		LoginService loginService = ServiceFactory.createServiceFrom(LoginService.class, LoginService.ENDPOINT);

		loginService.getToken(new ServiceFactory.Authorization(name, pwd))
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<ServiceFactory.TokenBean>() {
					@Override
					public void onCompleted() {
						Tag("onCompleted");
					}

					@Override
					public void onError(Throwable e) {
						Tag("onError");
					}

					@Override
					public void onNext(ServiceFactory.TokenBean tokenBean) {
						Tag("onNext");
					}
				});
	}


	private static void Tag(String tag) {
		Log.e(NetworkWrapper.class.getSimpleName(), tag);
	}
}
