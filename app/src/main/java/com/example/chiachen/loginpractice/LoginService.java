package com.example.chiachen.loginpractice;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by chiachen on 2017/7/7.
 */

public interface LoginService {
	String ENDPOINT = "http://52.197.192.141:3443";

	@POST("/")
	@Headers( "Content-Type: application/json")
	Observable<ServiceFactory.TokenBean> getToken(@Body ServiceFactory.Authorization authorization);

	// @GET("/member")
	// Observable<ServiceFactory.Datalist> getUserList(@Header("Authorization") String authorization);

}
