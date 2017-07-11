package com.example.chiachen.loginpractice;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by chiachen on 2017/7/11.
 */

public class ServiceFactory {
	public static <T> T createServiceFrom(final Class<T> serviceClass, String endpoint) {
		Retrofit adapter = new Retrofit.Builder()
				.baseUrl(endpoint)
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		return adapter.create(serviceClass);
	}


	static class Authorization {
		private String name;
		private String pwd;

		Authorization(String name, String pwd) {
			this.name = name;
			this.pwd = pwd;
		}
	}

	static class TokenBean{
		Token token;

		 static class Token {
			private String name;
			private Integer iat;
			private Integer exp;
			private String token;
		}
	}
}
