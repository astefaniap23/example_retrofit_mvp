package com.example.arivas.retrofitexample.retrofit.interfaces;


/**
 * Created by aportillo on 05/08/2016.
 */
public interface ServiceInterface<T> {
        void onSuccess(T Objet);
        void onError();
}
