package com.example.arivas.retrofitexample;

import android.app.Application;

import com.example.arivas.retrofitexample.retrofit.pojo.Login;

/**
 * Created by arivas on 09/08/2016.
 */
public class MvcApplication extends Application {

    private Login login;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
