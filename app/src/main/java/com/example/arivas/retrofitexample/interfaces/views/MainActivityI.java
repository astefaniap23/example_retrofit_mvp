package com.example.arivas.retrofitexample.interfaces.views;

import android.view.View;

/**
 * Created by arivas on 09/08/2016.
 */
public interface MainActivityI {

    void setTextView(String text);

    void login();

    void clearQATextView(View v);

    void personas();

    void products();

    void product();

    void claim() throws Exception;
}
