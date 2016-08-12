package com.example.arivas.retrofitexample.interfaces.presenters;

import com.example.arivas.retrofitexample.views.MainActivity;

import java.util.Map;

/**
 * Created by arivas on 02/08/2016.
 */
public interface MainActivityPresenterI {

    void onCreate(MainActivity mainActivity);

    void onConnection();

    void loadProducts();
    void loadProduct();

    void loadPersona() throws Exception;

    void login(String securityLanguage, String securityLogin, String securitySubmit, String securityPassword);

   void loadClaim (Map <String, String> headers);

}
