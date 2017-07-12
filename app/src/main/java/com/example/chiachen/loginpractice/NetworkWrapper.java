package com.example.chiachen.loginpractice;

import android.util.Log;


import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by chiachen on 2017/7/11.
 */

public class NetworkWrapper {

	private static void Tag(String tag) {
		Log.e(NetworkWrapper.class.getSimpleName(), tag);
	}

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

	public static void getDataList(){
		LoginService loginService = ServiceFactory.createServiceFrom(LoginService.class, LoginService.ENDPOINT);
		loginService.getUserList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoia2VuIiwiaWF0IjoxNDk5Nzc4NjI5LCJleHAiOjE0OTk3ODIyMjl9.evTgmisq3FrII0a3LB9XG7uxetoKNXBX-eacb2VsMcE")
				.subscribeOn(Schedulers.newThread())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Observer<ServiceFactory.Datas>() {
					@Override
					public void onCompleted() {
						Tag("onCompleted");
					}

					@Override
					public void onError(Throwable e) {
						Tag("onError");
					}

					@Override
					public void onNext(ServiceFactory.Datas datas) {
						Tag("onNext");
					}
				});
	}

	public static void getDatasList(){
		LoginService loginService = ServiceFactory.createServiceFrom(LoginService.class, LoginService.ENDPOINT);
		loginService.getToken(new ServiceFactory.Authorization("ken","hello"))
				.subscribeOn(Schedulers.newThread())
				.flatMap(tokenBean -> loginService.getUserList(tokenBean.token.getToken()))
				.subscribe(
						datas -> {
							Tag("Get");
						},
						throwable -> {
							Tag(throwable.getMessage());
						});
	}
}
