package com.example.arivas.retrofitexample.retrofit.interfaces;

import com.example.arivas.retrofitexample.retrofit.pojo.Login;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by arivas on 01/08/2016.
 */
public interface LoginServiceI {

    @POST("WController/mobile/quoter/MobileServices")
    Call<Login> login(
            @Header("SecurityLanguage") String securityLanguage,
            @Header("SecurityLogin") String securityLogin,
            @Header("SecuritySubmit") String securitySubmit,
            @Header("SecurityPassword") String securityPassword
    );

}
