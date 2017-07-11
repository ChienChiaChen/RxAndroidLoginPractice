package com.example.chiachen.loginpractice;

import android.util.Log;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by chiachen on 2017/7/11.
 */

public class NetworkWrapper {

	public static void getToken(String name, String pwd) {
		LoginService loginService = ServiceFactory.createServiceFrom(LoginService.class, LoginService.ENDPOINT);

		Call<ServiceFactory.TokenBean> call = loginService.getToken(new ServiceFactory.Authorization(name, pwd));
		call.enqueue(new Callback<ServiceFactory.TokenBean>() {
			@Override
			public void onResponse(Response<ServiceFactory.TokenBean> response, Retrofit retrofit) {
				Tag("onResponse");
			}

			@Override
			public void onFailure(Throwable t) {
				Tag("onFailure");
			}
		});
	}


	private static void Tag(String tag) {
		Log.e(NetworkWrapper.class.getSimpleName(), tag);
	}
}
