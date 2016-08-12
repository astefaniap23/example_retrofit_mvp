package com.example.arivas.retrofitexample.retrofit.service;

import android.util.Log;

import com.example.arivas.retrofitexample.retrofit.interfaces.AgentClaimServiceI;
import com.example.arivas.retrofitexample.retrofit.interfaces.ServiceInterface;
import com.example.arivas.retrofitexample.retrofit.pojo.Claim;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by aportillo on 11/08/2016.
 */
public class ServiceGenerator<T> extends BaseService {

    public void response(Call<T> call, final ServiceInterface serviceInterface) {
        call.enqueue(new Callback<T>() { //Metodo que se encarga de manejar la respuesta del callback

            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.i("json: ", new Gson().toJson(response.body()));
                        serviceInterface.onSuccess(response.body());
                    } else {
                        serviceInterface.onError();
                        throw new Exception("Is Not Successful.");
                    }
                } catch (Exception e) {
                    Log.e("Error: ", e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.d("onFailure", t.getMessage());
            }
        });
    }
}