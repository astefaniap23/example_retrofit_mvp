package com.example.arivas.retrofitexample.retrofit.service;


import com.example.arivas.retrofitexample.retrofit.interfaces.LoginServiceI;


/**
 * Created by arivas on 01/08/2016.
 */
public class LoginService extends BaseService{

    private LoginServiceI loginServiceI;

    public LoginService() {
        super();
        this.loginServiceI =  getRetrofit().create(LoginServiceI.class);
    }

    public LoginService(String idSession, String token, String iso) {
        super(idSession, token, iso);
        this.loginServiceI =  getRetrofit().create(LoginServiceI.class);
    }

    public LoginServiceI getLoginServiceI() {
        return loginServiceI;
    }
}
