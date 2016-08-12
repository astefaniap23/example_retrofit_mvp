package com.example.arivas.retrofitexample.retrofit.service;


import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arivas on 01/08/2016.
 */
public class BaseService {

    public static String BASE_URL = "http://192.168.0.134:9080/";
    private String baseUrl;
    private Retrofit retrofit;
    private String idSession;
    private String token;
    private String iso;
    private Map headers;

    public BaseService(String baseUrl) {
        this.baseUrl = baseUrl;


        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public BaseService(String baseUrl, Map headers) {
        this.baseUrl = baseUrl;
        this.headers = headers;

        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public BaseService() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public BaseService(String baseUrl, String idSession, String token, String iso) {

        this.baseUrl = baseUrl;
        this.idSession = idSession == null ? "" : idSession;
        this.token = token == null ? "" : token;
        this.iso = iso == null ? "" : iso;

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                                    @Override
                                    public Response intercept(Interceptor.Chain chain) throws IOException {
                                        Request original = chain.request();
                                        Request request = original.newBuilder()
                                                .header("Accept-Language", "en-US,en;q=0.5")
                                                .header("accept-charset", "UTF-8")
                                                .header("Content-Type", "text/html; charset=UTF-8")
                                                .header("SECURITY.MOBIL.WAY", "true")
                                                .header("idSession", BaseService.this.idSession)
                                                .header("token", BaseService.this.token)
                                                .header("iso", BaseService.this.iso)
                                                .method(original.method(), original.body())
                                                .build();
                                        return chain.proceed(request);
                                    }
                                }
                ).build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }


    public BaseService(String idSession, String token, String iso) {

        this.idSession = idSession == null ? "" : idSession;
        this.token = token == null ? "" : token;
        this.iso = iso == null ? "" : iso;

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                                    @Override
                                    public Response intercept(Interceptor.Chain chain) throws IOException {
                                        Request original = chain.request();
                                        Request request = original.newBuilder()
                                                .header("Accept-Language", "en-US,en;q=0.5")
                                                .header("accept-charset", "UTF-8")
                                                .header("Content-Type", "text/html; charset=UTF-8")
                                                .header("SECURITY.MOBIL.WAY", "true")
                                                .header("idSession", BaseService.this.idSession)
                                                .header("token", BaseService.this.token)
                                                .header("iso", BaseService.this.iso)
                                                .method(original.method(), original.body())
                                                .build();
                                        return chain.proceed(request);
                                    }
                                }
                ).build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }




    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public String getIdSession() {
        return idSession;
    }

    public void setIdSession(String idSession) {
        this.idSession = idSession;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Map getHeaders() {
        return headers;
    }

    public void setHeaders(Hashtable headers) {
        this.headers = headers;
    }
}



